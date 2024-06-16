package org.epam.dsa.array;

import java.util.Arrays;

public class MoveNegativeToOneSide {
    public static void main(String[] args) {
        int[] arr={-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int[] res=shiftAllNegative(arr);
        System.out.println(Arrays.toString(res));
    }
    public static int[] shiftAllNegative(int[] arr){
        int low=0;
        int high=arr.length;

        while(low<=high){
            if(arr[low]<0 && arr[high]>0){
                
            }
        }


        return arr;
    }
}
