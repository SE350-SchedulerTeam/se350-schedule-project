package org.se350.logic;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeSlot {
    private LocalDate start_date;
    private LocalTime start_time;
    private LocalDate end_date;
    private LocalTime end_time;



    public TimeSlot (LocalDate start_date, LocalTime start_time, LocalDate end_date, LocalTime end_time) {
        this.start_date = start_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.end_date = end_date;
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



    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "start_date=" + start_date +
                ", start_time=" + start_time +
                ", end_date=" + end_date +
                ", end_time=" + end_time +
                '}';
    }
}