package com.se350.scheduler.logic;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlot {
    private LocalDate date;
    private LocalTime start_time;
    private LocalTime end_time;



    public TimeSlot (LocalDate date, LocalTime start_time, LocalTime end_time) {
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    //@TODO: a method to check if a timeslot conflicts (public boolean conflicts(TimeSlot other)

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "date=" + date +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}