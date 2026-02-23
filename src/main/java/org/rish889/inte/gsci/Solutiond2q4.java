package org.rish889.inte.gsci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Write a method that returns an integer array with two elements that correctly identifies the location of the longest uniform substring within the input string.
    The first element of the array should be the starting index of the longest substring, and the second element should be the length.
    Examples -
    input: “abbbccda", output = [1, 3] (longest uniform substring ="bbb")
    input: “abcxxyyz", output = [3, 4] (longest uniform substring ="xx")
 */
public class Solutiond2q4 {
    public static int[] longestUniformSubstring(String input) {
        if (input == null || input.isBlank()) {
            return new int[]{-1, 0};
        }

        int maxStart = 0;
        int maxLength = 1;

        int currentStart = 0;
        int currentLength = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxStart = currentStart;
                }
                currentStart = i;
                currentLength = 1;
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxStart = currentStart;
        }

        return new int[]{maxStart, maxStart + maxLength - 1};
    }

    @Test
    void test1() {
        int[] result = longestUniformSubstring("abbbccda");
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    void test2() {
        int[] result = longestUniformSubstring("abcxxyyz");
        assertEquals(3, result[0]);
        assertEquals(4, result[1]);
    }
}

