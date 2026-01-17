package org.rish889.java.streams;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    You are given a string input and need to find the first non-repeated character in the string using Java 8 Streams.

    Additional Constraints:

    Ignore case sensitivity: Treat 'a' and 'A' as the same character.
    Ignore special characters (e.g., spaces, punctuation) when considering the characters.
    The solution must be implemented using Java 8 Streams only (e.g., filter, map, collect).
    The string might be empty or consist of only repeated characters. In such cases, return "No non-repeated character found".
    If the string contains multiple non-repeated characters, return the first one (in the order of their appearance).
    If no non-repeated character is found, the function should return "No non-repeated character found".
    Input:A string input, which may contain uppercase, lowercase, and special characters. The string may have spaces, punctuation, or be empty.
    Output:The first non-repeated character from the string or "No non-repeated character found" if none exist.

    Constraints:

    Use Java 8 Streams exclusively.
    Do not use traditional loops (for, while).
    Ensure the solution is null-safe and handles edge cases.
    Handle strings of length up to 10⁶ efficiently.
    Implement case-insensitivity and special character filtering.
    Example 1:

    Input: "swiss" Output: "w" Explanation:After considering case insensitivity and ignoring special characters, the non-repeated characters are "s", "w", and "i"."w" is the first non-repeated character.

    Example 2: Input: "repeated" Output: "r" Explanation:All characters repeat except "r"."r" is the first non-repeated character.
 */
public class Solution1003 {
    public static void main(String args[]) {
        Solution1003 sol = new Solution1003();
        System.out.println(sol.findFirstNonRepeatedCharacter("a b c"));
    }

    public String findFirstNonRepeatedCharacter(String str) {
        String fallbackResponse = "No non-repeated character found";
        if (str == null) {
            return fallbackResponse;
        }
        if (str.isBlank()) {
            return fallbackResponse;
        }

        List<Integer> nonRepeatableCharacters = str.toLowerCase()
                .chars()
                .filter(Character::isAlphabetic)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();

        Optional<Integer> firstNonRepeatedCharacter = str.toLowerCase()
                .chars()
                .filter(nonRepeatableCharacters::contains)
                .boxed()
                .findFirst();

        return firstNonRepeatedCharacter
                .map(i -> String.valueOf(Character.valueOf((char) i.intValue())))
                .orElse(fallbackResponse);
    }
}

