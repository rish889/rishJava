package org.rish889.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    private final FizzBuzz fb = new FizzBuzz();

    @Test
    public void testFizz() {
        assertEquals("Fizz", fb.fizzBuzz(3));
        assertEquals("Fizz", fb.fizzBuzz(6));
    }

    @Test
    public void testBuzz() {
        assertEquals("Buzz", fb.fizzBuzz(5));
        assertEquals("Buzz", fb.fizzBuzz(10));
    }

    @Test
    public void testFizzBuzz() {
        assertEquals("FizzBuzz", fb.fizzBuzz(15));
        assertEquals("FizzBuzz", fb.fizzBuzz(30));
    }

    @Test
    public void testNumber() {
        assertEquals("1", fb.fizzBuzz(1));
        assertEquals("2", fb.fizzBuzz(2));
        assertEquals("4", fb.fizzBuzz(4));
        assertEquals("7", fb.fizzBuzz(7));
    }
}
