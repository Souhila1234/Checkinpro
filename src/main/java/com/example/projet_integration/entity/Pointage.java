package com.example.projet_integration.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pointage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime checkOutTime;
    private double latitude;
    private double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Pointage() {
    }

    public Pointage(LocalDateTime startTime, LocalDateTime checkOutTime, double latitude, double longitude, User user) {
        this.startTime = startTime;
        this.checkOutTime = checkOutTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
    }

    public Pointage(int id, LocalDateTime startTime, LocalDateTime checkOutTime, double latitude, double longitude, User user) {
        this.id = id;
        this.startTime = startTime;
        this.checkOutTime = checkOutTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}