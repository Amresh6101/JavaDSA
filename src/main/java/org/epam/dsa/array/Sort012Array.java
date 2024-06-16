package org.epam.dsa.array;

import java.util.Arrays;

public class Sort012Array {
    public static void main(String[] args) {
        int arr[]= {0, 2, 1, 2, 0};
        // smaple output:: 0 0 1 2 2

        // extra space
        int countZero=0;
        int countOne=0;
        int countTwo=0;
        for(int val:arr){
            if(val==0){
                countZero++;
            } else if (val==1) {
                countOne++;
            }
            else {
                countTwo++;
            }
        }
        System.out.println(countOne);
        System.out.println(countTwo);
        System.out.println(countZero);
         int idx=0;
//        for(int i=0;i<countZero;i++){
//            arr[idx++]=0;
//        }
//        for(int i=countZero;i<countOne;i++){
//            arr[idx++]=1;
//        }
//        for(int i=countOne-1;i<countTwo;i++){
//            arr[idx++]=2;
//        }
//        System.out.println(Arrays.toString(arr));

    }
}
