package org.rish889.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
    Problem Statement:
    A sentence is a string of single-space separated words where each word consists only of lowercase letters.

    A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

    Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

    Example 1
    Input:
    s1 = "this apple is sweet." s2 = "this apple is sour."

    Output: ["sweet","sour"]

    Explanation
    The word "sweet" appears only in s1, while the word "sour" appears only in s2.

    Example 2
    Input: paragraph = "a." banned = []

    Output: "a"

    Constraint
    1 <= s1.length, s2.length <= 200
    s1 and s2 consist of lowercase English letters and spaces.
    s1 and s2 do not have leading or trailing spaces.
    All the words in s1 and s2 are separated by a single space.
 */
public class Solution1009 {
    public static void main(String args[]) {
        Solution1009 sol = new Solution1009();
        System.out.println(sol.uncommonWords("this apple is sweet.", "this apple is sour."));
    }

    public List<String> uncommonWords(String str1, String str2) {
        if (Objects.isNull(str1) || Objects.isNull(str2)) {
            return null;
        }

        String str = str1 + " " + str2;
        return Arrays.stream(str.split(" "))
                .map(w -> {
                    if (Character.isAlphabetic(w.charAt(w.length() - 1))) {
                        return w;
                    }
                    return w.substring(0, w.length() - 1);
                })
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .toList();
    }
}

