package com.example.clubiqoapp;

import android.util.Log;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataController {
    public static ArrayList<EventResponse> getEvents(){
        ArrayList<EventResponse> eventList=new ArrayList<>();
        ApiService apiService;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://oracleapex.com/ords/wksp_clubiqo/members_api/") // Replace with your actual base path
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        // 2. Fetch the data
        apiService.getAllEvents().enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                if (response.isSuccessful() && response.body() != null) {

                    // Clear the list to prevent duplicates on refresh
                    eventList.clear();

                    // Add all items from the response to our ArrayList
                    eventList.addAll(response.body().items);

                    Log.d("API_SUCCESS", "Successfully loaded " + eventList.size() + " events.");

                    // Loop through to check data in Logcat
                    for (EventResponse event : eventList) {
                        Log.d("EVENT_INFO", "Title: " + event.getTitle());
                    }

                    // TODO: Update your UI/RecyclerView adapter here
                } else {
                    Log.e("API_ERROR", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {
                Log.e("API_ERROR", "Network Failure: " + t.getMessage());
            }
        });



        return eventList;
    }
    public static ArrayList<NewsResponse> getNews() {
        ArrayList<NewsResponse> newsList = new ArrayList<>();

        return newsList;
    }

    public static boolean signup(String fullname,String nID,String email,String phoneNumber,LocalDate bDate){

        return true;
    }

    public static boolean login(String email,String password){

        return true;
    }

    public static void uploadToken(String token,String expiryDate){

    }

    public static void resetPassword(String email){

    }
    public static Member getProfileInfo(){
        Member profile1=new Member(1111111,
                LocalDate.now(),
                "Active",
                "Admin",
                "52925815",
                "Ben youssef",
                "Rayen",
                "12345678",
                "rayenbenyoussef815@gmail.com");

        return profile1;
    }

    public static boolean updateProfile(String fullname,String phoneNumber,String password){

        return true;
    }

    public static boolean registerInEvent(String token,String event_id){

        return true;
    }

    public static boolean confirmRegistration(String token,String event_id){

        return true;
    }

    public static boolean cancelRegistration(String token,String event_id){

        return true;
    }

    public static Participation getParticipationInfo(String token,String eventId){
        Participation participation = new Participation(
                "1",
                "101",
                "present",
                LocalDateTime.now(),
                "Organizer"
        );

        return participation;

    }

}

