package com.se350.scheduler.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DailyPlanner {
    private List<Event> events;

    private Timer notify_timer;

    public DailyPlanner() {
        this.events = new ArrayList<Event>();
        this.notify_timer = new Timer();

        TimerTask checkEventsTask = new TimerTask() {
            @Override
            public void run() {
                for(Event e : events) {
                    if(e.shouldNotify()) {
                        //@TODO: Send UI Alert
                        System.out.println("ALERT ALERT ALERT FOR: " + e.getReminder().getMsg());
                        e.setReminder(null); // stop alerting
                    }
                }
            }
        };
        // every min check time
        this.notify_timer.scheduleAtFixedRate(checkEventsTask, 0l, 60 * 1000);


    }

    public boolean addEvent(Event e) {
        //@TODO: check conflicts
        events.add(e);
        return true;
    }

    public List<Event> getEvents() {
        return events;
    }




}
