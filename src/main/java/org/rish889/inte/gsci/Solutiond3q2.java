package org.rish889.inte.gsci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Write a function to return second smallest element in array x. If x has fewer than 2 elements returns 0.
    Examples -
    x = [ -1, 0, 1, -2, 2], output = -1
    x = [ 0, 1], output = 1
 */
public class Solutiond3q2 {
    public static int secondSmallest(int[] x) {
        if (x == null || x.length < 2) {
            return 0;
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : x) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num > smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }

        return secondSmallest == Integer.MAX_VALUE ? 0 : secondSmallest;
    }

    @Test
    void test1() {
        assertEquals(-1, secondSmallest(new int[]{-1, 0, 1, -2, 2}));
        assertEquals(1, secondSmallest(new int[]{0, 1}));
    }
}

