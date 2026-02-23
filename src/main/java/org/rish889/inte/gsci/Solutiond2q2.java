package org.rish889.inte.gsci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Finds the first character that does not repeat anywhere in the input string

    If all characters are repeated, return 0. Examples -
    str = "apple", output = "a"
    str = "racecars", output = "e"
 */
public class Solutiond2q2 {

    @Test
    void test1() {
        assertEquals('a', firstNonRepeating("apple"));
        assertEquals('e', firstNonRepeating("racecars"));
    }

    public static char firstNonRepeating(String str) {
        int[] freq = new int[256];

        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        for (char ch : str.toCharArray()) {
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '0';
    }
}

