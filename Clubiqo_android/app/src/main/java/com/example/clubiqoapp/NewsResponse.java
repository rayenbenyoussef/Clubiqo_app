package com.example.clubiqoapp;

import java.time.LocalDateTime;

public class NewsResponse {
    private String id;
    private String title;
    private int lastModifiedBy;
    private int img;
    private String description;
    private LocalDateTime pastDate;
    private String link;

    public NewsResponse(String id, String link, LocalDateTime pastDate, String description, int img, int lastModifiedBy, String title) {
        this.id = id;
        this.link = link;
        this.pastDate = pastDate;
        this.description = description;
        this.img = img;
        this.lastModifiedBy = lastModifiedBy;
        this.title = title;
    }

    public int getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(int lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getPastDate() {
        return pastDate;
    }

    public void setPastDate(LocalDateTime pastDate) {
        this.pastDate = pastDate;
    }

    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
