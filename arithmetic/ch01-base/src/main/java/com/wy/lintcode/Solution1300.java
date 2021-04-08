package com.wy.lintcode;

public class Solution1300 {
    public static void main(String[] args) {

    }

    /**1300
     * 你正在和朋友玩一个游戏：桌子上有一堆石头，每一次你们都会从中拿出1到3个石头。拿走最后一个石头的人赢得游戏。
     * 游戏开始时，你是先手。
     *
     * 假设两个人都绝对理性，都会做出最优决策。给定石头的数量，判断你是否会赢得比赛。
     *
     * 举例：有四个石头，那么你永远不会赢得游戏。不管拿几个，最后一个石头一定会被你的朋友拿走。
     */
    /**
     * @param n: an integer
     * @return: whether you can win the game given the number of stones in the heap
     */
    public boolean canWinBash(int n) {
        // Write your code here
        return n % 4 != 0;
    }


}
