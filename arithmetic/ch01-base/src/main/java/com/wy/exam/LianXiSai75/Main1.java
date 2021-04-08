package com.wy.exam.LianXiSai75;

import java.util.Scanner;

public class Main1{
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int a = sn.nextInt();
        int b=sn.nextInt(),m=sn.nextInt(),n=sn.nextInt();
        int[] f = new int[n];
        if(n<=2){
            f[0] = a;
            if(n==2){
                f[1] = b;
            }
        }else {
            f[0] = a;
            f[1] = b;
            for(int i = 2; i < n; i++){
                f[i] = a*f[i-1] + b*f[i-2];
            }
        }
        Main1 main = new Main1();
        System.out.println(main.poow(m,f[n-1]));
    }

    public int poow(int a , int b)
    {
        long ans = 1 ;
        long base = a ;
        while(b != 0)
        {
            if((b & 1) != 0)
                ans = (ans * base)%1000000007;
            base *= base ;
            b >>= 1 ;
        }
        return (int)ans;
    }

}
