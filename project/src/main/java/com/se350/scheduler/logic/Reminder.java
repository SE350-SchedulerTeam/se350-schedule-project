package org.se350.logic;


import java.time.LocalDate;
import java.time.LocalTime;

public class Reminder {
    private String msg;
    private long farBack;
    private TimeMeasurement metric;
    private LocalDate notification_date;
    private LocalTime notification_time;

    public Reminder (long farBack, TimeMeasurement metric, String msg, LocalTime event_start_time, LocalDate event_start_date) {
        this.farBack = farBack;
        this.metric = metric;
        this.msg = msg;
        this.setReminder(event_start_date, event_start_time, farBack, metric);
    }

    /*
     * Get methods
     */
    public String getMsg() {
        return msg;
    }

    public LocalTime getNotification_time() {
        return notification_time;
    }

    public LocalDate getNotification_date() {
        return notification_date;
    }

    public int getFarBackMinutes() {

        if (this.metric == TimeMeasurement.MINUTE) return (int)this.farBack;
        else if (this.metric == TimeMeasurement.HOUR) return (60 * (int)this.farBack);
        else if (this.metric == TimeMeasurement.DAY) return (24 * 60 * (int)this.farBack);
        else return 0;

    }

    /*
     * Set methods
     */
    private void setReminder(LocalDate event_start_date, LocalTime event_start_time, long farBack, TimeMeasurement metric) {
        this.notification_time = event_start_time;
        this.notification_date = event_start_date;

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

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "Reminder{" +
                "msg='" + msg + '\'' +
                ", notification_time=" + notification_time +
                ", notification_date=" + notification_date +
                "}";
    }

}