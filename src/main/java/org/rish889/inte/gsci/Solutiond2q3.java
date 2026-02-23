package org.rish889.inte.gsci;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Given a list of words, group them by anagrams.
    Examples -
        Input: ["cat", "dog", "god"], Output: [[“cat”], [“dog”,”god”]]
        Input: ["pan", "nap", "rome", "more"], Output: [["pan", "nap"], ["rome", "more"]]
 */
public class Solutiond2q3 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, _ -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }


    @Test
    void test1() {
        assertEquals(List.of(List.of("cat"), List.of("dog", "god")), groupAnagrams(new String[]{"cat", "dog", "god"}));
        assertEquals(List.of(List.of("pan", "nap"), List.of("rome", "more")), groupAnagrams(new String[]{"pan", "nap", "rome", "more"}));
    }
}

