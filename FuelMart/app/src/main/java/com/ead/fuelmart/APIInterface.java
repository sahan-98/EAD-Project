package com.ead.fuelmart;

import com.ead.fuelmart.model.Admin;
import com.ead.fuelmart.model.Station;
import com.ead.fuelmart.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface APIInterface {

    @POST("/api/v1/users/signup")
    Call<User> createUser(@Body User user);


    @GET("/api/v1/stations/{district}/{town}")
    Call<Station> doGetStationList(@Path(value="district", encoded=true) String district, @Path(value="town", encoded=true) String town);

    @GET("/api/v1/stations/{id}")
    Call<Station> doGetStationById(@Path(value="id", encoded=true)String id);

    @GET("/api/v1/admin/count/{id}")
    Call<Admin> doGetStationQue(@Path(value="id", encoded=true)String id);

//    @GET("/api/users?")
//    Call<UserList> doGetUserList(@Query("page") String page);
//
//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
