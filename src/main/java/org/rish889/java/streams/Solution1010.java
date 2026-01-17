package org.rish889.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    Problem Statement:
    You are given an integer array nums. A unique element is defined as an element that appears exactly once in the entire array.
    However, your task is to return the weighted sum of all unique elements, where the weight of an element is defined as its position-based uniqueness score.
    Position-based Uniqueness Score: For every unique element x, its score is calculated as:

    The sum of all prime-indexed positions (1-based) where elements smaller than x appear in the array.
    If no such element appears at a prime index, the score is 1 by default.
    Return the sum of (element × its uniqueness score) for all unique elements in the array.
    Example 1
    Input: nums = [1, 2, 3, 2, 4, 1]
    Step 1: Unique elements: [3, 4]
    Step 2: Prime indices (1-based): [2, 3, 5] (because 2, 3, and 5 are prime numbers) Elements at prime indices: nums[1]=2, nums[2]=3, nums[4]=4
        For 3: elements smaller than 3 at prime indices = [2] ⇒ score = 2
        For 4: elements smaller than 4 at prime indices = [2, 3] ⇒ score = 2 + 3 = 5
    Step 3: Weighted sum = (3 × 2) + (4 × 5) = 6 + 20 = 26

    Output: 26

    Explanation
    For each unique element x, calculate its score as follows:
    Identify all elements in the array that appear at prime-numbered positions (1-based).
    Among those, find the elements that are strictly less than x.
    The sum of those qualifying elements is the score for x.
    If there are no such elements, then the score defaults to 1.
    The weighted sum is the sum of each unique element multiplied by its score: weighted_sum = ∑ (x × score(x)), for each unique element x

    Constraint
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
 */
public class Solution1010 {
    private static final Integer MAX_NUMBER = 100;

    public static void main(String[] args) {
        Solution1010 sol = new Solution1010();
        System.out.println(sol.weightedSum(new int[]{1, 2, 3, 2, 4, 1}));
    }

    public Optional<Long> weightedSum(int[] nums) {
        if (nums == null) {
            return Optional.empty();
        }
        if (nums.length == 0) {
            return Optional.empty();
        }

        Set<Integer> distinctNumbers = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .collect(Collectors.toSet());

        long weightedSum = IntStream.rangeClosed(0, nums.length - 1)
                .filter(i -> distinctNumbers.contains(nums[i]))
                .map(i -> nums[i] * getScore(nums, i))
                .sum();
        return Optional.of(weightedSum);
    }

    private int getScore(int[] nums, int index) {
        List<Integer> primeIndexes = getPrimeIndexes(MAX_NUMBER);
        int score = primeIndexes.stream()
                .mapToInt(i -> i)
                .takeWhile(primeIndex -> primeIndex < index)
                .filter(primeIndex -> nums[primeIndex] < nums[index])
                .map(primeIndex -> nums[primeIndex])
                .sum();
        if (score == 0) {
            return 1;
        }
        return score;
    }

    private List<Integer> getPrimeIndexes(Integer maxNumber) {
        return IntStream.rangeClosed(2, maxNumber)
                .filter(this::isPrimeNumber)
                .boxed()
                .map(i -> i - 1)
                .toList();
    }

    private boolean isPrimeNumber(int i) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(i))
                .allMatch(j -> i % j != 0);
    }
}

