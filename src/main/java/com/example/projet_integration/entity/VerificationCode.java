package com.example.projet_integration.entity;

import jakarta.persistence.*;

@Entity
public class VerificationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int code;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public VerificationCode() {
    }

    public VerificationCode(int code, User user) {
        this.code = code;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
