package com.smartbear.test;

import com.smartbear.test.BritishSpokenTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class BritishSpokenTimeTest {

    @Test
    @DisplayName("Invalid Date")
    public void testInvalid() {
        Assertions.assertThrows(Exception.class,() -> BritishSpokenTime.convertTimeToBST("55:34"));
    }

    @Test
    @DisplayName("Null Date")
    public void testWithNull() {
        Assertions.assertThrows(Exception.class,() -> BritishSpokenTime.convertTimeToBST(null));
    }

    @Test
    @DisplayName("Date in 24 hour format")
    public void testWith24HourFormat() {
        Assertions.assertThrows(Exception.class,() -> BritishSpokenTime.convertTimeToBST("23:00"));
    }

    @Test
    @DisplayName("At Specific Hour Zero Minute")
    public void testWithZeroMinute() throws Exception {
        Assertions.assertEquals("seven o'clock",BritishSpokenTime.convertTimeToBST("07:00"));
    }

    @Test
    @DisplayName("At Noon")
    public void testWithNoon() throws Exception {
        Assertions.assertEquals("noon",BritishSpokenTime.convertTimeToBST("12:00"));
    }

    @Test
    @DisplayName("Midnight")
    public void testWithMidnight() throws Exception {
        Assertions.assertEquals("midnight",BritishSpokenTime.convertTimeToBST("00:00"));
    }

    @Test
    @DisplayName("Quarter past on specific hour")
    public void testWithQuarterPast() throws Exception {
        Assertions.assertEquals("quarter past five",BritishSpokenTime.convertTimeToBST("05:15"));
    }

    @Test
    @DisplayName("Half past on specific hour")
    public void testWithHalfPast() throws Exception {
        Assertions.assertEquals("half past two",BritishSpokenTime.convertTimeToBST("02:30"));
    }

    @Test
    @DisplayName("Three Quarters past on specific hour")
    public void testWithQuarterTo() throws Exception {
        Assertions.assertEquals("quarter to four",BritishSpokenTime.convertTimeToBST("03:45"));
    }

    @Test
    @DisplayName("Minutes between 1 and 25 Subset 1")
    public void testWithRandomMinutesBetween1And25Subset1() throws Exception {
        Assertions.assertEquals("twenty past eight",BritishSpokenTime.convertTimeToBST("08:20"));
    }

    @Test
    @DisplayName("Minutes between 1 and 25 Subset 2")
    public void testWithRandomMinutesBetween1And25Subset2() throws Exception {
        Assertions.assertEquals("sixteen past eight",BritishSpokenTime.convertTimeToBST("08:16"));
    }

    @Test
    @DisplayName("Minutes between 26 and 34 Subset 1")
    public void testWithRandomMinutesBetween26And34Subset1() throws Exception {
        Assertions.assertEquals("nine twenty eight",BritishSpokenTime.convertTimeToBST("09:28"));
    }

    @Test
    @DisplayName("Minutes between 35 and 59 Subset 1")
    public void testWithRandomMinutesBetween35And59Subset1() throws Exception {
        Assertions.assertEquals("twenty five to eight",BritishSpokenTime.convertTimeToBST("07:35"));
    }

    @Test
    @DisplayName("Minutes between 35 and 59 Subset 2")
    public void testWithRandomMinutesBetween35And59Subset2() throws Exception {
        Assertions.assertEquals("fourteen to one",BritishSpokenTime.convertTimeToBST("00:46"));
    }
}
