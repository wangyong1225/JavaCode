package com.wy.exam.Lianxisan31;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Main2 main = new Main2();
        Scanner sn = new Scanner(System.in);
        int m = 0,n=0;
        for(int i = 0; i < 1000; i++){
            m = sn.nextInt();
            n = sn.nextInt();
            if(m==0&&n==0){
                break;
            }
            int[][] figure = new int[m][n];
            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    figure[j][k] = sn.nextInt();
                }
            }
            int[] res = main.compress(figure);
            System.out.println(res[0] +" " + res[1]);
        }
    }
    public int[] compress(int[][] figure){
        int[] res = new int[2];

        return res;
    }


}
