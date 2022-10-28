package com.ead.fuelmart.model;
import com.google.gson.annotations.SerializedName;

public class AuthUser {
    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;

    public AuthUser(String email,String password) {

        this.email = email;
        this.password = password;

    }
}
