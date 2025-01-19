package com.harry.meetingroom.service.impl;

import com.harry.meetingroom.entity.MeetingRoom;
import com.harry.meetingroom.entity.TimeSlot;
import com.harry.meetingroom.repository.RoomRepository;
import com.harry.meetingroom.service.RoomManagementService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RoomManagementServiceImpl implements RoomManagementService {
    private final RoomRepository roomRepository;

    @Override
    public MeetingRoom addRoom(final MeetingRoom meetingRoom) {
        roomRepository.findById(meetingRoom.getRoomId())
                .ifPresent(room -> new RuntimeException("Meeting room already exist with id " + meetingRoom.getRoomName()));

        return roomRepository.save(meetingRoom);
    }

    @Override
    public MeetingRoom getMeetingRoom(final String roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Meeting room not found"));
    }


    @Override
    public void remove(final String roomId) {
        roomRepository.remove(roomId);
    }

    @Override
    public List<MeetingRoom> searchAvailableRooms(final TimeSlot slot) {
        return roomRepository.findAvailableRooms(slot);
    }


}
