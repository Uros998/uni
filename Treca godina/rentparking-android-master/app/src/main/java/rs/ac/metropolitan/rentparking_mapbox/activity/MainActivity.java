package rs.ac.metropolitan.rentparking_mapbox.activity;

import android.Manifest;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.JsonObject;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.LocationComponentActivationOptions;
import com.mapbox.mapboxsdk.location.OnCameraTrackingChangedListener;
import com.mapbox.mapboxsdk.location.OnLocationClickListener;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.PlaceAutocomplete;
import com.mapbox.mapboxsdk.plugins.places.autocomplete.model.PlaceOptions;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rs.ac.metropolitan.rentparking_mapbox.R;
import rs.ac.metropolitan.rentparking_mapbox.adapter.CardAdapter;
import rs.ac.metropolitan.rentparking_mapbox.entity.data.dto.BookingDTO;
import rs.ac.metropolitan.rentparking_mapbox.service.BookingService;

import static com.google.android.material.bottomsheet.BottomSheetBehavior.*;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        MapboxMap.OnMapClickListener, PermissionsListener, OnCameraTrackingChangedListener, OnLocationClickListener {

    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
    private MapView mapView;
    private MapboxMap mapboxMap;
    private ValueAnimator markerAnimator;
    CarmenFeature home;
    CarmenFeature work;
    private final String geojsonSourceLayerId = "geojsonSourceLayerId";
    private final String symbolIconId = "symbolIconId";
    List<Feature> markerCoordinates = new ArrayList<>();
    private PermissionsManager permissionsManager;
    private boolean isInTrackingMode;
    private LocationComponent locationComponent;
    private ImageView header_Arrow_Image;
    private Retrofit retrofit;
    private static final String TAG = "MainActivity";
    private Button buy;
    private CardAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/rentparking/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));
        setContentView(R.layout.activity_main);
        mapView = findViewById(R.id.mapView);
        mapView.getMapAsync(this);

        LinearLayout mBottomSheetLayout = findViewById(R.id.bottom_sheet_layout);
        BottomSheetBehavior<View> sheetBehavior = from(mBottomSheetLayout);

        header_Arrow_Image = findViewById(R.id.bottom_sheet_arrow);

        header_Arrow_Image.setOnClickListener(v -> {
            if (sheetBehavior.getState() != STATE_EXPANDED) {
                sheetBehavior.setState(STATE_EXPANDED);
                findViewById(R.id.back_to_camera_tracking_mode).setVisibility(View.INVISIBLE);
                findViewById(R.id.fab_location_search).setVisibility(View.INVISIBLE);

            } else {
                sheetBehavior.setState(STATE_COLLAPSED);
                findViewById(R.id.back_to_camera_tracking_mode).setVisibility(View.VISIBLE);
                findViewById(R.id.fab_location_search).setVisibility(View.VISIBLE);
            }

        });
        sheetBehavior.addBottomSheetCallback(new BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                header_Arrow_Image.setRotation(slideOffset * 180);
            }
        });


    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        mapboxMap.setStyle(Style.MAPBOX_STREETS, style -> {
            initSearchFab();
            addUserLocations();
            style.addImage(symbolIconId, BitmapFactory.decodeResource(
                    MainActivity.this.getResources(), R.drawable.mapbox_marker_icon_blue));
            initSearchFab();
            enableLocationComponent(style);
            setUpSource(style);
            setupLayer(style);
        });

    }

    public void getAllBookingDTO(LocalDateTime from, LocalDateTime to, Intent data) {
        CarmenFeature selectedCarmenFeature = PlaceAutocomplete.getPlace(data);
        if (mapboxMap != null) {
            Style style = mapboxMap.getStyle();
            if (style != null) {
                GeoJsonSource source = style.getSourceAs(geojsonSourceLayerId);
                if (source != null) {
                    BookingService bookingService = retrofit.create(BookingService.class);
                    Call<List<BookingDTO>> callBookingDTO = bookingService.findAllBookingDTO(Objects
                            .requireNonNull(selectedCarmenFeature.placeName()).split(",")[0], from, to);

                    ListView lvCards = (ListView) findViewById(R.id.list_cards);
                    adapter = new CardAdapter(this);
                    lvCards.setAdapter(adapter);

                    callBookingDTO.enqueue(new Callback<List<BookingDTO>>() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void onResponse(@NotNull Call<List<BookingDTO>> call, @NotNull Response<List<BookingDTO>> response) {
                            if (!response.isSuccessful()) {
                                System.out.println(response.code());
                            }
                            List<BookingDTO> bookingDTOList = response.body();
                            assert bookingDTOList != null;
                            for (BookingDTO bookingDTO : bookingDTOList) {
                                adapter.add(bookingDTO);

                                markerCoordinates.add(Feature.fromGeometry(
                                        Point.fromLngLat(bookingDTO.getParking().getLocation().getLongitude(),
                                                bookingDTO.getParking().getLocation().getLatitude())));
                            }
                            source.setGeoJson(FeatureCollection.fromFeatures(markerCoordinates));
                        }


                        @Override
                        public void onFailure(@NotNull Call<List<BookingDTO>> call, Throwable t) {
                            System.out.println(t.getMessage() + "DAVIDDDDDDDDDDDDDDDDD");
                        }
                    });
                }
                mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(
                        new CameraPosition.Builder()
                                .target(new LatLng(((Point) Objects.requireNonNull(selectedCarmenFeature.geometry())).latitude(),
                                        ((Point) selectedCarmenFeature.geometry()).longitude()))
                                .zoom(13)
                                .build()), 4000);

            }
        }

    }


    private void addUserLocations() {
        home = CarmenFeature.builder().text("Mapbox SF Office")
                .geometry(Point.fromLngLat(-122.3964485, 37.7912561))
                .placeName("50 Beale St, San Francisco, CA")
                .id("mapbox-sf")
                .properties(new JsonObject())
                .build();

        work = CarmenFeature.builder().text("Mapbox DC Office")
                .placeName("740 15th Street NW, Washington DC")
                .geometry(Point.fromLngLat(-77.0338348, 38.899750))
                .id("mapbox-dc")
                .properties(new JsonObject())
                .build();
    }

    private void initSearchFab() {
        findViewById(R.id.fab_location_search).setOnClickListener(view -> {
            Intent intent = new PlaceAutocomplete.IntentBuilder()
                    .accessToken(Mapbox.getAccessToken() != null ? Mapbox.getAccessToken() : getString(R.string.mapbox_access_token))
                    .placeOptions(PlaceOptions.builder()
                            .backgroundColor(Color.parseColor("#EEEEEE"))
                            .addInjectedFeature(home)
                            .addInjectedFeature(work)
                            .limit(10)
                            .build(PlaceOptions.MODE_CARDS))
                    .build(MainActivity.this);
            startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);
        });
    }


    private void setUpSource(@NonNull Style loadedMapStyle) {
        loadedMapStyle.addSource(new GeoJsonSource(geojsonSourceLayerId));
    }

    private void setupLayer(@NonNull Style loadedMapStyle) {
        loadedMapStyle.addLayer(new SymbolLayer("SYMBOL_LAYER_ID", geojsonSourceLayerId).withProperties(
                iconImage(symbolIconId),
                iconOffset(new Float[]{0f, -8f})
        ));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationComponent.setLocationComponentEnabled(false);
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_AUTOCOMPLETE) {
            getAllBookingDTO(null, null, data);
        }
    }

    @Override
    public boolean onMapClick(@NonNull LatLng point) {
        return true;
    }


    @SuppressWarnings({"MissingPermission"})
    private void enableLocationComponent(@NonNull Style loadedMapStyle) {
        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            locationComponent = mapboxMap.getLocationComponent();
            locationComponent.activateLocationComponent(
                    LocationComponentActivationOptions.builder(this, loadedMapStyle).build());
            locationComponent.setLocationComponentEnabled(true);
//           locationComponent.setCameraMode(CameraMode.TRACKING);
            locationComponent.setRenderMode(RenderMode.COMPASS);
            findViewById(R.id.back_to_camera_tracking_mode).setOnClickListener(view -> {
                if (!isInTrackingMode) {
                    isInTrackingMode = true;
                    locationComponent.setCameraMode(CameraMode.TRACKING);
                    locationComponent.zoomWhileTracking(16f);
                    Toast.makeText(MainActivity.this, "Enabled",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Alredy enabled",
                            Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }

    @Override
    public void onCameraTrackingDismissed() {
        isInTrackingMode = false;
    }

    @Override
    public void onCameraTrackingChanged(int currentMode) {
// Empty on purpose
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {
        Toast.makeText(this, R.string.mapbox_plugins_place_picker_user_location_permission_explanation, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(this::enableLocationComponent);
        } else {
            Toast.makeText(this, R.string.mapbox_plugins_place_picker_user_location_permission_not_granted, Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @SuppressWarnings({"MissingPermission"})
    @Override
    public void onLocationComponentClick() {
        if (locationComponent.getLastKnownLocation() != null) {
            Toast.makeText(this, String.format("CurrentLocation",
                    locationComponent.getLastKnownLocation().getLatitude(),
                    locationComponent.getLastKnownLocation().getLongitude()), Toast.LENGTH_LONG).show();
        }
    }


    @Override
    @SuppressWarnings({"MissingPermission"})
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }


    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

}