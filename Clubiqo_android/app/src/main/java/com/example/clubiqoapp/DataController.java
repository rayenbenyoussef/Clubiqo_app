package com.example.clubiqoapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
    private static final String PREFS_NAME = "user_prefs";
    public static ArrayList<Event> getEvents(){
        ArrayList<Event> eventList=new ArrayList<>();
        eventList.add(new Event(
                "1",
                0,                   // paymentAmount, 0 if free
                50,                  // max participants
                null,                // locationLink
                "University Hall",   // locationTitle
                LocalDate.of(2026, 3, 25).atStartOfDay(),
                "JCI Club organized a leadership workshop to improve skills and teamwork.",
                "JCI Leadership Workshop",
                "https://i.pinimg.com/736x/9f/40/88/9f4088384f8ab030e8828a94102d50b7.jpg",  // cover URL
                "https://i.pinimg.com/736x/9f/40/88/9f4088384f8ab030e8828a94102d50b7.jpg"   // img URL
        ));

        // IEEE Robotics Meetup
        eventList.add(new Event(
                "2",
                0,
                40,
                null,
                "Engineering Lab",
                LocalDate.of(2026, 4, 5).atStartOfDay(),
                "The IEEE Club hosted a robotics meetup, introducing students to modern robotics technologies.",
                "IEEE Robotics Meetup",
                "https://i.pinimg.com/736x/52/63/0f/52630fe11a28d45aadfa9385df24e686.jpg",
                "https://i.pinimg.com/736x/52/63/0f/52630fe11a28d45aadfa9385df24e686.jpg"
        ));

        // JCI Community Service
        eventList.add(new Event(
                "3",
                0,
                30,
                null,
                "City Park",
                LocalDate.of(2026, 4, 15).atStartOfDay(),
                "JCI members volunteered in a community clean-up and awareness campaign.",
                "JCI Community Service Event",
                "https://i.pinimg.com/736x/bb/3d/a6/bb3da6f6dd9a22860a1784104e71b918.jpg",
                "https://i.pinimg.com/736x/bb/3d/a6/bb3da6f6dd9a22860a1784104e71b918.jpg"
        ));

        // IEEE Tech Talk: AI Trends
        eventList.add(new Event(
                "4",
                0,
                60,
                null,
                "Engineering Auditorium",
                LocalDate.of(2026, 5, 10).atStartOfDay(),
                "IEEE Club presented a tech talk on AI and machine learning trends with industry experts.",
                "IEEE Tech Talk: AI Trends",
                "https://i.pinimg.com/736x/84/c3/b3/84c3b314077c5ab73949b08cd6d2be97.jpg",
                "https://i.pinimg.com/736x/84/c3/b3/84c3b314077c5ab73949b08cd6d2be97.jpg"
        ));

        // JCI Annual Cultural Night
        eventList.add(new Event(
                "5",
                10,   // small ticket price
                100,
                null,
                "University Cafeteria",
                LocalDate.of(2026, 5, 20).atStartOfDay(),
                "Celebrate culture and diversity with JCI Club's annual cultural night event.",
                "JCI Annual Cultural Night",
                "https://i.pinimg.com/736x/f4/49/99/f449991b5381d26852c7af37eab4cd82.jpg",
                "https://i.pinimg.com/736x/f4/49/99/f449991b5381d26852c7af37eab4cd82.jpg"
        ));
        return eventList;
    }
    public static ArrayList<News> getNews() {
        ArrayList<News> newsList = new ArrayList<>();
        newsList.add(new News(
                "JCI Leadership Bootcamp",
                "JCI Club held a 3-day leadership bootcamp to enhance teamwork, communication, and problem-solving skills.",
                "https://i.pinimg.com/736x/3d/03/8d/3d038dc57e98f475fdd9a4cfe1f17f47.jpg",
                "https://www.linkedin.com/in/rayen-ben-youssef-a7b727361"
        ));

        newsList.add(new News(
                "IEEE Hackathon 2026",
                "IEEE Club organized a 48-hour hackathon, inviting students to build innovative tech projects and prototypes.",
                "https://i.pinimg.com/736x/4e/84/78/4e8478aaf66a577f5eba1f188f0af944.jpg",
                "https://www.linkedin.com/in/rayen-ben-youssef-a7b727361"
        ));

        newsList.add(new News(
                "JCI Innovation Workshop",
                "Students collaborated in JCI Club's innovation workshop to solve real-world problems using creative thinking.",
                "https://i.pinimg.com/736x/53/64/83/5364831dfb973d305347034b45a8dc1c.jpg",
                "https://www.linkedin.com/in/rayen-ben-youssef-a7b727361"
        ));

        newsList.add(new News(
                "IEEE Robotics Meetup",
                "IEEE Club hosted a robotics meetup, demonstrating cutting-edge technology and team challenges for members.",
                "https://i.pinimg.com/736x/8f/4c/b1/8f4cb1beceb60276fc4f8e35dcc3419c.jpg",
                "https://www.linkedin.com/in/rayen-ben-youssef-a7b727361"
        ));

        newsList.add(new News(
                "JCI Cultural Night",
                "JCI Club celebrated diversity with its annual cultural night, featuring performances, exhibitions, and networking.",
                "https://i.pinimg.com/736x/c2/7d/66/c27d66caeb9dacd32bb3cf0a9cd822e5.jpg",
                "https://www.linkedin.com/in/rayen-ben-youssef-a7b727361"
        ));

        newsList.add(new News(
                "IEEE AI & ML Seminar",
                "IEEE Club organized a seminar on AI & Machine Learning trends with industry experts sharing insights and projects.",
                "https://i.pinimg.com/736x/e8/82/b2/e882b2d178d1493a8471d445adf2641c.jpg",
                "https://www.linkedin.com/in/rayen-ben-youssef-a7b727361"
        ));

        newsList.add(new News(
                "JCI Community Networking",
                "JCI Club hosted a networking session for students to meet alumni and professionals for career guidance.",
                "https://i.pinimg.com/736x/75/e0/0d/75e00dbc9e41437003947b286bda03e2.jpg",
                "https://www.linkedin.com/in/rayen-ben-youssef-a7b727361"
        ));

        newsList.add(new News(
                "IEEE Coding Competition",
                "IEEE Club's coding competition challenged participants to solve algorithmic and programming problems under time constraints.",
                "https://i.pinimg.com/736x/85/6c/26/856c265c284cff06aa224667e3071efb.jpg",
                "https://www.linkedin.com/in/rayen-ben-youssef-a7b727361"
        ));
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
                "AZERTYUI1213",
                LocalDate.now(),
                "Active",
                "Admin",
                "52925815",
                "Ben youssef",
                "Rayen",
                "admin",
                "admin@admin.com",
                "https://i.pinimg.com/736x/6d/20/2d/6d202d38b84c6ec1011f6b3f3cf848e8.jpg");

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
                null,
                LocalDateTime.now(),
                "Organizer"
        );

        return participation;

    }

}

