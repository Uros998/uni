package rs.ac.metropolitan.rentparking_mapbox.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rs.ac.metropolitan.rentparking_mapbox.R;
import rs.ac.metropolitan.rentparking_mapbox.entity.Login;
import rs.ac.metropolitan.rentparking_mapbox.entity.data.dto.BookingDTO;
import rs.ac.metropolitan.rentparking_mapbox.service.AuthService;

public class LoginActivity extends AppCompatActivity {
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.button);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8080/rentparking/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        AuthService authService = retrofit.create(AuthService.class);
        login.setOnClickListener(v -> {
            Login login1 = new Login();
            login1.setUsername("ivanovicdavid788");
            login1.setPassword("ivanovicdavid788123");
            System.out.println(login1.getUsername());
            Call<Object> callLogin = authService.login(login1);
            callLogin.enqueue(new Callback<Object>() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onResponse(@NotNull Call<Object> call, @NotNull Response<Object> response) {
                    if (!response.isSuccessful()) {
                        System.out.println(response.code());
                    }
                    Object login = response.body();

                    System.out.println(login + " LOGINNNNNNNN");

                    if(login != null) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        LoginActivity.this.startActivity(intent);
                    }

                }


                @Override
                public void onFailure(@NotNull Call<Object> call, Throwable t) {
                    System.out.println(t.getMessage() + "DAVIDDDDDDDDDDDDDDDDD");
                }
            });
        });


    }
}
