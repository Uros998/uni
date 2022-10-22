package rs.ac.metropolitan.rentparking_mapbox.service;


import java.time.LocalDateTime;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rs.ac.metropolitan.rentparking_mapbox.entity.Booking;
import rs.ac.metropolitan.rentparking_mapbox.entity.data.domen.BookingStatus;
import rs.ac.metropolitan.rentparking_mapbox.entity.data.dto.BookingDTO;

public interface BookingService {

    List<Booking> findAll();

    @POST("bookings/booking-dto")
    Call<BookingDTO> saveBookingDTO(@Body BookingDTO bookingDTO);

    Booking save(Booking booking);

    void automaticChangeBookingStatus();

    Booking update(Booking booking);

    Booking findById(Integer bookingId);

    List<Booking> findAllByUserId(Integer userId);

    void deleteById(Integer bookingId);

    List<Booking> findAllByBookingStatusAndLocationName(BookingStatus bookingStatus, String name);

    List<Booking> findAllByBookingStatusAndLocationCity(BookingStatus bookingStatus, String city);

    @GET("bookings/{city}/booking_dto")
    Call<List<BookingDTO>> findAllBookingDTO(@Path("city") String city, @Query("from") LocalDateTime from, @Query("to") LocalDateTime to);

    // List<BookingDTO> findAllBookingDTOByCityAndFromAndTo(String city, LocalDateTime from, LocalDateTime to);

}