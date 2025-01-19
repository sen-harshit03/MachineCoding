package com.harry.meetingroom.service;

import com.harry.meetingroom.entity.User;

import java.util.List;

public interface NotificationService {

    void sendNotification(List<User> users);
    void shutdown();
}
