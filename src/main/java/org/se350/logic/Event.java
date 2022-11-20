package org.se350.logic;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private String name;
    private String desc;
    private String date1;
    private String date2;
    private Integer startHour;
    private Integer startMinute;
    private Integer endHour;
    private Integer endMinute;
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
         Reminder r = new Reminder(30, TimeMeasurement.MINUTE, "You have an event!", timeslot.getStart_time(), timeslot.getDate());
         this.reminder = r;
     }

    public Event(String name, String desc, LocalDate date1, LocalDate date2, int startHour, int startMinute,
                 int endHour, int endMinute) {
        this.name = name;
        this.desc = desc;
        this.date1 = String.valueOf(date1);
        this.date2 = String.valueOf(date2);
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

     public void createReminder(long farBack, TimeMeasurement metric, String msg) {
         Reminder r = new Reminder(farBack, metric, msg, timeslot.getStart_time(), timeslot.getDate());
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

     public String getDate1() {
        return date1;
     }

     public void setDate1(String date1) {
        this.date1 = date1;
     }

     public String getDate2() {
        return date2;
     }

     public void setDate2(String date2) {
        this.date2 = date2;
     }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public Integer getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
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