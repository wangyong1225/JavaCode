package com.wy.exam.Lianxisan31;

import java.util.Scanner;
public class MainE {
    public static void main(String[] args) {
        MainE main = new MainE();
        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();
        for(int i = 0; i < t; i++){
            long a = sn.nextInt();
            long b = sn.nextInt();
            int res = main.factorization(a*b);
            System.out.println(res);
        }
    }
    public int factorization(long a){
        int res = 0;
        int k = 0;
        if(a==1)
            return 1;
        if(a==2)
            return 2;
        int i = 1;
        double ii = Math.sqrt(a);
        for(; i <=ii; i++){
            if(a%i==0){
                res++;
            }
        }
        k = i-1==ii ? 1:0;
        return res*2-k;
    }
}
