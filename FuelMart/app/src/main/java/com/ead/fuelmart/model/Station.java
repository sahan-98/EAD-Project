package com.ead.fuelmart.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Station {
    @SerializedName("station")
    public String station;
    @SerializedName("password")
    public String password;
    @SerializedName("province")
    public String province;
    @SerializedName("district")
    public String district;
    @SerializedName("town")
    public String town;
    
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

    public Station(String station, String password, String province, String district, String town) {
        this.station = station;
        this.password = password;
        this.province = province;
        this.district = district;
        this.town = town;
    }
    
        public Station(Boolean diesel, Boolean petrol) {
        this.diesel = diesel;
        this.petrol = petrol;
    }
}
