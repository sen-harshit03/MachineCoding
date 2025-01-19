package com.harry.meetingroom.entity;

import lombok.Getter;

import java.util.List;


@Getter
public class User {
    private final String name;
    private final String email;
    private List<TimeSlot> bookedSlots;


    public User(final String name, final String email) {
        this.name = name;
        this.email = email;
    }
}
