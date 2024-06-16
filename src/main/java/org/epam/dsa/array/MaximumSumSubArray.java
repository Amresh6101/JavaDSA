package org.epam.dsa.array;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        // first approach find all subarray and their maximum sum

        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<j;k++){
                    sum+=arr[k];
                }
                maxSum=Math.max(sum,maxSum);
            }
        }
        System.out.println("Max Sum of subarray using basics approach:"+maxSum);
        // time complexity----o(n^3) using three for loop

        // second kadens algorithms
        // currSum=0
        // maxSum=arr[0]
        // three conditions
        // 1: currSum=currSum+arr[i];
        // 2: maxSum=Math.max(maxSum,currSum)
        // 3: if currSum is negative then currSum=0;

        int currSum=0;
        int maxSumOfArray=arr[0];
        for(int i=0;i< arr.length;i++){
            currSum+=arr[i];
            maxSumOfArray=Math.max(maxSumOfArray,currSum);
            if(currSum<0){
                currSum=0;
            }
        }
        System.out.println("Sum Using kaden's algoritm:"+maxSumOfArray);
        // time complexity is o(n)
        //====================
    }
}
