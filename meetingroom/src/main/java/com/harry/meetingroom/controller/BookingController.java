package com.harry.meetingroom.controller;

import com.harry.meetingroom.entity.Meeting;
import com.harry.meetingroom.service.BookingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    public void bookMeeting(Meeting meeting) {
        bookingService.bookRoom(meeting);
    }
}
