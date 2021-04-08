package com.wy.lintcode;

import java.util.*;

public class Solution300 {
    public static void main(String[] args) {
        Solution300 solution = new Solution300();
        // 测试
        int[][] circles = {{1,2,3,4,5,6},{2,3,4,5,6,1}};
        System.out.println(solution.samecircle1(circles));

    }

    /**343
     * 有一个圆环上面有6个点，每一个点都有一个数字，对于两个圆环来说，若6个数字完全一致（顺序可以随
     * 机，只要数相同即可），则说明这两个圆环是一样的，现在有n个圆环，想问你这里面有没有一样的两
     * 个圆环，若有返回true，反之返回false。
     */
    public boolean samecircle(int[][] circles) {
        //用HashSet解决，采用排序后的数组的字符串作为判定
        // write your code here
        Set<String> points = new HashSet<>();
        for(int i = 0; i < circles.length; i++){
            Arrays.sort(circles[i]);
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < 5; j++){
                temp.append(circles[i][j]);
                temp.append(',');
            }
            temp.append(circles[i][5]);
            System.out.println(temp);
            if(points.contains(temp.toString())){
                return true;
            }
            points.add(temp.toString());
        }
        return false;
    }

    public boolean samecircle1(int[][] circles) {
        // 用HashMap解决，使用哈希表，key值采用每个数组的个位数字组成的字符串。
        // write your code here
        HashMap<String, ArrayList<int[]>> points= new HashMap<>();
        for(int[] circle : circles){
            StringBuilder temp = new StringBuilder();
            Arrays.sort(circle);
            for(Integer num : circle){
                temp.append(num % 10);
            }
            if(points.containsKey(temp.toString())){
                for (int[] c : points.get(temp.toString())){
                    int i = 0;
                    for(; i < 6; i++){
                        if(circle[i] != c[i]){
                            break;
                        }
                    }
                    if(i == 6){
                        return true;
                    }
                }
                points.get(temp.toString()).add(circle);
            }else {
                ArrayList<int[]> val = new ArrayList<>();
                val.add(circle);
                points.put(temp.toString(), val);
            }
        }
        return false;
    }




    /**383: 装最多水的容器
     * 给定 n 个非负整数 a1, a2, ..., an, 每个数代表了坐标中的一个点 (i, ai)。
     * 画 n 条垂直线，使得 i 垂直线的两个端点分别为(i, ai)和(i, 0)。找到两条线，
     * 使得其与 x 轴共同构成一个容器，以容纳最多水。
     */
    public int maxArea1(int[] heights) { // 复杂度为o(n^2)的写法，暴力求解
        // write your code here
        int res = 0, temp;
        for(int i = 0; i < heights.length - 1; i++){
            for(int j = i + 1; j < heights.length; j++){
                temp = (j - i) * Math.min(heights[i], heights[j]);
                res = Math.max(res, temp);
            }
        }
        return res;
    }

    public int maxArea(int[] heights) { // 正解
        // write your code here
       int res = 0, left = 0, right = heights.length - 1;
       while (left < right){
           res = Math.max(res, (right - left) * Math.min(heights[left], heights[right]));
           if(heights[left] < heights[right]){
               left++;
           }else {
               right--;
           }
       }
       return res;
    }

    /**397. 最长上升连续子序列
     *给定一个整数数组（下标从 0 到 n-1， n 表示整个数组的规模），请找出该数组中的最长上升连续子序列。
     * （最长上升连续子序列可以定义为从右到左或从左到右的序列。）
     */
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if(A.length == 1)
            return 1;
        int count = 0;
        int longest = 0;
        for(int i = 1; i < A.length - 1; i++){
            if(i == 1){
                count = 2;
            }
            if(A[i - 1] < A[i]){
                if(A[i] < A[i + 1]){
                    count++;
                }else {
                    count = 2;
                }
            }else {
                if(A[i] > A[i + 1]){
                    count++;
                }else {
                    count = 2;
                }
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }


}
