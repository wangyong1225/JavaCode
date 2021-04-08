package com.wy.exam;

import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String[] arr = sc.nextLine().split("\\s+");
        for(String str:arr){
            System.out.println(str);
        }
    }
}
