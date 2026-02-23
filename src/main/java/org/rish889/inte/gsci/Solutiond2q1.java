package org.rish889.inte.gsci;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Given a string of letters and a dictionary,
    the function should find the longest word or words in the dictionary that can be made from the letters.
    Only lowercase letters will occur in the dictionary and the letters.
    The length of letters will be between 1 and 10 characters.
    The solution should work well for a dictionary of over 100,000 words.

    Examples -

    letters = "oet", dictionary = {"to","toe","toes"}, Output: {"toe"}

    letters = "oetdg", dictionary = {"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"}, Output: {"doe", "toe", "dog", "god"}
 */
public class Solutiond2q1 {

    @Test
    void test1() {
        assertEquals(Set.of("toe"), findWords("oetdg", Set.of("to","toe","toes")));
    }

    @Test
    void test2() {
        assertEquals(Set.of("doe", "toe", "dog", "god"), findWords("oetdg", Set.of("to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana")));
    }

    public static Set<String> findWords(String letters, Set<String> dictionary) {

        int[] lettersCount = buildFrequency(letters);
        int maxLength = 0;
        Set<String> result = new HashSet<>();

        for (String word : dictionary) {
            int len = word.length();
            if (len > letters.length()) continue;
            if (len < maxLength) continue;
            if (canForm(word, lettersCount)) {
                if (len > maxLength) {
                    maxLength = len;
                    result.clear();
                }
                result.add(word);
            }
        }

        return result;
    }

    private static int[] buildFrequency(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    private static boolean canForm(String word, int[] lettersCount) {
        int[] wordCount = new int[26];

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            wordCount[idx]++;

            if (wordCount[idx] > lettersCount[idx]) {
                return false;
            }
        }

        return true;
    }
}

