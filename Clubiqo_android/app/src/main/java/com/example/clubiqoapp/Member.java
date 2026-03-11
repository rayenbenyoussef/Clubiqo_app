package com.example.clubiqoapp;

import java.time.LocalDate;

public class Member {

    private int nationalId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String role;
    private String status;
    private LocalDate joinDate;
    private String token;

    public Member(int nationalId, String token, LocalDate joinDate, String status, String role, String phoneNumber, String lastName, String firstName, String password, String email) {
        this.nationalId = nationalId;
        this.token = token;
        this.joinDate = joinDate;
        this.status = status;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Member(int nationalId, LocalDate joinDate, String status, String role, String phoneNumber, String lastName, String firstName, String password, String email) {
        this.nationalId = nationalId;
        this.joinDate = joinDate;
        this.status = status;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getFullname() {
        return this.firstName+" "+this.lastName;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
