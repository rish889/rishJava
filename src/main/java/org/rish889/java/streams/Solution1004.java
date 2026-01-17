package org.rish889.java.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Divide a list of integers into two separate lists—one for even numbers and the other for odd numbers—using Java 8's Stream API

    Input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    Output

    Even Numbers: [2, 4, 6, 8, 10] Odd Numbers: [1, 3, 5, 7, 9]
 */
public class Solution1004 {
    private static final String EVEN_NUMBERS = "Even Numbers";
    private static final String ODD_NUMBERS = "Odd Numbers";

    public static void main(String args[]) {
        Solution1004 sol = new Solution1004();
        System.out.println(sol.divideList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    public Map<String, List<Integer>> divideList(List<Integer> list) {
        Map<String, List<Integer>> fallbackResponse = Map.of(EVEN_NUMBERS, List.of(), ODD_NUMBERS, List.of());

        if (list == null) {
            return fallbackResponse;
        }
        Map<String, List<Integer>> dividedLists = list.stream()
                .collect(Collectors.groupingBy(i -> {
                    if (i % 2 == 0) {
                        return EVEN_NUMBERS;
                    }
                    return ODD_NUMBERS;
                }));

        dividedLists.putIfAbsent(EVEN_NUMBERS, List.of());
        dividedLists.putIfAbsent(ODD_NUMBERS, List.of());


        return dividedLists;
    }
}

