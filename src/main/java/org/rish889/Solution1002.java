package org.rish889;

/*
    You are given an integer array arr[] and an integer threshold. Your task is to find the most frequently occurring valid element in the array using Java 8 Streams. A valid element is defined as:

    A positive number (i.e., > 0).
    Its frequency must not exceed the threshold
    Among elements with the same maximum frequency, return the smallest element
    If no valid element exists after filtering, return -1.
    Constraints:

    Use Java 8 Streams API only for all operations (e.g., filtering, grouping, finding max).
    Do not use loops (for, while).
    The solution must be null-safe and handle empty arrays gracefully.
    Must work efficiently for large inputs (up to 10⁶ elements).
    Example : Input: arr = [1, 3, 2, 1, 4, 1, 3, 3, 3], threshold = 4 Output: 3 Explanation: Frequencies: 1 → 3 times, 3 → 4 times, 2 → 1, 4 → 1 All elements are under or equal to threshold. Max frequency is 4 → Element is 3

 */
public class Solution1002 {
    static void main() {
        Solution1002 sol = new Solution1002();
        System.out.println(sol.mostFrequentlyOccuringValidElement(new int[]{1, 3, 2, 1, 4, 1, 3, 3, 3}, 4);
    }

    public int mostFrequentlyOccuringValidElement(int[] nums, int threshold) {
        return -1;
    }
}

