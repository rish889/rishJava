package org.rish889.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeCheckerTest {
    private final PrimeChecker checker = new PrimeChecker();

    @Test
    public void testPrimeNumbers() {
        assertTrue(checker.isPrime(2), "2 should be prime");
        assertTrue(checker.isPrime(3), "3 should be prime");
        assertTrue(checker.isPrime(5), "5 should be prime");
        assertTrue(checker.isPrime(13), "13 should be prime");
        assertTrue(checker.isPrime(17), "17 should be prime");
    }

    @Test
    public void testNonPrimeNumbers() {
        assertFalse(checker.isPrime(4), "4 should not be prime");
        assertFalse(checker.isPrime(6), "6 should not be prime");
        assertFalse(checker.isPrime(9), "9 should not be prime");
        assertFalse(checker.isPrime(15), "15 should not be prime");
    }

    @Test
    public void testEdgeCases() {
        assertFalse(checker.isPrime(1), "1 is not prime");
        assertFalse(checker.isPrime(0), "0 is not prime");
        assertFalse(checker.isPrime(-1), "-1 is not prime");
        assertFalse(checker.isPrime(-10), "Negative numbers are not prime");
    }
}
