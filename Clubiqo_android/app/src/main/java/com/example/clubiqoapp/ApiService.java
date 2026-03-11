package com.example.clubiqoapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("events")
    Call<EventResponse> getAllEvents();
}
