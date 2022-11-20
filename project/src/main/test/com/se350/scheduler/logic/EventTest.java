package org.se350.logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EventTest {
    public int UnitTestQty = 3;

    @Test
    public void shouldNotify() {
        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.SCHOOL, timeslot);

            // add reminder for rn
            uut.addReminder(0, TimeMeasurement.HOUR, "Remind at current time");

            // test and go to next
            assertEquals("Failed: Did not return expected value.", true, uut.shouldNotify());
            testQty--;
        }

    }

    @Test
    public void addReminder() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);

            // get random farBack
            int farBack = ThreadLocalRandom.current().nextInt(1, 11);

            // get random metric
            List<TimeMeasurement> options = new ArrayList<>();
            options.add(TimeMeasurement.MINUTE);
            options.add(TimeMeasurement.HOUR);
            options.add(TimeMeasurement.DAY);
            int rnd = ThreadLocalRandom.current().nextInt(0, 3);
            TimeMeasurement metric = options.get(rnd);

            // add reminder for rn
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);
            uut.addReminder(farBack, metric, "Reminder #2 for current event");
            uut.addReminder(farBack + 1, metric, "Reminder #3 for current event");

            // test and go to next
            assertEquals("Failed: Did not return expected value.", 3, uut.getReminderQty());
            testQty--;
        }
    }

    @Test
    public void removeReminder() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);

            // get random farBack
            int farBack = ThreadLocalRandom.current().nextInt(1, 11);

            // get random metric
            List<TimeMeasurement> options = new ArrayList<>();
            options.add(TimeMeasurement.MINUTE);
            options.add(TimeMeasurement.HOUR);
            options.add(TimeMeasurement.DAY);
            int rnd = ThreadLocalRandom.current().nextInt(0, 3);
            TimeMeasurement metric = options.get(rnd);

            // add 2 reminders
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);
            uut.addReminder(farBack, metric, "Reminder #2 for current event");
            uut.addReminder(farBack + 1, metric, "Reminder #3 for current event");

            // remove 1 reminder
            uut.removeReminder(farBack, metric);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", 2, uut.getReminderQty());
            testQty--;
        }
    }

    @Test
    public void getName() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", "Test Event", uut.getName());
            testQty--;
        }
    }

    @Test
    public void getDesc() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", "Currently testing this event", uut.getDesc());
            testQty--;
        }
    }

    @Test
    public void getType() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", EventType.MEETING, uut.getType());
            testQty--;
        }
    }

    @Test
    public void getTimeslot() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", timeslot, uut.getTimeslot());
            testQty--;
        }
    }

    @Test
    public void setName() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);

            // test and go to next
            uut.setName("New Name");
            assertEquals("Failed: Did not return expected value.", "New Name", uut.getName());
            testQty--;
        }
    }

    @Test
    public void setDesc() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);

            // test and go to next
            uut.setDesc("New description for this event");
            assertEquals("Failed: Did not return expected value.", "New description for this event", uut.getDesc());
            testQty--;
        }
    }

    @Test
    public void setType() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);

            // get random event type
            List<EventType> options = new ArrayList<>();
            options.add(EventType.SCHOOL);
            options.add(EventType.MEETING);
            options.add(EventType.WORK);
            options.add(EventType.OTHER);
            int rnd = ThreadLocalRandom.current().nextInt(0, 4);
            EventType type = options.get(rnd);

            // test and go to next
            uut.setType(type);
            assertEquals("Failed: Did not return expected value.", type, uut.getType());
            testQty--;
        }
    }

    @Test
    public void setTimeslot() {
        int testQty = UnitTestQty;
        while (testQty > 0) {

            // get random timeslot
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot timeslot = new TimeSlot(start_date, end_date, start_time, end_time);
            Event uut = new Event ("Test Event", "Currently testing this event", EventType.MEETING, timeslot);

            // get new random timeslot
            year = ThreadLocalRandom.current().nextInt(2000, 2023);
            month = ThreadLocalRandom.current().nextInt(1, 13);
            day = ThreadLocalRandom.current().nextInt(1, 26);
            start_date = LocalDate.of(year, month, day);
            end_date = start_date;
            start_time = LocalTime.of(9,30);
            end_time = LocalTime.of(11, 0);
            timeslot = new TimeSlot(start_date, end_date, start_time, end_time);

            // test and go to next
            uut.setTimeslot(timeslot);
            assertEquals("Failed: Did not return expected value.", timeslot, uut.getTimeslot());
            testQty--;
        }
    }


}