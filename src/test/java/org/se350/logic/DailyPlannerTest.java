package org.se350.logic;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.se350.logic.EventType.SCHOOL;
import static org.se350.logic.EventType.WORK;


public class DailyPlannerTest {

    private DailyPlanner dailyPlanner;
    private List<Event> eventList;
    private Event event;
    private Notification notification;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate localDate;
    TimeSlot timeSlot;
    @Before
    public void setUp() throws Exception {
        dailyPlanner = new DailyPlanner();
        eventList = new ArrayList<>();
        notification = new Notification();
        startTime = LocalTime.of(10, 30);
        endTime = LocalTime.of(11, 0);
        localDate = LocalDate.of(2022, 11, 25);
        timeSlot = new TimeSlot(localDate, startTime, endTime);
        event = new Event("Task","Attend Meeting", WORK, timeSlot);
    }

    @Test
    public void addEvent() {
         eventList.add(event);
         assertNotNull(eventList);
         assertEquals(localDate, event.getTimeslot().getDate());
         assertEquals(startTime, event.getTimeslot().getStart_time());
         assertEquals(endTime, event.getTimeslot().getEnd_time());
         assertEquals(WORK, eventList.get(0).getType());
         assertEquals("Attend Meeting", event.getDesc());
         assertEquals("Task", event.getName());
         assertEquals(1, eventList.size());

         // add 1 more event
        eventList.add(new Event("Homework", "Finish Unit Tests for Final Project",
                SCHOOL,
                new TimeSlot(LocalDate.of(2022, 11, 25),
                        LocalTime.of(13, 10),
                        LocalTime.of(17, 00)
                        )));
        assertEquals(2, eventList.size());
    }

    @Test
    public void removeEvent() {
    }

    @Test
    public void getEvents() {
        eventList.add(event);
        assertEquals(event, eventList.get(0));
    }

    @Test
    public void registerObserver() {
        String expected = "Observer Registered";
        Notification actual = new Notification("Observer Registered");
        dailyPlanner.registerObserver(notification);
        assertNotNull(dailyPlanner);
        assertEquals(expected, actual.getDescription());
        notification.showNotification("Observer Registered");
    }

    @Test
    public void notifyObservers() {
        String description = "Notifying Observer";
        Notification actual = new Notification("Notifying Observer");
        notification.showNotification("Notifying Observer");
        dailyPlanner.notifyObservers(description);
        assertEquals(description, actual.getDescription());
    }

    @After
    public void tearDown() throws Exception {
        // System.out.println("Tearing down");
        dailyPlanner = null;
        assertNull(dailyPlanner);
    }
}
