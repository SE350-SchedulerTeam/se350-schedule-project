package org.se350.logic;


import java.time.LocalDate;
import java.time.LocalTime;

public class Reminder {
    private String msg;
    private LocalTime notification_time;
    private LocalTime event_start_time;

    private LocalDate notification_date;
    public Reminder (long farBack, TimeMeasurement metric, String msg, LocalTime event_start_time, LocalDate event_start_date) {
        this.msg = msg;
        this.event_start_time = event_start_time;
        this.notification_time = event_start_time;
        this.notification_date = event_start_date;
        this.setDateTime(farBack, metric);

    }

    /*
     * Set the date and time the reminder will take place
     * Inputs: How far back to set the reminder
     */
    private void setDateTime(long farBack, TimeMeasurement metric) {
        // set date and time that reminder must occur
        //@TODO: switch maybe
        if (metric == TimeMeasurement.MINUTE) {

            this.notification_time = this.notification_time.minusMinutes(farBack);

        }
        else if (metric == TimeMeasurement.HOUR) {
            this.notification_time = this.notification_time.minusHours(farBack);
        }
        else if (metric == TimeMeasurement.DAY) {
            this.notification_date = this.notification_date.minusDays(farBack);
        }

    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalTime getNotification_time() {
        return notification_time;
    }

    public void setNotification_time(LocalTime notification_time) {
        this.notification_time = notification_time;
    }

    public LocalTime getEvent_start_time() {
        return event_start_time;
    }

    public void setEvent_start_time(LocalTime event_start_time) {
        this.event_start_time = event_start_time;
    }

    public LocalDate getNotification_date() {
        return notification_date;
    }

    public void setNotification_date(LocalDate notification_date) {
        this.notification_date = notification_date;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "msg='" + msg + '\'' +
                ", notification_time=" + notification_time +
                ", notification_date=" + notification_date +
                '}';
    }
}