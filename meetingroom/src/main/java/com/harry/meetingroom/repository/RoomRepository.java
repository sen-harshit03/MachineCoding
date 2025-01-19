package com.harry.meetingroom.repository;

import com.harry.meetingroom.entity.MeetingRoom;
import com.harry.meetingroom.entity.TimeSlot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RoomRepository {
    private final Map<String, MeetingRoom> meetingRooms;

    public RoomRepository() {
        this.meetingRooms = new HashMap<>();
    }

    public MeetingRoom save(final MeetingRoom meetingRoom) {
        return meetingRooms.put(meetingRoom.getRoomId(), meetingRoom);
    }

    public Optional<MeetingRoom> findById(final String roomId) {
        return Optional.ofNullable(meetingRooms.get(roomId));
    }


    public void remove(final String roomId) {
        meetingRooms.remove(roomId);
    }

    public List<MeetingRoom> findAvailableRooms(final TimeSlot slot) {
        return meetingRooms.values().stream()
                .filter(room -> room.isAvailable(slot))
                .toList();
    }
}
