package com.wy.exam.Lianxisan31;

import java.util.Scanner;

public class MainH {
    public static void main(String[] args) {
        MainH main = new MainH();
        Scanner sn = new Scanner(System.in);
        int t = sn.nextInt();
        for(int i = 0; i < t; i++){
            int n = sn.nextInt();
            String[] strings = new String[n];
            for(int j = 0; j < n; j++){
                strings[j] = sn.next();
            }
            boolean res = true;
            for(int j = 0; j < n/2; j++){
                if(!main.judgeSameChar(strings[j],strings[n-j-1])){
                    System.out.println("No");
                    res = false;
                    break;
                }
            }
            if(res){
                System.out.println("Yes");
            }
        }
    }

    public boolean judgeSameChar(String s1, String s2)
    {
        int a[] = new int[128], b[] = new int[128];//两个数组，分别存两个字符串中的字符，下标就对应字符的ASCII码
       for(int i = 0; i < s1.length(); i++){
           a[s1.charAt(i)]++;
       }
       for(int i = 0; i < s2.length(); i++){
           b[s2.charAt(i)]++;
       }
        for (int k = 0; k < 128; k++)
        {//如果对应下标的a、b数组中的value值都不为零说明该字符在s1和s2中都存在
            if(a[k] != 0 && b[k] != 0)
                return true;
        }
        return false;
    }
}
