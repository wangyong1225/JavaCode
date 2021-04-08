package com.wy.exam.Lianxisan31;

import java.util.Scanner;

public class MainG{
    public static void main(String[] args) {
        MainG main = new MainG();
        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();
        for(int i=0; i < t; i++){
            long x = sn.nextLong();
            long y = sn.nextLong();
            System.out.println(main.findMax(x,y));
        }
    }
    public int findMax(long x, long y){
        if (x==0 || x==1 || y==0)
            return -1;
        int res = 0;
        while (y>=x){
            res++;
            y = y/x;
        }
        return res;
    }
}
