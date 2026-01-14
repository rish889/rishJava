package org.rish889;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeapYearCalculatorTest {

    @Test
    void testYearDivisibleBy400IsLeapYear() {
        assertTrue(LeapYearCalculator.isLeapYear(2000), "2000 should be a leap year");
    }

    @Test
    void testYearDivisibleBy100ButNot400IsNotLeapYear() {
        assertFalse(LeapYearCalculator.isLeapYear(1900), "1900 should not be a leap year");
    }

    @Test
    void testYearDivisibleBy4ButNot100IsLeapYear() {
        assertTrue(LeapYearCalculator.isLeapYear(2024), "2024 should be a leap year");
    }

    @Test
    void testYearNotDivisibleBy4IsNotLeapYear() {
        assertFalse(LeapYearCalculator.isLeapYear(2023), "2023 should not be a leap year");
    }
}
