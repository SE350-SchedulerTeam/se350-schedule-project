package com.se350.scheduler.logic;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Event {
    private String name;
    private String desc;
    private EventType type;
    private TimeSlot timeslot;
    private Reminder reminder;
    public Event(String name, String desc, EventType type, TimeSlot timeslot) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.timeslot = timeslot;
        this.reminder = null;
    }



    public boolean shouldNotify() {
        if(this.reminder == null) {
            return false;
        }
        Date now = new Date();
        // crude way to check if it's time to notify
        if(reminder.getNotifcation_time().getTime() < now.getTime())  {
            return true;
        }
        return false;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public TimeSlot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(TimeSlot timeslot) {
        this.timeslot = timeslot;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public Reminder getReminder() {
        return reminder;
    }
}