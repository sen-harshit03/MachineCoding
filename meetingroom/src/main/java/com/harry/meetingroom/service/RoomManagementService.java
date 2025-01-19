package com.harry.meetingroom.service;

import com.harry.meetingroom.entity.MeetingRoom;
import com.harry.meetingroom.entity.TimeSlot;

import java.util.List;

public interface RoomManagementService {

    MeetingRoom addRoom(MeetingRoom meetingRoom);

    MeetingRoom getMeetingRoom(String roomId);

    void remove(String roomId);

    List<MeetingRoom> searchAvailableRooms(TimeSlot slot);
}
