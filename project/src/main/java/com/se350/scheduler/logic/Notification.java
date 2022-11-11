package com.se350.scheduler.logic;

public class Notification implements Observer{
    @Override
    public void showNotification(String description) {
        System.out.println(description);
    }
}
