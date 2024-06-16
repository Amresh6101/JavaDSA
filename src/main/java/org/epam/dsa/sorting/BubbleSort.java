package org.epam.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={3,6,1,2,0,7,4};
        bubbleSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr, int len){
        for(int i=0;i<len;i++){ // no of iteration
            for(int j=0;j<len-1;j++){ // main logic
                if(arr[j+1]<arr[j]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
