package com.se350.scheduler.logic;


import java.time.LocalTime;
import java.util.Date;

public class Reminder {
    private String msg;
    private Date notifcation_time;
    private Date event_start_time;
    public Reminder (float farBack, TimeMeasurement metric, String msg, Date event_start_time) {
        this.msg = msg;
        this.event_start_time = event_start_time;
        this.setDateTime(farBack, metric);
    }

    /*
     * Set the date and time the reminder will take place
     * Inputs: How far back to set the reminder
     */
    private void setDateTime(float farBack, TimeMeasurement metric) {
        // set date and time that reminder must occur
        //@TODO: switch maybe
        if (metric == TimeMeasurement.MINUTE) {
            Date new_notif = new Date();
            new_notif.setTime((long) (this.event_start_time.getTime() - (farBack * 1000 * 60)));
            this.notifcation_time = new_notif;

        }
        else if (metric == TimeMeasurement.HOUR) {
            Date new_notif = new Date();
            new_notif.setTime((long) (this.event_start_time.getTime() - (farBack * 1000 * 60 * 60)));
            this.notifcation_time = new_notif;
        }
        else if (metric == TimeMeasurement.DAY) {
            Date new_notif = new Date();
            new_notif.setTime((long) (this.event_start_time.getTime() - (farBack * 1000 * 60 * 60 * 24)));
            this.notifcation_time = new_notif;
        }

    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getNotifcation_time() {
        return notifcation_time;
    }



}