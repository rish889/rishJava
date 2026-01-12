package org.rish889;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * You are given an array of integers arr[] of size n. Your task is to: Find the second largest distinct element in the array. However, you must ignore:
 * <p>
 * Any element that occurs more than k times (i.e., consider it invalid for ranking).
 * Any negative numbers in the array.
 * If no valid second largest distinct element exists after applying the constraints, return -1.
 * Input: An array arr[] of size n where 1 <= n <= 10^5 An integer k where 1 <= k <= n
 * <p>
 * Constraints: Time complexity should be O(n) Do not use built-in sort functions You may use extra space proportional to n
 * <p>
 * Example 1: Input: arr[] = [5, 3, 9, 9, 10, 5, 3, 2] k = 1 Output: 5 Explanation: Valid elements (occur at most once and are non-negative): 10, 2. 10 is the largest, 2 is second largest → Answer = 2 → But here 5 and 3 occur twice, so are ignored.
 */

public class Task1001 {
    static void main() {
        Solution1001 sol = new Solution1001();
        System.out.println(sol.findSecondLargestDistinctElement(new int[]{5, 3, 9, 9, 10, 5, 3, 2}, 1));
    }
}

class Solution1001 {
    public int findSecondLargestDistinctElement(int[] nums, int k) {
        if (nums == null) {
            return -1;
        }

        if (nums.length == 0) {
            return -1;
        }

        if (k < 0) {
            return -1;
        }

        Map<Integer, Long> freqMap = Arrays.stream(nums)
                .mapToObj(n -> n)
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));

        Set<Integer> distinctElementsSet = freqMap.entrySet().stream()
                .filter(e -> e.getValue() <= k)
                .filter(e -> e.getKey() >= 0)
                .map(e -> e.getKey())
                .collect(Collectors.toSet());

        List<Integer> twoLargestElements = Stream.iterate(9999, i -> i >= 0, i -> i - 1)
                .filter(i -> distinctElementsSet.contains(i))
                .limit(2)
                .collect(Collectors.toList());

        if (twoLargestElements.size() > 1) {
            return twoLargestElements.get(1);
        }

        return -1;
    }
}