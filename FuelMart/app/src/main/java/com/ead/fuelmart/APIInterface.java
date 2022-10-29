package com.ead.fuelmart;

import com.ead.fuelmart.model.AuthUser;
import com.ead.fuelmart.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/api/v1/users/signup")
    Call<User> createUser(@Body User user);

    @POST("/api/v1/users/auth")
    Call<AuthUser> AuthUser(@Body AuthUser user);

//    @POST("/api/v1/users/signup")
//    Call<User> AuthUser(@Body User user);
//
//    @GET("/api/v1/users/:id")
//    Call<User> getUserById();

//    @GET("/api/users?")
//    Call<UserList> doGetUserList(@Query("page") String page);
//
//    @FormUrlEncoded
//    @POST("/api/users?")
//    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}
