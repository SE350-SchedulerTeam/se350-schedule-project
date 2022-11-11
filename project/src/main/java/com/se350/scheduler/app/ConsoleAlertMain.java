package com.se350.scheduler.app;

import com.se350.scheduler.logic.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class ConsoleAlertMain {
    public static void main(String[] args) {
        System.out.println("Starting DP");
        DailyPlanner dp = new DailyPlanner();
        Date start_date = new Date();
        start_date.setTime(start_date.getTime()+3000);

        Date end_date = new Date();
        end_date.setTime(end_date.getTime()+20000);

        Event e = new Event(
                "asdf",
                "desc",
                EventType.WORK,
                new TimeSlot(
                        LocalDate.now(),
                        LocalTime.now().plusMinutes(1),
                        LocalTime.now().plusMinutes(3)
                )
        );
        e.createReminder(30, TimeMeasurement.MINUTE, "Test Msg");


        dp.addEvent(e);
        System.out.println("added event");
    }
}
