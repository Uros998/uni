package rs.ac.metropolitan.rentparking_mapbox.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;


import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rs.ac.metropolitan.rentparking_mapbox.R;
import rs.ac.metropolitan.rentparking_mapbox.entity.Booking;
import rs.ac.metropolitan.rentparking_mapbox.entity.Parking;
import rs.ac.metropolitan.rentparking_mapbox.entity.User;
import rs.ac.metropolitan.rentparking_mapbox.entity.data.domen.BookingStatus;
import rs.ac.metropolitan.rentparking_mapbox.entity.data.dto.BookingDTO;
import rs.ac.metropolitan.rentparking_mapbox.service.BookingService;

public class CardAdapter extends ArrayAdapter<BookingDTO> {
    private LocalDateTime from;
    private LocalDateTime to;
    private String fromStr;
    private String toStr;
    private BookingDTO bookingDTO;
    private Retrofit retrofit;
    private Booking booking = new Booking();
    private User user;
    private Parking parking;
    public CardAdapter(Context context) {
        super(context, R.layout.card_item);
    }

    @SuppressLint({"SetTextI18n", "InflateParams"})
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder; // to reference the child views for later actions

        if (v == null) {
            LayoutInflater vi =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.card_item, null);

            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8080/rentparking/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            // cache view fields into the holder
            holder = new ViewHolder();
            holder.name = (TextView) v.findViewById(R.id.name);
            holder.price = (TextView) v.findViewById(R.id.price);
            holder.image = (ImageView) v.findViewById(R.id.image);
            holder.buy = (Button) v.findViewById(R.id.buy);
            holder.status = (Button) v.findViewById(R.id.status);
            // associate the holder with the view for later lookup


            v.setTag(holder);
        } else {
            // view already exists, get the holder instance from the view
            holder = (ViewHolder) v.getTag();
        }
        bookingDTO = getItem(position);

        parking = bookingDTO.getParking();


//        holder.image.setImage;
        Glide.with(getContext()).load(bookingDTO.getParking().getParkingPic()).into(holder.image);
        holder.name.setText(bookingDTO.getParking().getName());
        holder.price.setText("$" + bookingDTO.getParking().getPrice().toString());
        if (bookingDTO.getBooking() != null) {
            if (bookingDTO.getBooking().getBookingStatus() == BookingStatus.RESERVED) {
                holder.buy.setEnabled(false);
            }
        }

        holder.status.setText(bookingDTO.getBooking() != null ? bookingDTO.getBooking().getBookingStatus().toString() : "FREE");

        View.OnClickListener corkyListener = v1 -> {
            System.out.println(bookingDTO);
            startDateTime();
        };

        holder.buy.setOnClickListener(corkyListener);

        return v;
    }

    static class ViewHolder {
        ImageView image;
        TextView price;
        TextView name;
        Button buy;
        Button status;

        ViewHolder() {
        }
    }

    public void saveBookingDTO() {
        BookingService bookingService = retrofit.create(BookingService.class);

        Call<BookingDTO> callBookingDTO = bookingService.saveBookingDTO(bookingDTO);

        callBookingDTO.enqueue(new Callback<BookingDTO>() {
            @Override
            public void onResponse(@NotNull Call<BookingDTO> call, @NotNull Response<BookingDTO> response) {
                if (!response.isSuccessful()) {
                    System.out.println(response.code());
                }
                BookingDTO bookingDTO = response.body();

                System.out.println(bookingDTO);

            }

            @Override
            public void onFailure(@NotNull Call<BookingDTO> call, Throwable t) {
                System.out.println(t.getMessage() + "DAVIDDDDDDDDDDDDDDDDD");
            }
        });
    }


    private void startDateTime() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);
        boolean is24HourFormat = DateFormat.is24HourFormat(this.getContext());
        booking = new Booking();


        TimePickerDialog timePickerDialog = new TimePickerDialog(this.getContext(), (timePicker, hour, minute) -> {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.HOUR, hour);
            calendar1.set(Calendar.MINUTE, minute);
            System.out.println(fromStr);
            fromStr += DateFormat.format("hh:MM:ss", calendar1).toString();
            System.out.println(fromStr);
            booking.setFrom(fromStr);
            endDateTime();
        }, HOUR, MINUTE, is24HourFormat);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this.getContext(), (datePicker, year, month, date) -> {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.YEAR, year);
            calendar1.set(Calendar.MONTH, month);
            calendar1.set(Calendar.DATE, date);
            fromStr = DateFormat.format("yyyy-MM-ddT", calendar1).toString();
            System.out.println(fromStr + " FROMSTR");
            timePickerDialog.show();
        }, YEAR, MONTH, DATE);

        datePickerDialog.show();

    }

    private void endDateTime() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);
        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);
        boolean is24HourFormat = DateFormat.is24HourFormat(this.getContext());
        user = new User();
        user.setId(4);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this.getContext(), (timePicker, hour, minute) -> {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.HOUR, hour);
            calendar1.set(Calendar.MINUTE, minute);
            toStr += DateFormat.format("hh:mm:ss", calendar1).toString();
            booking.setTo(toStr);
            booking.setParking(bookingDTO.getParking());
            booking.setUser(user);
            bookingDTO.setBooking(booking);
            createNewDialog().show();;
        }, HOUR, MINUTE, is24HourFormat);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this.getContext(), (datePicker, year, month, date) -> {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.YEAR, year);
            calendar1.set(Calendar.MONTH, month);
            calendar1.set(Calendar.DATE, date);
            toStr = DateFormat.format("yyyy-MM-ddT", calendar1).toString();
            timePickerDialog.show();
        }, YEAR, MONTH, DATE);

        datePickerDialog.show();

    }

    public Dialog createNewDialog() {
        AlertDialog dlg = null;
        dlg = new AlertDialog.Builder(getContext())
                .setTitle("Payment")
                .setPositiveButton("Pay", (dialog, which) -> {
                    saveBookingDTO();
                })
                .create();

        return dlg;
    }


}
