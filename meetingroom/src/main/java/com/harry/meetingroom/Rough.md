## Core Entities

### MeetingRoom

meetingId, capacity, name(optional), List<TimeSlot> bookedSlot

### TimeSlot

startTimeInclusive and endTimeExclusive

### Meeting - passed by user

meetingId, roomId, title, List<User> participants, startTimeInclusive and endTimeExclusive
