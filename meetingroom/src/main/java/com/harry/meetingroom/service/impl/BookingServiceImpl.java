package com.harry.meetingroom.service.impl;

import com.harry.meetingroom.entity.Meeting;
import com.harry.meetingroom.entity.MeetingRoom;
import com.harry.meetingroom.entity.User;
import com.harry.meetingroom.service.BookingService;
import com.harry.meetingroom.service.NotificationService;
import com.harry.meetingroom.service.RoomManagementService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final RoomManagementService roomManagementService;
    private final NotificationService notificationService;

    @Override
    public void bookRoom(final Meeting meeting) {
        final MeetingRoom meetingRoom = getMeetingRoom(meeting);
        meetingRoom.bookRoom(meeting.getMeetingInterval());
        sendNotification(meeting.getParticipants());
    }

    private MeetingRoom getMeetingRoom(final Meeting meeting) {
        return roomManagementService.getMeetingRoom(meeting.getRoomId());
    }

    public void sendNotification(final List<User> participants) {
        notificationService.sendNotification(participants);
        notificationService.shutdown();
    }
}
