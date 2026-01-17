package org.rish889;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Problem Statement:
    Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

    Return the sorted string. If there are multiple answers, return any of them.

    Example 1
    Input:: s = "tree"
    Output: "eert"

    Explanation
    'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

    Example 2
    Input:: "cccaaa"
    Output: "aaaccc"

    Explanation
    Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers. Note that "cacaca" is incorrect, as the same characters must be together.

    Constraint
    1 <= s.length <= 5 * 105
    s consists of uppercase and lowercase English letters and digits.
 */
public class Solution1008 {
    public static void main(String args[]) {
        Solution1008 sol = new Solution1008();
        System.out.println(sol.sortByFrequency("tree"));
        System.out.println(sol.sortByFrequency("cccaaa"));
    }

    public String sortByFrequency(String str) {
        if (Objects.isNull(str)) {
            return null;
        }
        if (str.isBlank()) {
            return null;
        }
        return str.toLowerCase().chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().intValue() - e1.getValue().intValue())
                .map(e -> Stream.iterate(0, n -> n + 1).limit(e.getValue())
                        .map(_ -> e.getKey().toString())
                        .collect(Collectors.joining()))
                .collect(Collectors.joining());
    }
}

