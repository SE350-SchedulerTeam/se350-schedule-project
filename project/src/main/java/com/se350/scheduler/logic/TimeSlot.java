package com.se350.scheduler.logic;

import java.util.Date;
import java.util.List;
import java.time.LocalTime;

public class TimeSlot {
    private Date start_time;
    private Date end_time;



    public TimeSlot (Date start_time, Date end_time) {
        this.start_time = start_time;
        this.end_time = end_time;
    }

    //@TODO: a method to check if a timeslot conflicts (public boolean conflicts(TimeSlot other)

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}