package com.dsa;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 8, 3, 10, 6, 7};
        int n = arr.length;
//        selectionSort(arr, n);
//        System.out.println("Selection Sort: " + Arrays.toString(arr));
        insertionSort(arr, n);
        System.out.println("Insertion Sort: " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int lastIndex = n-1-i;
            int maxEleIndex = getMaxIndex(arr, 0, lastIndex);
            swap(arr, maxEleIndex, lastIndex);
        }
    }

    public static int getMaxIndex(int[] arr, int start, int end) {
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    /*
        find minIndex and put that at first appropriate index
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void insertionSort(int[] arr, int n) {
        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j > 0; j--) {
                if(arr[j]  < arr[j-1]) {
                    swap(arr, j, j-1);
                } else { // arr[j]  > arr[j-1]
                    break;
                }
            }
        }
    }
}
