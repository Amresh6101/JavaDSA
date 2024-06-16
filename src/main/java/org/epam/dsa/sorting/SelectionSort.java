package org.epam.dsa.sorting;

import java.util.Arrays;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={3,6,1,2,0,7,4};
      //  IntStream str1= Arrays.stream(arr);


        selectionSort(arr,arr.length);
        System.out.println("Array sorted using selection sort:::");
        System.out.println(Arrays.toString(arr));

    }
    public static void selectionSort(int[] arr,int len){
        for(int i=0;i<len-1;i++){
            int idx=i;
            for(int j=i+1;j<len;j++){
                if(arr[j]<arr[idx]){
                    idx=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[idx];
            arr[idx]=temp;
        }
        
    }
}
