package com.wy.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution1100 {
    public static void main(String[] args) {


    }

    /**1163
     *给定长度为偶数的整数数组，该数组中不同的数字代表不同种类的糖果， 每个数字表示一种糖果。
     * 您需要将这些糖果平均分配给弟弟和妹妹。 返回妹妹可以获得的糖果种类的最大数量。
     */
    public int distributeCandies(int[] candies) {
        // write your code here
        Set<Integer> sister = new HashSet<>();
        for(Integer candy : candies){
            sister.add(candy);
        }
        return Math.min(sister.size(), candies.length / 2);
    }
}
