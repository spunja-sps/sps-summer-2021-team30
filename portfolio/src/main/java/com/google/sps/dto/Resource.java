package com.google.sps.dto;

import java.time.LocalDateTime;

public class Resource {

    private int id;
    private String title;
    private String description;
    private LocalDateTime creationTime;

    public Resource(int id, String title, String description, LocalDateTime creationTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationTime = creationTime;
    }

    public Resource() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
