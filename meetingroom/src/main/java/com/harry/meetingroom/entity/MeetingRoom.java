package com.harry.meetingroom.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


@Setter
@Getter
public class MeetingRoom {
    private final ReentrantLock reentrantLock = new ReentrantLock();
    private String roomId;
    private String roomName;
    private List<TimeSlot> bookedSlots;

    public MeetingRoom(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.bookedSlots = new ArrayList<>();
    }

    public boolean isAvailable(final TimeSlot timeSlot) {
        reentrantLock.lock();
        try {
            for (TimeSlot slot : bookedSlots) {
                if (slot.overlaps(timeSlot)) return false;
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }

    }

    public void bookRoom(final TimeSlot meetingInterval) {
        reentrantLock.lock();
        try {
            if (isAvailable(meetingInterval)) {
                bookedSlots.add(new TimeSlot(meetingInterval.startTimeInclusive(), meetingInterval.endTimeExclusive()));
            } else {
                throw new RuntimeException("Meeting room has already been booked. Try another room");
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}

/**
 * synchronized
 * ReadWriteLock -> Read >>>>> Write
 * ReentrantLock -> Read is nearly equal to the write
 * <p>
 * isAvailable -> read / write
 * bookRoom -> write
 */
