package org.epam.dsa.array;

public class MaxAndMinInArray {
    public static void main(String[] args) {
        int[] arr={2,4,5,7,8,1,3};

        // find min and max in array

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int val1:arr){
            max=Math.max(val1,max);
        }
        for(int val2: arr){
            min=Math.min(val2,min);
        }
        System.out.println("Max value of Array:"+max);
        System.out.println("Min value of Array:"+min);
    }
}
