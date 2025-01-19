package com.harry.meetingroom.controller;

import com.harry.meetingroom.entity.MeetingRoom;
import com.harry.meetingroom.entity.TimeSlot;
import com.harry.meetingroom.service.RoomManagementService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RoomManagementController {
    private final RoomManagementService roomManagementService;


    public MeetingRoom addRoom(final MeetingRoom meetingRoom) {
        return roomManagementService.addRoom(meetingRoom);
    }

    public void removeRoom(final String roomId) {
        roomManagementService.remove(roomId);
    }

    public List<MeetingRoom> searchAvailableRooms(final TimeSlot slot) {
        return roomManagementService.searchAvailableRooms(slot);
    }
}
