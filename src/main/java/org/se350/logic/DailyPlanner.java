package org.se350.logic;

import javafx.application.Platform;
import javafx.scene.control.Alert;

import java.util.*;

public class DailyPlanner implements Watcher {
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
                System.out.println("poggies checking");
                List<Event> notified_events = new ArrayList<Event>();
                for(Event e : toRemind) {
                    System.out.println("poggies looping: " + e.toString());
                    if(e.shouldNotify()) {
                        System.out.println("ALERT ALERT ALERT FOR: " + e.getReminder().getMsg());
                        notified_events.add(e);
                        Platform.runLater(new Runnable() {
                            public void run() {
                                Alert alert = new Alert(Alert.AlertType.WARNING, e.getReminder().getMsg());
                                alert.show();
                            }
                        });
                    }
                }
                toRemind.removeAll(notified_events);
            }
        };
        // every min check time
        this.notify_timer.scheduleAtFixedRate(checkEventsTask, 0l, TIMER_INTERVAL);

    }



    //@TODO: refactoring add event to use the observer pattern <- still important. No observers are actually doing anything
    //@TODO: check for conflicts in events (although maybe we don't care?)
    public boolean addEvent(Event e){
        events.add(e);
        toRemind.add(e);
        //notification that even was added
        notifyObservers("Event Added " + e.getDesc()); // probably not the way to do this since then we parse strings in observers?
        return true;
    }
    Event remove(int pos) {
        Event removedEvent = null;
        if(pos <= events.size() && pos >=0)
            removedEvent = events.get(pos);
        assert removedEvent != null;
        notifyObservers("Event removed " + removedEvent.getDesc()); // see above
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
