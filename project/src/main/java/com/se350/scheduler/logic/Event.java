package org.se350.logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
  private String name;
  private String desc;
  private TimeSlot timeslot;
  private List<Reminder> reminders;
  private EventType type;

  public Event(String name, String desc, EventType type, TimeSlot timeslot) {
    this.name = name;
    this.desc = desc;
    this.type = type;
    this.timeslot = timeslot;
    this.reminders = new ArrayList<>();

    // default reminder = 30 minutes before
    Reminder r = new Reminder(30, TimeMeasurement.MINUTE, "You have an event in half an hour!", timeslot.getStartTime(), timeslot.getStartDate());
    this.reminders.add(r);

  }

  public Event(String name, String desc, LocalDate date1, LocalDate date2, int startHour, int startMinute,
      int endHour, int endMinute) {

    this.name = name;
    this.desc = desc;

    // create timeslot
    LocalTime start_time = LocalTime.of(startHour, startMinute);
    LocalTime end_time = LocalTime.of(endHour, endMinute);
    this.timeslot = new TimeSlot (date1, date2, start_time, end_time);

    // default reminder = 30 minutes before
    Reminder r = new Reminder(30, TimeMeasurement.MINUTE, "You have an event in half an hour!", timeslot.getStartTime(), timeslot.getStartDate());
    this.reminders.add(r);

  }

  public int getFarBackMinutes(TimeMeasurement metric, long farBack) {

    if (metric == TimeMeasurement.MINUTE) return (int)farBack;
    else if (metric == TimeMeasurement.HOUR) return (60 * (int)farBack);
    else if (metric == TimeMeasurement.DAY) return (24 * 60 * (int)farBack);
    else return 0;

  }

  public boolean shouldNotify() {
    for (int i = 0; i < this.reminders.size(); i++) {
      Reminder reminder = this.reminders.get(i);
      if (reminder != null) {

        // crude way to check if it's time to notify
        boolean dateIsNow = reminder.getNotification_date().equals(LocalDate.now());
        boolean timeIsNow = reminder.getNotification_time().isBefore(LocalTime.now());
        if( dateIsNow && timeIsNow) return true;

      }
    }

    return false;
  }

  public void addReminder(long farBack, TimeMeasurement metric, String msg) {
    Reminder r = new Reminder(farBack, metric, msg, timeslot.getStartTime(), timeslot.getStartDate());
    this.reminders.add(r);
  }

  public void removeReminder(long farBack, TimeMeasurement metric) {
    for (int i = 0; i < this.reminders.size(); i++) {
        Reminder reminder = this.reminders.get(i);
        if (reminder.getFarBackMinutes() == this.getFarBackMinutes(metric, farBack)) {
          this.reminders.remove(i);
        }
    }
  }

  /*
   * Get methods
   */
  public String getName() { return name; }

  public String getDesc() { return desc; }

  public EventType getType() { return type; }

  public TimeSlot getTimeslot() { return timeslot; }

  public int getReminderQty() { return this.reminders.size(); }

  /*
   * Set methods
   */
  public void setName(String name) { this.name = name; }

  public void setDesc(String desc) { this.desc = desc; }

  public void setType(EventType type) { this.type = type; }

  public void setTimeslot(TimeSlot timeslot) { this.timeslot = timeslot; }


  @Override
  public String toString() {
    return "Event{" +
        "name='" + name + '\'' +
        ", desc='" + desc + '\'' +
        ", type=" + type +
        ", timeslot=" + timeslot +
        '}';
  }
}
