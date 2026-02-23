package org.rish889.inte.gsci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Write a function to return the smallest number in a rotated sorted array.
    Examples -
    array = [3, 4, 5, 6, 1, 2], output = 1
    array = [2, 1], output = 1
 */
public class Solutiond3q1 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    @Test
    void test1() {
        assertEquals(1, findMin(new int[]{3, 4, 5, 6, 1, 2}));
        assertEquals(1, findMin(new int[]{2, 1}));
    }
}

