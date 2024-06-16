package org.epam.dsa.array;

import java.util.Arrays;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int low=0;
        int high=arr.length-1;
        System.out.println("Reversed Array:::");
        reverseArray(arr,low,high);
        System.out.println(Arrays.toString(arr));
    }
    public static void reverseArray(int[] arr,int low,int high){
        while(low<=high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
    }
}
