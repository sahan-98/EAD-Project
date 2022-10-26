package com.ead.fuelmart.model;
import com.google.gson.annotations.SerializedName;
public class User {
    @SerializedName("name")
    public String name;
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;
    @SerializedName("vehicleType")
    public String vehicleType;
    @SerializedName("vehicleNumber")
    public String vehicleNumber;
    @SerializedName("fuelType")
    public String fuelType;

    public User(String name,String email,String password,String vehicleType, String vehicleNumber,String fuelType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.fuelType = fuelType;
    }
}
