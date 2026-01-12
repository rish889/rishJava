package org.rish889;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Find the occurrences of each word in a given list of sentences, ignoring case and punctuation, and sort the result in descending order of frequency using Java 8 Stream API.

    Input: list [ "Apple and banana are fruits.", "I like to eat an apple every day.", "Orange is also a fruit, but banana is my favorite.", "APPLE pie is delicious!" ]

    Output apple: 3
    banana: 2
    is: 2
    a: 2
    and: 1
    are: 1
    fruits: 1
    i: 1
    like: 1
    to: 1
    eat: 1
    an: 1
    every: 1
    day: 1
    orange: 1
    also: 1
    fruit: 1
    but: 1
    my: 1
    favorite: 1
    pie: 1
    delicious: 1
 */
public class Solution1005 {
    public static void main(String args[]) {
        Solution1005 sol = new Solution1005();
        System.out.println(sol.findWordOccurences(List.of("Apple and banana are fruits.", "I like to eat an apple every day.", "Orange is also a fruit, but banana is my favorite.", "APPLE pie is delicious!")));
    }

    public List<Map.Entry<String, Long>> findWordOccurences(List<String> strings) {
        List<Map.Entry<String, Long>> fallbackResponse = List.of();
        if (strings == null) {
            return fallbackResponse;
        }
        return strings.stream()
                .map(str -> str.toLowerCase())
                .flatMap((str -> Arrays.asList(str.split(" ")).stream()))
                .map(str -> {
                    if (!Character.isAlphabetic(str.charAt(str.length() - 1))) {
                        return str.substring(0, str.length() - 1);
                    }
                    return str;
                })
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().intValue() - e1.getValue().intValue())
                .collect(Collectors.toList());
    }
}

