package org.se350.logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReminderTest {
    private int UnitTestQty = 3;
    private LocalDate start_date;
    private LocalTime start_time;

    public ReminderTest () {
        int year = ThreadLocalRandom.current().nextInt(2000, 2023);
        int month = ThreadLocalRandom.current().nextInt(1, 13);
        int day = ThreadLocalRandom.current().nextInt(1, 26);
        this.start_date = LocalDate.of(year, month, day);
        this.start_time = LocalTime.of(10,30);
    }
    private void updateDateTime(long farBack, TimeMeasurement metric) {

        if (metric == TimeMeasurement.MINUTE) {
            this.start_time = this.start_time.minusMinutes(farBack);
        }
        else if (metric == TimeMeasurement.HOUR) {
            this.start_time = this.start_time.minusHours(farBack);
        }
        else if (metric == TimeMeasurement.DAY) {
            this.start_date = this.start_date.minusDays(farBack);
        }

    }

    @Test
    public void getMsg() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random farBack
            List<String> msgs = new ArrayList<>();
            msgs.add("This test message #1 for reminder.");
            msgs.add("This test message #2 for reminder.");
            msgs.add("This test message #3 for reminder.");
            int rnd = ThreadLocalRandom.current().nextInt(0, 3);
            String msg = msgs.get(rnd);

            // test and go to next
            Reminder uut = new Reminder(1, TimeMeasurement.HOUR, msg, this.start_time, this.start_date);
            assertEquals("Failed: Did not return expected value.", msg, uut.getMsg());
            testQty--;

        }
    }

    @Test
    public void getNotification_date() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random farBack
            int farBack = ThreadLocalRandom.current().nextInt(1, 11);

            // get random metric
            List<TimeMeasurement> options = new ArrayList<>();
            options.add(TimeMeasurement.MINUTE);
            options.add(TimeMeasurement.HOUR);
            options.add(TimeMeasurement.DAY);
            int rnd = ThreadLocalRandom.current().nextInt(0, 3);
            TimeMeasurement metric = options.get(rnd);

            // test and go to next
            Reminder uut = new Reminder(farBack, metric, "This is a test reminder.", this.start_time, this.start_date);
            this.updateDateTime(farBack, metric);
            assertEquals("Failed: Did not return expected value.", this.start_date, uut.getNotification_date());
            testQty--;

        }
    }

    @Test
    public void getNotification_time() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random farBack
            int farBack = ThreadLocalRandom.current().nextInt(1, 11);

            // get random metric
            List<TimeMeasurement> options = new ArrayList<>();
            options.add(TimeMeasurement.MINUTE);
            options.add(TimeMeasurement.HOUR);
            options.add(TimeMeasurement.DAY);
            int rnd = ThreadLocalRandom.current().nextInt(0, 3);
            TimeMeasurement metric = options.get(rnd);

            // test and go to next
            Reminder uut = new Reminder(farBack, metric, "This is a test reminder.", this.start_time, this.start_date);
            this.updateDateTime(farBack, metric);
            assertEquals("Failed: Did not return expected value.", this.start_time, uut.getNotification_time());
            testQty--;

        }
    }

    @Test
    public void setMsg() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random farBack
            List<String> msgs = new ArrayList<>();
            msgs.add("This test message #1 for reminder.");
            msgs.add("This test message #2 for reminder.");
            msgs.add("This test message #3 for reminder.");
            int rnd = ThreadLocalRandom.current().nextInt(0, 3);
            String msg = msgs.get(rnd);
            Reminder uut = new Reminder(1, TimeMeasurement.HOUR, "This is a test message.", this.start_time, this.start_date);

            // test and go to next
            uut.setMsg(msg);
            assertEquals("Failed: Did not return expected value.", msg, uut.getMsg());
            testQty--;

        }
    }

}