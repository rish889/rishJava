package org.rish889;

import java.util.*;
import java.util.stream.Collectors;

/*
    Problem Statement:
    Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
    It is guaranteed there is at least one word that is not banned, and that the answer is unique.

    The words in paragraph are case-insensitive and the answer should be returned in lowercase.

    Example 1
    Input:
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."

    banned = ["hit"]

    Output: "ball"

    Explanation
    hit" occurs 3 times, but it is a banned word. "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
    Note that words in the paragraph are not case sensitive, that punctuation is ignored (even if adjacent to words, such as "ball,"), 
    and that "hit" isn't the answer even though it occurs more because it is banned.

    Example 2
    Input: paragraph = "a." banned = []

    Output: "a"

    Constraint
    1 <= paragraph.length <= 1000
    paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
    0 <= banned.length <= 100
    1 <= banned[i].length <= 10
    banned[i] consists of only lowercase English letters.
 */
public class Solution1007 {
    public static void main(String args[]) {
        Solution1007 sol = new Solution1007();
        System.out.println(sol.mostFrequentWord("Bob hit a ball, the hit BALL flew far after it was hit.", List.of("hit")));
    }

    public String mostFrequentWord(String paragraph, List<String> bannedWords) {
        if (Objects.isNull(paragraph) || Objects.isNull(bannedWords)) {
            return null;
        }

        if (paragraph.isBlank()) {
            return null;
        }

        return Arrays.stream(paragraph.toLowerCase().split(" "))
                .map(w -> {
                    if (!Character.isAlphabetic(w.charAt(w.length() - 1))) {
                        return w.substring(0, w.length() - 1);
                    }
                    return w;
                })
                .filter(w -> !bannedWords.contains(w))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .min((e1, e2) -> e2.getValue().intValue() - e1.getValue().intValue())
                .map(Map.Entry::getKey)
                .get();
    }
}

