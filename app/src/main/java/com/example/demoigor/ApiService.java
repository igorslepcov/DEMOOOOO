package com.example.demoigor;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST ("/auth/login")
    Call<LoginResponce> loginUser(@Body LoginRequest loginRequest);
    @POST("/auth/registar")
            Call<LoginResponce> Registarr(@Body LoginRequest loginRequest);
}
