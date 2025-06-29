package com.dsa;

public class Basics {
    public static void main(String[] args) {
//        int[] intArr = {10, 25, 35, 45, 50, 55, 70, 80}; // non-decreasing
//        int target = 55;
//        int index1 = linearSearch(intArr, target);
//        int index2 = BinarySearch(intArr, target);
//        System.out.println(intArr[index1] + "  Linear Search --- index: " + index1);
//        System.out.println(intArr[index2] + "  Binary Search --- index: " + index2);
        //------------------------------------------------------------------------------------
//        int[] arr1 = {10, 25, 35, 36, 40, 45, 90, 50, 55, 70, 75, 76, 77, 80};
//        int peak = findPeak(arr1);
//        System.out.println(arr1[peak] + "    index: " + peak);
// ----------------------------------------------------------------------------------------------------
//        char[] letters = {'b', 'd', 'f', 'k', 'p', 't', 'u', 'v'};
//        char target = 'b';
//        char result = findSmallestGreater(letters, target);
//        System.out.println(result);
        // ---------------------------------First and Last Position of target------------------------------------------
//        int[] nums = {2, 5, 7, 7, 7, 7, 7, 8, 9, 10};
//        int target = 70;
//        int[] result = new int[2];
//        int positionFirst = -1;
//        int positionLast = -1;
//        positionFirst = binarySearchPosition(nums, target, true);
//        if (positionFirst != -1) {
//            positionLast = binarySearchPosition(nums, target, false);
//        }
//        result[0] = positionFirst;
//        result[1] = positionLast;
//        System.out.println(Arrays.toString(result));
        // ---------------------------------------Infinite length Array--------------------------------
        int[] nums = {2, 4, 6, 8, 11, 13, 16, 18, 19, 22, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 35, 38, 40, 41, 42, 45, 45, 45, 45, 45};
        int target = 42;
        // initially start with start = 0 and end = 1;
        int start = 0, end = 1;
        while (target > nums[end]) {
            int blockSize = (end - start + 1);
            start = end + 1;
            end = end + blockSize*2;
        }
        // when it comes out of this loop whe will have a range of start and end where we can find our target
        int result = rangeBinarySearch(nums, target, start, end);
        System.out.println(result);
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target) {
                return mid;
            }
            if(arr[mid] > target) { // element is present on the LHS
                // look into LHS
                // start = start; end = mid -1;
                end = mid - 1;
            } else { // arr[mid] < target
                // look into RHS
                // end = end
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchPosition(int[] arr, int target, boolean checkLeft) {
        int start = 0;
        int end = arr.length - 1;
        int position = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target) {
                position = mid;
                if (checkLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > target) { // LHS
                end = mid -1;
            } else { // RHS
                start = mid + 1;
            }
        }
        return position;
    }

    public static int rangeBinarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end -start)/2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                // means we have found it
                return mid;
            }
        }
        return -1;
    }

    public static int findPeak(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start)/2;

            if (arr[mid] < arr[mid +1]) {
                // means we are in the ascending part of the array
                start = mid + 1;
            } else {
                // means either arr[mid] = peak or arr[mid] > arr[mid +1]
                // you are in the descending part of the array
                end = mid;
            }
        }
         return start;
    }

    public static char findSmallestGreater(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        if (letters[start] > target || letters[end] < target) return letters[0];

        while (start <= end) {
            int mid = start + (end -start) / 2;

            if (letters[mid] <= target) {
                // move right
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return letters[start % letters.length];
    }
}
