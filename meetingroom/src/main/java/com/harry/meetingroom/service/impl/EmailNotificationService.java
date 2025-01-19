package com.harry.meetingroom.service.impl;

import com.harry.meetingroom.entity.User;
import com.harry.meetingroom.service.NotificationService;

import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EmailNotificationService implements NotificationService {

    private final ExecutorService executorService;

    public EmailNotificationService() {
        this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public void sendNotification(final List<User> users) {
        executorService.submit(() -> sendEmails(users.stream().map(User::getEmail).toList()));
    }

    private void sendEmails(final List<String> emails) {
        emails.forEach(email -> {
            System.out.println("Sending mail to " + email);
            try {
                Thread.sleep(1000);;
            } catch (InterruptedException e) {
                System.out.println("Failed to complete operation");
            }
        });
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
