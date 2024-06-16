package org.epam.dsa.Math;

public class Fibonacci {
    public static void main(String[] args) {
        int n=5;
        // 0,1,1,2,3,5,8,13,

        int fibonacci=fib(3);
        System.out.println(fibonacci);

//        int firstNum=0;
//        int secondNum=1;
//        for(int i=1;i<=6;i++){
//            System.out.print(firstNum+" ");
//            int thirdNum=firstNum+secondNum;
//            firstNum=secondNum;
//            secondNum=thirdNum;
//        }
    }
    public static int fib(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        int num= fib(n-1)+fib(n-2);
        System.out.print(num+" ");
        return num;

    }
}
