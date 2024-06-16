package org.epam.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={3,6,1,2,0,7,4};
        insertionSort(arr,arr.length);
        System.out.println("Array sorted using Insertion sort:::");
        System.out.println(Arrays.toString(arr));
    }
    public static void insertionSort(int[] arr,int len){
        for(int i=1;i<len;i++){
            int j=i-1;
            int key=arr[i];
            while (j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
