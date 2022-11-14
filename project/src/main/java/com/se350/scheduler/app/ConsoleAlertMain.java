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

        Notification notification = new Notification();
        dp.registerObserver(notification);

        Event work = new Event(
                "event",
                "event description",
                EventType.WORK,
                new TimeSlot(
                        LocalDate.now(),
                        LocalTime.now().plusMinutes(1),
                        LocalTime.now().plusMinutes(3)
                )
        );
        work.createReminder(30, TimeMeasurement.MINUTE, "Test Msg");
        dp.addEvent(work);
        System.out.println(dp.addEvent(work));
    }
}
