package rs.ac.metropolitan.rentparking_mapbox.entity.data.dto;


import com.google.gson.annotations.SerializedName;

import rs.ac.metropolitan.rentparking_mapbox.entity.Booking;
import rs.ac.metropolitan.rentparking_mapbox.entity.Parking;

public class BookingDTO {
    @SerializedName("parking")
    Parking parking;
    @SerializedName("booking")
    Booking booking;

    public BookingDTO() {
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "parking=" + parking +
                ", booking=" + booking +
                '}';
    }
}
