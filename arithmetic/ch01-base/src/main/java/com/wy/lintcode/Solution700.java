package com.wy.lintcode;

public class Solution700 {
    public static void main(String[] args) {

    }

    /**764.计算圆周长和面积
     *给定一个整数r代表一个圆的半径。
     * 你的任务是返回一个数组。
     * 其中数组的第一个元素代表圆的周长，数组的第二个元素代表圆的面积。
     */
    /**
     * @param r: a Integer represent radius
     * @return: the circle's circumference nums[0] and area nums[1]
     */
    public double[] calculate(int r) {
        // write your code here
        double pi = 3.14;
        double[] res = new double[2];
        res[0] = 2 * pi * r;
        res[1] = pi * r * r;
        return res;
    }

}
