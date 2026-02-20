package org.rish889.inte.old;

public class Solution1001 {
    int startIndex = 0;
    int endIndex = 0;

    public static void main(String[] args) {
        Solution1001 sol = new Solution1001();
        System.out.println(sol.findFrequencyOfTargetNumber(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}, 2));
    }

    public int findFrequencyOfTargetNumber(int[] arr, int targetNumber) {
        findStartEndIndex(arr, targetNumber);
        if (startIndex == -1) {
            return 0;
        }
        return (endIndex - startIndex + 1);
    }


    private void findStartEndIndex(int[] arr, int targetNumber) {
        startIndex = -1;
        endIndex = -1;

        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == targetNumber) {
                startIndex = findStartIndex(arr, targetNumber, s, mid);
                endIndex = findEndIndex(arr, targetNumber, mid, e);
                return;
            } else if (arr[mid] > targetNumber) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
    }

    private int findStartIndex(int[] arr, int targetNumber, int s, int e) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == targetNumber && mid == 0) {
                return mid;
            } else if (arr[mid] == targetNumber && (arr[mid - 1] != targetNumber)) {
                return mid;
            } else if (arr[mid] >= targetNumber) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    private int findEndIndex(int[] arr, int targetNumber, int s, int e) {
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == targetNumber && mid == arr.length - 1) {
                return mid;
            } else if (arr[mid] == targetNumber && (arr[mid + 1] != targetNumber)) {
                return mid;
            } else if (arr[mid] <= targetNumber) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
}

