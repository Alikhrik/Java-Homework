package itstep.learning.oop;

import junit.framework.TestCase;

import java.text.ParseException;
import java.util.Date;

public class ComicsTest extends TestCase {

    public void testToString() {
        try {
            Comics sample = new Comics("Marvel", 1, "13.09.2022");
            assertEquals(sample.toString(), "Comics: Marvel No 1 (13.09.2022)");
        } catch (ParseException ignored) {
            fail("Date parse error");
        }
    }

    public void testGetNumber() {
        try {
            Comics sample = new Comics("Marvel", 1, "13.09.2022");
            assertEquals(sample.getNumber(), 1);
        } catch (ParseException ignored) {
            fail("Date parse error");
        }
    }

    public void testSetNumber() {
        Comics sample = new Comics();
        sample.setNumber(10);
        assertEquals(sample.getNumber(), 10);
    }

    public void testGetDate() {
        assertTrue(true);
    }

    public void testSetDate() {
        Comics sample = new Comics();
        Date date = new Date();
        sample.setDate(date);
        assertEquals(sample.getDate(), date);
    }
}