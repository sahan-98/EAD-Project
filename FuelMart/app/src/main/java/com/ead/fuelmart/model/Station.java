package com.ead.fuelmart.model;
import com.google.gson.annotations.SerializedName;

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

    public Station(String station, String password, String province, String district, String town) {
        this.station = station;
        this.password = password;
        this.province = province;
        this.district = district;
        this.town = town;
    }
}
