package com.example.clubiqoapp;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Participation {
    private String eventId;
    private String memberId;
    private LocalDateTime eventDate;
    private String attendanceStatus;
    private String memberRole;

    public Participation(String eventId, String memberRole, String attendanceStatus, LocalDateTime eventDate, String memberId) {
        this.eventId = eventId;
        this.memberRole = memberRole;
        this.attendanceStatus = attendanceStatus;
        this.eventDate = eventDate;
        this.memberId = memberId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }
}
