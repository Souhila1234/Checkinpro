package com.example.projet_integration.entity;

import jakarta.persistence.*;


@Entity
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int extraHours;
    private int workDay;
    private int breakDay;
    private float workHour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Rapport() {
    }

    public Rapport(int id, int extraHours, int workDay, int breakDay, float workHour) {
        this.id = id;
        this.extraHours = extraHours;
        this.workDay = workDay;
        this.breakDay = breakDay;
        this.workHour = workHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public int getBreakDay() {
        return breakDay;
    }

    public void setBreakDay(int breakDay) {
        this.breakDay = breakDay;
    }

    public float getWorkHour() {
        return workHour;
    }

    public void setWorkHour(float workHour) {
        this.workHour = workHour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
