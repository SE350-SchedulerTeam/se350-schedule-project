package org.se350.logic;

import java.util.*;

public class DailyPlanner implements Watcher{
    private final int TIMER_INTERVAL = 1 * 1000; // 1 minute
    private List<Event> events;
    private List<Event> toRemind;

    private Timer notify_timer;
    private List<Observer> observers;

    public DailyPlanner() {
        this.events = new ArrayList<Event>();
        this.toRemind = new ArrayList<Event>();
        this.notify_timer = new Timer();
        observers = new ArrayList<>();

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

    //refactoring add event to use the observer pattern
    public boolean addEvent(Event e){
        events.add(e);
        //notification that even was added
        notifyObservers("Event Added " + e.getDesc());
        return true;
    }
    Event remove(int pos) {
        Event removedEvent = null;
        if(pos <= events.size() && pos >=0)
            removedEvent = events.get(pos);
        assert removedEvent != null;
        notifyObservers("Event removed " + removedEvent.getDesc());
        return removedEvent;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String notification) {
        for (Observer o : observers) {
            o.showNotification(notification);
        }
}
}
