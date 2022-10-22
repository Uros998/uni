package rs.ac.metropolitan.rentparking_mapbox.entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements Serializable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("name")
	private String name;
	@SerializedName("adress")
	private String address;
	@SerializedName("city")
	private String city;
	@SerializedName("longitude")
	private Double longitude;
	@SerializedName("latitude")
	private Double latitude;

	public Location() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Location{" +
				"id=" + id +
				", name='" + name + '\'' +
				", address='" + address + '\'' +
				", city='" + city + '\'' +
				", longitude=" + longitude +
				", latitude=" + latitude +
				'}';
	}
}