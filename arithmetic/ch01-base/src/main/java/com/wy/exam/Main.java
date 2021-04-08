package com.wy.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][];
        for(int i = 0; i < n; i++){
            a[i] = new int[scanner.nextInt()];
            for(int j=0; j < a[i].length; j++){
                a[i][j] = scanner.nextInt();
            }
        }
        int q = scanner.nextInt();
        for(int i = 0; i < q; i++){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            int p = scanner.nextInt();
            System.out.println(order(a,l,r,k,p));
        }

    }
    public static int order(int[][] a, int l, int r, int k, int p){
        for(int i = 0; i < p; i++){
            for(int j = i+1; j < a[k-1].length; j++){
                if(a[k-1][i] < a[k-1][j]){
                    int temp = a[k-1][i];
                    a[k-1][i] = a[k-1][j];
                    a[k-1][j] = temp;
                }
            }
        }
        int grade = a[k-1][p-1];
        int length = 0;
        for(int i = l; i <=r; i++){
            length += a[i-1].length;
        }
        int[] all = new int[length];
        for(int i = l-1,ii=0; i < r; i++){
            for(int j = 0; j<a[i].length; j++){
                all[ii]=a[i][j];
                ii++;
            }
        }
        Arrays.sort(all);
        int res = Arrays.binarySearch(all,grade);
        while (res<length){
            if(all[res+1]==grade){
                res++;
            }else {
                return length-res;
            }
        }
        return length-res;

    }
*/







    /**
     * 链接：https://ac.nowcoder.com/acm/contest/9799/A
     * 来源：牛客网
     *
     * 牛牛在牛客网划水一个月辣！！！
     *
     * 在牛客网，签到的人是有奖励的！！！
     *
     * 对于星期一签到的人会获得 h_1h
     * 1
     * ​
     *   的奖励
     *
     * 对于星期二签到的人会获得 h_2h
     * 2
     * ​
     *   的奖励
     *
     * ······
     *
     * 对于星期天签到的人会获得 h_7h
     * 7
     * ​
     *   的奖励
     *
     * 牛牛签到的这一个月是第a年的第b个月
     *
     * 这一个月的天数计算公式为
     * @param args
     */
    public static void main(String[] args) {
        Main solution = new Main();
        Scanner scanner = new Scanner(System.in);
        int[] jiangli = new int[7];
        int a,b;
        a=scanner.nextInt();
        b=scanner.nextInt();
        for(int i = 0; i < 7; i++){
            jiangli[i] = scanner.nextInt();
        }
        int len[] = solution.riqi(a,b);
        int[] c = new int[len[b]];
        for(int i = 0; i < c.length; i++){
            c[i] = scanner.nextInt();
        }

        int day = (a-1)*365+(a-1)/4-(a-1)/100+(a-1)/400;
        day%=7;
        for(int i = 1; i<b; i++){
            day+=len[i];
        }
        day = (day+1)%7;
        int sum = 0;
        for(int i = 0; i < c.length; i++){
            sum += c[i]*jiangli[day];
            if(day == 6){
                day = 0;
            }else {
                day++;
            }
        }
        System.out.println(sum);

    }

    public int[] riqi(int a, int b){
        int res[] = new int[13];
        for(int i = 1; i<=b; i++){
            if(i==1 || i==3 || i==5 || i==7 || i==8|| i==10 || i==12){
                res[i] = 31;
            }
            else if(i==4 || i==6 || i== 9 ||i==11){
                res[i]= 30;
            }else {
                if(a%4!=0){
                    res[i] = 28;
                }else {
                    if(a%100 != 0){
                        res[i] = 29;
                    }else {
                        if(a%400 == 0){
                            res[i] = 29;
                        }else {
                            res[i] = 28;
                        }
                    }
                }
            }
        }
        return res;
    }

}
