package org.se350.logic;
import java.time.LocalDate;
import java.time.LocalTime;


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
        // default reminder = 30 minutes before
        Reminder r = new Reminder(30, TimeMeasurement.MINUTE, "You have an event!", timeslot.getStart_time(), timeslot.getStart_date());
        this.reminder = r;
    }



    public void createReminder(long farBack, TimeMeasurement metric, String msg) {
        Reminder r = new Reminder(farBack, metric, msg, timeslot.getStart_time(), timeslot.getStart_date());
        this.reminder = r;
    }

    public boolean shouldNotify() {
        if(this.reminder == null) {
            return false;
        }

        // crude way to check if it's time to notify
        if(reminder.getNotification_date().equals(LocalDate.now()) && reminder.getNotification_time().isBefore(LocalTime.now()))  {
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

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDate getStartDate() {
        return this.timeslot.getStart_date();
    }
    public LocalTime getStartTime() {
        return this.timeslot.getStart_time();
    }
    public LocalDate getEndDate() {
        return this.timeslot.getEnd_date();
    }

    public LocalTime getEndTime() {
        return this.timeslot.getEnd_time();
    }

    public Reminder getReminder() {
        return reminder;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                ", timeslot=" + timeslot +
                ", reminder=" + reminder +
                '}';
    }
}