package com.ead.fuelmart.model;

import com.google.gson.annotations.SerializedName;

public class Admin {
    @SerializedName("totalArivalBycicles")
    public  Integer totalArivalBycicles;
    @SerializedName("totalArivalThreewheels")
    public  Integer totalArivalThreewheels;
    @SerializedName("totalArivalPOtherVehicles")
    public  Integer totalArivalPOtherVehicles;
    @SerializedName("totalArivalLorries")
    public  Integer totalArivalLorries;
    @SerializedName("totalArivalDOtherVehicles")
    public  Integer totalArivalDOtherVehicles;
    @SerializedName("totalArivalBuses")
    public  Integer totalArivalBuses;


    public Admin(Integer totalArivalBycicles, Integer totalArivalThreewheels, Integer totalArivalOtherVehicles, Integer totalArivalLorries, Integer totalArivalDOtherVehicles, Integer totalArivalBuses) {
        this.totalArivalBycicles = totalArivalBycicles;
        this.totalArivalThreewheels = totalArivalThreewheels;
        this.totalArivalPOtherVehicles = totalArivalOtherVehicles;
        this.totalArivalLorries = totalArivalLorries;
        this.totalArivalDOtherVehicles = totalArivalDOtherVehicles;
        this.totalArivalBuses = totalArivalBuses;
    }
}



