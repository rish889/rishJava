package org.rish889.inte.gsci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Write a function to find the median of the two sorted arrays.
    The median is the average of middle two elements when the two sorted arrays are merged into one sorted array.
    Examples -
    arr1= [1, 3], arr2 = [2, 4], output: 2.5 (average of middle elements (2+3)/2)
    arr1= [1, 3], arr2 = [2, 4, 5], output: 3 (middle element)
 */
public class Solutiond3q3 {
    public static double findMedian(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findMedian(arr2, arr1);
        }

        int x = arr1.length;
        int y = arr2.length;

        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : arr2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) +
                            Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    @Test
    void test1() {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 4};

        assertEquals(2.5, findMedian(arr1, arr2));
    }

    @Test
    void test2() {
        int[] arr1 = {1, 3};
        int[] arr2 = {2, 4, 5};

        assertEquals(3.0, findMedian(arr1, arr2));
    }
}

