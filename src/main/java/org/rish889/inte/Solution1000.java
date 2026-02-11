package org.rish889.inte;

public class Solution1000 {
    int startIndex = 0;
    int endIndex = 0;

    public static void main(String[] args) {
        Solution1000 sol = new Solution1000();
//        System.out.println(sol.findStartIndex(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 1));
//        System.out.println(sol.findEndIndex(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 1));

//        System.out.println(sol.findFrequencyOfTargetNumber(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 3));
        System.out.println(sol.findFrequencyOfTargetNumber(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}, 2));
        /**
         * findStartIndex
         * 0,1,2,3,4,5,6,7,8,9
         * 1,2,3,4,5,6,7,7,7,7,8,9
         * s=0,e=11,mid=5
         * s=6,e=11,mid=8
         * findStart(s,mid)
         */

        /**
         * findEndIndex
         * 0,1,2,3,4,5,6,7,8,9
         * 1,2,3,4,5,6,7,7,7,7,8,9
         * s=0,e=11,mid=5
         * s=6,e=11,mid=8
         * findEnd(mid,e)
         */

        /**
         * findStartEndIndex
         * 0,1,2,3,4,5,6,7,8,9
         * 1,2,3,4,5,6,7,7,7,7,8,9
         * s=0,e=11,mid=5
         * s=6,e=11,mid=8
         * findStart(s,mid), findEnd(mid,e)
         */

        /**
         * initial : 2logn
         * new solution worst case : 2logn
         * new solution not worst case : <2logn
         */
    }

    public int findFrequencyOfTargetNumber(int[] arr, int targetNumber) {
        int startIndex = findStartIndex(arr, targetNumber);
        int endIndex = findEndIndex(arr, targetNumber);
        //2passes
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
                //1.25 passes
                // less than 2passes
                return;
            } else if (arr[mid] > targetNumber) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return;
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

    private int findStartIndex(int[] arr, int targetNumber) {
        int s = 0;
        int e = arr.length - 1;
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

    private int findEndIndex(int[] arr, int targetNumber) {
        int s = 0;
        int e = arr.length - 1;
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

    private int findTargetNumberIndex(int[] arr, int targetNumber) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (arr[mid] == targetNumber) {
                return mid;
            } else if (arr[mid] > targetNumber) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

}

