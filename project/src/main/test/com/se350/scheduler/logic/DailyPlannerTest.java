package com.se350.scheduler.logic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.se350.scheduler.logic.EventType.WORK;
import static org.junit.Assert.*;

public class DailyPlannerTest {

    private DailyPlanner dailyPlanner;
    private List<Event> eventList;
    private Notification notification;
  //  TimeSlot timeSlot = new TimeSlot();
    @Before
    public void setUp() throws Exception {
        dailyPlanner = new DailyPlanner();
        eventList = new ArrayList<>();
        notification = new Notification();

    }
//   public Event(String name, String desc, EventType type, TimeSlot timeslot)
    // public TimeSlot (LocalDate date, LocalTime start_time, LocalTime end_time)
    @Test
    public void addEvent() {
      //  eventList.add(new Event("Task","Attend Meeting", WORK, "" ));

    }

    @Test
    public void removeEvent() {
    }

    @Test
    public void getEvents() {
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