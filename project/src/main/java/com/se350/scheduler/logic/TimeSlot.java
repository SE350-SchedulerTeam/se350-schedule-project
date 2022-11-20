package org.se350.logic;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlot {
    private LocalDate start_date;
    private LocalDate end_date;
    private LocalTime start_time;
    private LocalTime end_time;

    public TimeSlot (LocalDate start_date, LocalDate end_date, LocalTime start_time, LocalTime end_time) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    //@TODO: a method to check if a timeslot conflicts (public boolean conflicts(TimeSlot other)

    /*
     * Get methods
     */
    public LocalDate getStartDate() {
        return start_date;
    }

    public LocalDate getEndDate() {
        return end_date;
    }

    public LocalTime getStartTime() {
        return start_time;
    }

    public LocalTime getEndTime() { return end_time; }

    /*
     * Set methods
     */
    public void setStartDate(LocalDate date) { this.start_date = date; }

    public void setEndDate(LocalDate date) { this.end_date = date; }

    public void setStartTime(LocalTime time) { this.start_time = time; }

    public void setEndTime(LocalTime time) { this.end_time = time; }

    public String toString() {
        String msg = "TimeSlot{date=" + start_date;
        if (this.start_date != this.end_date) msg += " to " + end_date;
        msg += ", start_time=" + start_time + ", end_time=" + end_time + "}";
        return msg;
    }

}