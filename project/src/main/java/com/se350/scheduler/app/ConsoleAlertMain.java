package com.se350.scheduler.app;

import com.se350.scheduler.logic.*;

import java.util.Date;

public class ConsoleAlertMain {
    public static void main(String[] args) {
        System.out.println("Starting DP");
        DailyPlanner dp = new DailyPlanner();
        Date start_date = new Date();
        start_date.setTime(start_date.getTime()+3000);

        Date end_date = new Date();
        end_date.setTime(end_date.getTime()+20000);

        Event e = new Event("asdf", "desc", EventType.WORK, new TimeSlot(start_date, end_date));
        Reminder r = new Reminder(0, TimeMeasurement.MINUTE, "asdf", e.getTimeslot().getStart_time());
        e.setReminder(r);


        dp.addEvent(e);
        System.out.println("added event");
    }
}
