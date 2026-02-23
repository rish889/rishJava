package org.rish889.inte.gsci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    For a string input the function returns output encoded as follows.
    input : a, output: a1

    input : aa, output: a2
    input : aabbb, output: a2b3
    input : aabbbaa, output: a2b2a2
 */
public class Solutiond2q5 {
    public static String encode(String input) {
        if (input == null || input.isBlank()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        result.append(input.charAt(input.length() - 1)).append(count);

        return result.toString();
    }

    @Test
    void test1() {
        assertEquals("a1", encode("a"));
        assertEquals("a2", encode("aa"));
        assertEquals("a2b3", encode("aabbb"));
        assertEquals("a2b3a2", encode("aabbbaa"));
    }
}

