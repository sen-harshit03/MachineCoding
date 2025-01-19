package com.harry.meetingroom;

import com.harry.meetingroom.controller.BookingController;
import com.harry.meetingroom.controller.RoomManagementController;
import com.harry.meetingroom.entity.Meeting;
import com.harry.meetingroom.entity.MeetingRoom;
import com.harry.meetingroom.entity.TimeSlot;
import com.harry.meetingroom.entity.User;
import com.harry.meetingroom.repository.RoomRepository;
import com.harry.meetingroom.service.BookingService;
import com.harry.meetingroom.service.NotificationService;
import com.harry.meetingroom.service.RoomManagementService;
import com.harry.meetingroom.service.impl.BookingServiceImpl;
import com.harry.meetingroom.service.impl.EmailNotificationService;
import com.harry.meetingroom.service.impl.RoomManagementServiceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final RoomRepository roomRepository = new RoomRepository();
        final RoomManagementService roomManagementService = new RoomManagementServiceImpl(roomRepository);
        final NotificationService notificationService = new EmailNotificationService();
        final BookingService bookingService = new BookingServiceImpl(roomManagementService, notificationService);
        final RoomManagementController roomManagementController = new RoomManagementController(roomManagementService);
        final BookingController bookingController = new BookingController(bookingService);


        // Create rooms
        MeetingRoom meetingRoom1 = new MeetingRoom("R001", "Conference room1");
        MeetingRoom meetingRoom2 = new MeetingRoom("R002", "Conference room2");
        MeetingRoom meetingRoom3 = new MeetingRoom("R003", "Conference room3");

        List<MeetingRoom> meetingRooms = List.of(meetingRoom1, meetingRoom2, meetingRoom3);
        meetingRooms.forEach(roomManagementController::addRoom);

        //  Book slot
        LocalDateTime now = LocalDateTime.now();
        bookingService.bookRoom(new Meeting("xkhd-sdfh", "Sprint review",
                new TimeSlot(now.plusHours(2), now.plusHours(3)),
                List.of(new User("Harshit", "harhsit@google.com"),
                        new User("Alex", "alex@google.com")), "R001"));


        // check availability
        LocalDateTime newMeetingStartTime = now.plusHours(2).plusMinutes(15);
        LocalDateTime newMeetingEndTime = now.plusHours(3).plusMinutes(15);

        long minutes = ChronoUnit.MINUTES.between(newMeetingStartTime, newMeetingEndTime);
        System.out.println("Duration : " + minutes);

        List<MeetingRoom> availableRooms = roomManagementController.searchAvailableRooms(new TimeSlot(newMeetingStartTime, newMeetingEndTime));
        availableRooms.stream().map(MeetingRoom::getRoomId).forEach(System.out::println);
    }
}
