package org.rish889.inte.gsci;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solutiond1q1 {
    public static void main(String[] args) {
        Solutiond1q1 sol = new Solutiond1q1();
        System.out.println(sol.emptyAfterRemoveKRepeatingElements(new int[]{8, 8, 1, 5, 5, 5, 1, 1, 8}, 3));
        System.out.println(sol.emptyAfterRemoveKRepeatingElements(new int[]{8, 1, 5, 5, 1, 5, 8}, 3));
    }

    public boolean emptyAfterRemoveKRepeatingElements(int[] arr, int k) {
        Map<Integer, Long> numToCountMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        for (Long count : numToCountMap.values()) {
            if (count < k) {
                return false;
            }
        }

        return true;
    }
}

