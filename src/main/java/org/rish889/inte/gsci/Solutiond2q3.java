package org.rish889.inte.gsci;

import java.util.*;
import java.util.stream.Collectors;

/*
    Given a list of words, group them by anagrams.
    Examples -
        Input: ["cat", "dog", "god"], Output: [[“cat”], [“dog”,”god”]]
        Input: ["pan", "nap", "rome", "more"], Output: [["pan", "nap"], ["rome", "more"]]
 */
public class Solutiond2q3 {
    public static Collection<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, _ -> new ArrayList<>()).add(word);
        }

        return map.values();
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"cat", "dog", "god"}));
        System.out.println(groupAnagrams(new String[]{"pan", "nap", "rome", "more"}));
    }
}

