package com.wy.exam.LianXiSai75;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int res = 0;
        int n = sn.nextInt(), m = sn.nextInt(), k = sn.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sn.nextInt();
        }
        for(int i = 0; i < n; i++){
            b[i] = sn.nextInt();
        }




    }
    public int min(int[] a){
        int res = Integer.MAX_VALUE;
        int order = 0;
        for(int i = 0; i < a.length; i++){
            if(res > a[i]){
                res = a[i];
                order = i;
            }
        }
        a[order] = Integer.MAX_VALUE;
        return res;
    }


}
