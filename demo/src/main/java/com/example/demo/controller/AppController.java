package com.example.demo.controller;

import com.example.demo.model.Doctor;

public enum AppController {
    INSTANCE;

    private final Doctor doctor;
    AppController(){
        this.doctor = new Doctor("doctor");
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
