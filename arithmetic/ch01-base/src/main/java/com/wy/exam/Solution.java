package com.wy.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回满足条件的最大的x。
     * @param a int整型 代表题意中的a
     * @param b int整型 代表题意中的b
     * @param n int整型 代表题意中的n
     * @return int整型
     */

    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9715/A
     * 来源：牛客网
     *
     * 牛牛想知道在[0,n][0,n]范围中，选取一个最大的数xx，满足x \% a = bx%a=b，不过这个范围可能会很大，
     * 牛牛不知道该如何解决，所以他想请你帮忙。
     * 给定如上所述的a , b , na,b,n，返回满足条件的最大的xx。
     * @param a
     * @param b
     * @param n
     * @return
     */
    public int solve (int a, int b, int n) {
        // write code here

        while (n % a != b){
            if(n == 0)
                return 0;
            n--;
        }

        return n;
    }


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9715/B
     * 来源：牛客网
     *
     * 给出一个仅包含小写字母的字符串s，你最多可以操作k次，使得任意一个
     * 小写字母变为与其相邻的小写字母（ASCII码差值的绝对值为1），请你求
     * 出可能的最长相等子序列（即求这个字符串修改至多k次后的的一个最长子
     * 序列，且需要保证这个子序列中每个字母相等）。
     * @param k
     * @param s
     * @return
     */
    public int string2 (int k, String s) {
        // write code here

        return 0;
    }


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9715/C
     * 来源：牛客网
     *
     * 音游狂热爱好者牛牛接到了一个新的任务，那就是给一张乐谱设计重音符。每当玩家敲击重音符的时候就会发出"bang"的美妙声音!!
     * 每一张乐谱都有n个音符从左到右一字排开，现在牛牛的任务就是选出其中m个音符将其标记为重音符，同时任意两个重音符
     * 之间都必须隔着至少k个音符。
     * 一个有意思的问题诞生了，请求出这样合法的设计方案种数，并输出答案对1000000007取模的结果。
     * @param n
     * @param m
     * @param k
     * @return
     */
    public long solve_bangbang (int n, int m, int k) {
        // write code here
        if( m == 0)
            return 1;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;


        return 0;
    }


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9886/A
     * 来源：牛客网
     *
     * 牛牛想把一个数拆成两个不相等的正整数之和，他想知道一共有多少种拆法，只不过他不知道该
     * 如何解决这个问题，所以他想请你帮忙。
     * 给定一个数n，返回将这个数n拆成两个不相等的正整数之和一共有多少种拆法。
     * 注：3=1+2和3=2+1视为同一种拆法。
     * @param n
     * @return
     */
    public int solve (int n) {
        // write code here
        if(n<3)
            return 0;
        if(n%2 == 0){
            return n/2-1;
        }
        else {
            return n/2;
        }
    }

    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9886/B
     * 来源：牛客网
     *
     * 牛牛有现在有n个物品，每个物品有一个体积v[i]和重量g[i],他想选择其中总体积恰
     * 好为V的若干个物品，想使这若干个物品的总重量最大，他想知道最大总重量为多少。
     * （如果不存在合法方案，返回-1）
     * @param v
     * @param g
     * @param V
     * @return
     */
    public int Maximumweight (int[] v, int[] g, int V) {
        // write code here
        int i,n=v.length,ma=-1;
        for(i=0; i<1<<n;i++){
            int p=i,j=0,sum=0,vsum=0;
            while (p>0){
                sum+=p%2*v[j];
                vsum+=p%2*g[j];
                j++;
                p/=2;
            }
            if(sum==V){
                ma=Math.max(ma,vsum);
            }
        }
        return ma;
    }


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9886/C
     * 来源：牛客网
     * 牛牛拿到了一个字符串。他想知道除去字符串本身以外，这个字符串最大的公共前后缀的长度是多少？
     * 例如，对于字符串ABABA而言，“ABA”即是它的前缀，也是它的后缀，且是最长的公共前后缀，因此最大的长度是3。
     * 牛牛无法解决该问题，所以他只好向你求助，给定一个只包含大写字母的字符串s，返回除去字符串本身以外公共
     * 前后缀最大长度，如果没有任何一个公共前后缀满足要求，返回-1即可。
     * @param s
     * @return
     */
    public int solve (String s) {
        // write code here
        int length = s.length();
        if (length<=1)
            return -1;
        char[] ch = s.toCharArray();
        for(int i = 1; i < length;i ++){
            if(ch[0] == ch[i]){
                if(i == length - 1)
                    return 1;
                for(int j = i+1; j < length; j++){
                    if(ch[j-i] != ch[j]){
                        break;
                    }
                    if(j == length - 1){
                        return length - i;
                    }
                }
            }
        }
        return -1;

    }


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/10166/A
     * 来源：牛客网
     *
     * 牛牛在做数学实验。
     * 老师给了牛牛一个数字n，牛牛需要不断地将所有数位上的值做乘法运算，直至最后数字不发生变化为止。
     * 请你帮牛牛计算一下，最后生成的数字为多少？
     * @param n
     * @return
     */

    public int mathexp (long n) {
        // write code here
        String str = String.valueOf(n);
        char[] ch = str.toCharArray();
        char[] res = fenJie(ch);
        return (int)res[0] - (int)'0';

    }

    public char[] fenJie(char[] ch){
        if(ch.length==1)
            return ch;
        long num = 1;
        for(int i = 0; i < ch.length; i++){
            num*= ((int)ch[i] - (int)'0');
        }
        String str = String.valueOf(num);
        return fenJie(str.toCharArray());
    }


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/10166/B
     * 来源：牛客网
     *
     * 操场上有n个人排成一队，这n个人身高互不相同，可将他们的身高视为一个1到n的排列。
     * 这时需要把队伍变成升序，也就是从矮到高排序。
     * 每次可以选择一个人，让这个人和在他身后的人比高矮，如果比对方高，则交换位置并继续下一次比较，
     * 直到比对方矮或者已经在队尾。
     * 现在给出数n和一个1到n的排列，求最少的选择次数，使队伍变为升序。
     * @param n
     * @param a
     * @return
     */
    public int work (int n, int[] a) {
        // write code here
        int res = 0;
        int max = n;
        while (!isUp(n,a)){
            for(int i = 0; i < n; i++){
                if(a[i] == max){
                    max--;
                    if(i!=max){
                        int temp = a[i];
                        a[i] =  a[max];
                        a[max] = temp;
                        res++;
                    }
                }
            }
        }

        return res;
    }
    public boolean isUp(int n, int[] a){
        for(int i = 0; i < n; i++){
            if(a[i] != i-1){
                return false;
            }
        }
        return true;
    }


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/10166/C
     * 来源：牛客网
     *
     * 牛牛最近学会了异或操作，于是他发现了一个函数f(x)=x\oplus (x-1)f(x)=x⊕(x−1)，
     * 现在牛牛给你一个数\mathit nn，他想知道\sum_{i=1}^n f(i)∑
     * i=1
     * n
     * ​
     *  f(i)的值是多少，请你告诉他。
     * @param n
     * @return
     */

    public long Sum (int n) {
        // write code here
        long res = 0;
        for(int i = 1; i <=n; i ++){
            res += i^(i-1);
        }
        return res;
    }


    /**
     *链接：https://ac.nowcoder.com/acm/contest/9700/A
     * 来源：牛客网
     *
     * 给定一个长度为 n 数列，判断其是否为“牛”的，是则输出“YES”，否则输出“NO”。
     * 一个数列是“牛”的，当且仅当其满足以下三个条件中至少一个：
     * 1、这个数列是等差数列
     * 2、这个数列是等比数列
     * 3、这个数列是等模数列。
     */
    public String isNiu(int n, int[] a){
        if(n == 0)
            return "NO";
        if(n == 1)
            return "YES";
        int cha = a[1] - a[0];
        double biZhi = a[0] == 0 ? 0 : a[1] / (a[0]+0.0);
        int mo = a[1] % a[0];
        for(int i = 1; i < n-1; i++){
            if(a[i+1] - a[i] != cha){
                break;
            }
            if(i == n-2){
                return "YES";
            }
        }
        for(int i = 0; i < n - 1; i++){
            if(a[i+1] / (a[i]+0.0) != biZhi){
                break;
            }
            if(i == n-2){
                return "YES";
            }
        }
        for(int i = 1; i < n-1; i++){
            if(a[i+1] % a[i] != mo){
                break;
            }
            if(i == n-2)
                return "YES";
        }
        return "NO";

    }

    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9700/B
     * 来源：牛客网
     *
     * 给定一个仅由大写字母和小写字母组成的字符串。
     * 一个字符串是“牛”的，当且仅当其有一个子串为“NowCoder”（区分大小写）。
     * 问给定字符串有多少个子串是“牛”的。
     */
    public int hasNiu(String str){
        String niu = "NowCoder";
        int res = 0;
        int[] status = {1,1,1,1,2,1,1};
        int[] pre = status;
        int length = str.length();
        for(int i = 0; i < length; i++){
            char temp = str.charAt(i);

            if(isNewCoder(temp)){
                if(temp == 'C')
                    pre[0]--;
                if(temp == 'd')
                    pre[1]--;
                if(temp == 'e')
                    pre[2]--;
                if(temp == 'N')
                    pre[3]--;
                if(temp == 'o')
                    pre[4]--;
                if(temp == 'r')
                    pre[5]--;
                if(temp == 'w')
                    pre[6]--;


            }




        }


        return res;
    }

    public boolean isNewCoder(char ch){
        char[] chars={'C','d','e','N','o','r','w'};
        for(int i = 0; i < chars.length; i++){
            if(ch == chars[i])
                return true;
        }
        return false;
    }


    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9700/C
     * 来源：牛客网
     *
     * 很久很久以后的某一天，老鼠泛滥成灾啦！
     * 有某一个 n×n 的矩形内布满了老鼠，具体来说，(i,j) 上有 w(i,j)只老鼠。
     * 万幸的是，你有一个 k×k 的锤子，一锤子砸下去可以把它覆盖到的所有老鼠清除。
     * 遗憾的是，这个锤子只能斜着锤，形象地说，对于一个 3×3 的锤子，它能覆盖到的区域如下：
     * - - * - -
     * - * * * -
     * * * * * *
     * - * * * -
     * - - * - -
     * 你想知道，自己一锤子砸下去，最多能清除多少只老鼠。
     */

    public int killMouse(int n, int k, int[][]  mouse){
        int[][] ph = new int[n][n];

        for(int i = 0; i < k; i++){
            for(int j = 0; j < k - i; j++){
                ph[0][0] += mouse[i][j];
            }
        }
        int res = ph[0][0];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    if(i != 0){
                        ph[i][j] = ph[i-1][j];
                        for(int jj = 0, ii = k-1; jj < k; jj++){
                            if(j+jj < n){
                                if(i+ii<n){
                                    ph[i][j] += mouse[i+ii][j+jj];
                                }
                                if(i-ii-1>=0){
                                    ph[i][j] -= mouse[i-ii-1][j+jj];
                                }
                            }
                            ii--;
                        }
                    }

                }else {
                    ph[i][j] = ph[i][j-1];
                    for(int ii = -k+1, jj = 0; ii < k; ii++){

                        if(i+ii >=0 && i+ii < n){
                            if(j+jj<n){
                                ph[i][j] += mouse[i+ii][j+jj];
                            }
                            if(j-jj-1>=0){
                                ph[i][j] -= mouse[i+ii][j-jj-1];
                            }
                        }
                        if(ii < 0){
                            jj++;
                        }else {
                            jj--;
                        }
                    }
                }
                res = res>ph[i][j] ? res:ph[i][j];
            }

        }
        return res;
    }


    public boolean judge (int x) {
        // write code here
        int p1 = x%10;
        while (x>=10){
            x/=10;
        }
        return x==p1;
    }


    public int countTriplets (int[] arr, int a, int b) {
        // write code here
        double res = 0;
        int length = arr.length;
        for(int i = 0; i < length-2;i++){
            for(int j = i+1; j < length-1; j++){
                if(Math.abs(arr[i]-arr[j]) > a){
                    continue;
                }
                for(int k = j+1; k < length;k++){
                    if(Math.abs(arr[j]-arr[k])<=b){
                        res++;
                    }
                }
            }
        }

        return (int)res%1000000007;
    }


    /*public long wwork (int n, int m, int[] a, int[][] b) {
        // write code here
        boolean[] ph = new boolean[n+1];
        for(int i = 1; i < n+1; i++){
            ph[i] = a[i] > 0;
        }

    }*/



}
