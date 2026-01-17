package org.rish889.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    void testEmptyStringReturnsZero() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void testSingleNumberReturnsValue() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    void testTwoNumbersCommaSeparatedReturnSum() {
        assertEquals(6, StringCalculator.add("1,5"));
    }

    @Test
    void testMultipleNumbersReturnSum() {
        assertEquals(10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    void testNewLinesBetweenNumbersReturnSum() {
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }
}
