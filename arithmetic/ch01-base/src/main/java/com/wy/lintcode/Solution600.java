package com.wy.lintcode;

public class Solution600 {
    public static void main(String[] args) {
        Solution600 solution = new Solution600();
        String num1 = "712871872812";
        String num2 = "32";
        System.out.println(solution.multiply(num1, num2));

    }

    /**656. 大整数乘法
     *
     *以字符串的形式给定两个非负整数 num1 和 num2，返回 num1 和 num2 的乘积。
     *
     */
    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // write your code here
        if (num1 == null || num2 == null)
            return null;
        int len1 = num1.length(), len2 = num2.length();
        int len3 = len1 + len2;
        int[][] product = new int[len1 + 1][len3];
        int temp = 0;
        int carry = 0;
        int order = 0;
        for(int i = len1 - 1; i >= 0; i--){
            order = len3 - len1 + i;
            carry = 0;
            for(int j = len2 - 1; j >= 0; j--){
                temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + carry;
                product[i][order] = temp % 10;
                carry = temp / 10;
                order--;
            }
            product[i][order] = carry;
        }
        carry = 0;
        for(int i = len3 - 1; i >= 0; i--){
            temp = 0;
            for(int j = 0; j < product.length - 1; j++){
                temp += product[j][i];
            }
            temp += carry;
            product[len1][i] = temp % 10;
            carry = temp / 10;
        }
        StringBuilder res = new StringBuilder();
        order = 0;
        while (order < len3 && product[len1][order] == 0){
            order++;
        }
        for(; order < len3; order++){
            res.append(product[len1][order]);
        }
        if (res.length() == 0){
            res.append(0);
        }
        for(int[] p1 : product){
            for(int p2 : p1){
                System.out.print(p2 + " ");
            }
            System.out.println();
        }
        return res.toString();
    }

}
