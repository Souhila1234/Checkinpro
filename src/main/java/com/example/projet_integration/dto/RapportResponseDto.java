package com.example.projet_integration.dto;

public class RapportResponseDto {

    private int breakDay;
    private int extraHours;
    private int workDay;
    private float workHour;
    private int userId;
    private String name;
    public RapportResponseDto(int breakDay, int extraHours, int workDay, float workHour , int userId , String name) {
        this.extraHours = extraHours;
        this.workDay = workDay;
        this.workHour = workHour;
        this.userId = userId;
        this.name = name;
        this.breakDay = breakDay;
    }

    public int getBreakDay() {
        return breakDay;
    }

    public void setBreakDay(int breakDay) {
        this.breakDay = breakDay;
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

    public float getWorkHour() {
        return workHour;
    }

    public void setWorkHour(float workHour) {
        this.workHour = workHour;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
