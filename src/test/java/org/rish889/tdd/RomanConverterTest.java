package org.rish889.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanConverterTest {
    private final RomanConverter converter = new RomanConverter();

    @Test
    public void testSimpleValues() {
        assertEquals("I", converter.toRoman(1));
        assertEquals("V", converter.toRoman(5));
        assertEquals("X", converter.toRoman(10));
    }

    @Test
    public void testAdditiveValues() {
        assertEquals("II", converter.toRoman(2));
        assertEquals("VI", converter.toRoman(6));
        assertEquals("LVIII", converter.toRoman(58));
    }

    @Test
    public void testSubtractiveValues() {
        assertEquals("IV", converter.toRoman(4));
        assertEquals("IX", converter.toRoman(9));
        assertEquals("XL", converter.toRoman(40));
        assertEquals("CM", converter.toRoman(900));
    }
}
