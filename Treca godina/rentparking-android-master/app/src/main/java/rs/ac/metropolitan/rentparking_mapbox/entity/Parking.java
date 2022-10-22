package rs.ac.metropolitan.rentparking_mapbox.entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Parking implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("location")
    private Location location;
    @SerializedName("user")
    private User user;
    @SerializedName("name")
    private String name;
    @SerializedName("parkingPic")
    private String parkingPic;
    @SerializedName("description")
    private String description;
    @SerializedName("length")
    private Double length;
    @SerializedName("width")
    private Double width;
    @SerializedName("price")
    private Double price;

    public Parking() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParkingPic() {
        return parkingPic;
    }

    public void setParkingPic(String parkingPic) {
        this.parkingPic = parkingPic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", location=" + location +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", parkingPic='" + parkingPic + '\'' +
                ", description='" + description + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", price=" + price +
                '}';
    }
}