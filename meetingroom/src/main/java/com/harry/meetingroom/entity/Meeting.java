package com.harry.meetingroom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Meeting {
    private String meetingId;
    private String title;
    private TimeSlot meetingInterval;
    private List<User> participants;
    private String roomId;

}
