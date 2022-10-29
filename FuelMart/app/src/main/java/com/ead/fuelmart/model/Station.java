package com.ead.fuelmart.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Station {
    @SerializedName("diesel")
    public  Boolean diesel;
    @SerializedName("petrol")
    public  Boolean petrol;
    @SerializedName("data")
    public List<Datum> data = new ArrayList();


    public class Datum {
        @SerializedName("stationid")
        public  String stationid;
        @SerializedName("stationName")
        public  String stationName;
        @SerializedName("district")
        public String district;
        @SerializedName("town")
        public String town;
        }

    public Station(Boolean diesel, Boolean petrol) {
        this.diesel = diesel;
        this.petrol = petrol;
    }
}
