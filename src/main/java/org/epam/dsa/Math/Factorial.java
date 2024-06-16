package org.epam.dsa.Math;

public class Factorial {
    public static void main(String[] args) {
        // fact of 5
        // using iterative
       int num=5;
//        int res=1;
//        if(num==0){
//            System.out.println("Zero fcatorial is 1");
//            return;
//        }
//        for(int i=1;i<=num;i++){
//            res=res*i;
//        }
//        System.out.println(res);

        System.out.println(fact(num));

    }
    public static int fact(int num){
        if(num==0 || num==1)
            return 1;
        return num*fact(num-1);
    }
}
