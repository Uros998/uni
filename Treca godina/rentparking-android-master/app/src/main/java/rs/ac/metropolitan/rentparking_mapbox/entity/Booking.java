package rs.ac.metropolitan.rentparking_mapbox.entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.*;

import rs.ac.metropolitan.rentparking_mapbox.entity.data.domen.BookingStatus;

public class Booking implements Serializable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("parking")
	private Parking parking;
	@SerializedName("user")
	private User user;
	@SerializedName("to")
	private String to;
	@SerializedName("from")
	private String from;
	@SerializedName("bookingStatus")
	private BookingStatus bookingStatus;

	public Booking() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "Booking{" +
				"id=" + id +
				", parking=" + parking +
				", user=" + user +
				", to=" + to +
				", from=" + from +
				", bookingStatus=" + bookingStatus +
				'}';
	}
}