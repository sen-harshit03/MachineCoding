package com.harry.meetingroom.entity;

import java.time.LocalDateTime;

public record TimeSlot(LocalDateTime startTimeInclusive, LocalDateTime endTimeExclusive) {

    public boolean overlaps(final TimeSlot timeSlot) {
        LocalDateTime start = timeSlot.startTimeInclusive();
        LocalDateTime end = timeSlot.endTimeExclusive();

        return !start.isAfter(endTimeExclusive) && !end.isBefore(startTimeInclusive) && !end.isEqual(startTimeInclusive);

    }
}


