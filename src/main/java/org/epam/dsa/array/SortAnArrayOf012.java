package org.epam.dsa.array;

import java.util.Arrays;

public class SortAnArrayOf012 {
    public static void main(String[] args) {
        int arr[]= {0 ,2 ,1, 2, 0};
        // [0 0 1 2 2]
        int[] res=solve(arr);
        System.out.println(Arrays.toString(res));
        // time o(n)
        // space o(1)
    }
    public static int[] solve(int[] arr){
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while (mid<=high){

            if(arr[mid]==1){
                mid++;

            } else if (arr[mid]==2) {
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
            else{
                int temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            }
        }
        return arr;
    }
}
