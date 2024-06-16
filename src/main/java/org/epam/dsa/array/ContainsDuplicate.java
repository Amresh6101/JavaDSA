package org.epam.dsa.array;
import java.util.*;
public class ContainsDuplicate {
    public static void main(String[] args) {
//        nums = [1,2,3,1]
//        Output: true

//        nums = [1,1,1,3,3,4,3,2,4,2]
//        Output: true

       // int[] arr={1,1,1,3,3,4,3,2,4,2};
        int[] arr={1,2,3};
        boolean result=solve(arr);
        System.out.println(result);
    }
    public static boolean solve(int[] arr){
        // map se bhi kr skte hai
        int len=arr.length;
        List<Integer> list=new ArrayList<>();
        for(int val:arr){
            if(list.contains(val))
                return true;
            else{
                list.add(val);
            }
        }
        return  false;
    }
}
