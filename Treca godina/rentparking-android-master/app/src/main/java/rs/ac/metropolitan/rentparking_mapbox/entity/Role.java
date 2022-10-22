package rs.ac.metropolitan.rentparking_mapbox.entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;

    public Role() {
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}