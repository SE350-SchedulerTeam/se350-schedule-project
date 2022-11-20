package org.se350.logic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;
import static org.junit.Assert.*;


public class TimeSlotTest {
    private int UnitTestQty = 3;

    @Test
    public void getStart_date() {

        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot uut = new TimeSlot(start_date, end_date, start_time, end_time);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", start_date, uut.getStartDate());
            testQty--;
        }

    }

    @Test
    public void getEnd_date() {

        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(9,30);
            LocalTime end_time = LocalTime.of(11, 0);
            TimeSlot uut = new TimeSlot(start_date, end_date, start_time, end_time);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", end_date, uut.getEndDate());
            testQty--;
        }

    }

    @Test
    public void getStart_time() {

        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            int hour1 = ThreadLocalRandom.current().nextInt(1, 24);
            int hour2 = hour1 + 1;
            int minute1 = ThreadLocalRandom.current().nextInt(1, 60);
            int minute2 = ThreadLocalRandom.current().nextInt(1, 60);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(hour1,minute1);
            LocalTime end_time = LocalTime.of(hour2, minute2);
            TimeSlot uut = new TimeSlot(start_date, end_date, start_time, end_time);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", start_time, uut.getStartTime());
            testQty--;
        }

    }

    @Test
    public void getEnd_time() {

        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            int hour1 = ThreadLocalRandom.current().nextInt(1, 24);
            int hour2 = hour1 + 1;
            int minute1 = ThreadLocalRandom.current().nextInt(1, 60);
            int minute2 = ThreadLocalRandom.current().nextInt(1, 60);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(hour1,minute1);
            LocalTime end_time = LocalTime.of(hour2, minute2);
            TimeSlot uut = new TimeSlot(start_date, end_date, start_time, end_time);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", end_time, uut.getEndTime());
            testQty--;
        }

    }

    @Test
    public void setStart_date() {

        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date.plusDays(2);
            LocalTime start_time = LocalTime.of(10,0);
            LocalTime end_time = LocalTime.of(11, 30);
            TimeSlot uut = new TimeSlot(start_date, end_date, start_time, end_time);

            // change date
            uut.setStartDate(start_date.plusDays(1));

            // test and go to next
            assertEquals("Failed: Did not return expected value.", start_date.plusDays(1), uut.getStartTime());
            testQty--;
        }

    }

    @Test
    public void setEnd_date() {

        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date.plusDays(2);
            LocalTime start_time = LocalTime.of(10,0);
            LocalTime end_time = LocalTime.of(11, 30);
            TimeSlot uut = new TimeSlot(start_date, end_date, start_time, end_time);

            // change date
            uut.setEndDate(end_date.plusDays(1));

            // test and go to next
            assertEquals("Failed: Did not return expected value.", end_date.plusDays(1), uut.getEndTime());
            testQty--;
        }

    }

    @Test
    public void setStart_time() {

        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            int hour1 = ThreadLocalRandom.current().nextInt(1, 24);
            int hour2 = hour1 + 1;
            int minute1 = ThreadLocalRandom.current().nextInt(1, 60);
            int minute2 = ThreadLocalRandom.current().nextInt(1, 60);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(hour1,minute1);
            LocalTime end_time = LocalTime.of(hour2, minute2);
            TimeSlot uut = new TimeSlot(start_date, end_date, start_time, end_time);

            // change hours and minutes and set new time
            if (hour1 == 1) hour1 = 23;
            else hour1 -= 1;
            if (minute1 <= 5) minute1 += 5;
            else minute1 -= 5;
            LocalTime newTime = LocalTime.of(hour1, minute1);
            uut.setStartTime(newTime);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", newTime, uut.getStartTime());
            testQty--;
        }

    }

    @Test
    public void setEnd_time() {

        int testQty = UnitTestQty;
        while (testQty > 0) {
            int year = ThreadLocalRandom.current().nextInt(2000, 2023);
            int month = ThreadLocalRandom.current().nextInt(1, 13);
            int day = ThreadLocalRandom.current().nextInt(1, 26);
            int hour1 = ThreadLocalRandom.current().nextInt(1, 24);
            int hour2 = hour1 + 1;
            int minute1 = ThreadLocalRandom.current().nextInt(1, 60);
            int minute2 = ThreadLocalRandom.current().nextInt(1, 60);
            LocalDate start_date = LocalDate.of(year, month, day);
            LocalDate end_date = start_date;
            LocalTime start_time = LocalTime.of(hour1,minute1);
            LocalTime end_time = LocalTime.of(hour2, minute2);
            TimeSlot uut = new TimeSlot(start_date, end_date, start_time, end_time);

            // change hours and minutes and set new time
            if (hour2 == 1) hour2 = 23;
            else hour2 -= 1;
            if (minute2 <= 5) minute2 += 5;
            else minute2 -= 5;
            LocalTime newTime = LocalTime.of(hour2, minute2);
            uut.setEndTime(newTime);

            // test and go to next
            assertEquals("Failed: Did not return expected value.", newTime, uut.getEndTime());
            testQty--;
        }

    }

}