package com.se350.scheduler.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DailyPlanner {
    private final int TIMER_INTERVAL = 1 * 1000; // 1 minute
    private List<Event> events;
    private List<Event> toRemind;

    private Timer notify_timer;

    public DailyPlanner() {
        this.events = new ArrayList<Event>();
        this.toRemind = new ArrayList<Event>();
        this.notify_timer = new Timer();

        TimerTask checkEventsTask = new TimerTask() {
            @Override
            public void run() {
                List<Event> notified_events = new ArrayList<Event>();
                for(Event e : toRemind) {
                    if(e.shouldNotify()) {
                        //@TODO: Send UI Alert
                        System.out.println("ALERT ALERT ALERT FOR: " + e.getReminder().getMsg());
                        notified_events.add(e);
                    }
                }
                toRemind.removeAll(notified_events);
            }
        };
        // every min check time
        this.notify_timer.scheduleAtFixedRate(checkEventsTask, 0l, TIMER_INTERVAL);


    }

    public boolean addEvent(Event e) {
        //@TODO: check conflicts
        events.add(e);
        toRemind.add(e);
        return true;
    }

    public List<Event> getEvents() {
        return events;
    }




}
