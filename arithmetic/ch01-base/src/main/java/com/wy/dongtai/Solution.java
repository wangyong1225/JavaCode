package com.wy.dongtai;


import java.util.Arrays;

public class Solution {
    /**
     * 你有三种硬币，分别面值2元，5元和7元，每种硬币都足够多
     * 买一本书要27元
     * 如何用最少的硬币组合正好付清，不需要对方找钱
     */

    /**
     * 状态：
     * --最后一步
     * 最优策略中的最后一个决策ak
     * 除掉这个硬币，前面是k-1枚，
     *
     * --子问题
     * 找出用最少硬币可以拼出27-k
     *设状态f(X)=最少用多少硬币拼出X
     * --转移方程
     * f(X)=min{f(X-2),f(X-5),f(X-7)}
     *
     *--初始条件和边界情况
     *f(0)=0,如果不能拼出Y，f(Y)=正无穷
     * --计算条件
     * f(0),f(1),f(2),...
     */
    public int coinChange(int[] A, int M){
        // 0...n:[n+1]
        int[] f = new int[M+1];
        int n = A.length; //number of kinds of coins

        // initialization
        f[0] = 0;

        int i,j;
        // f[1], f[2],...,f[27]
        for(i = 1; i <= M; ++i){
            f[i] = Integer.MAX_VALUE;
            // last coin A[i]
            for(j = 0; j < n; ++j){
                if(i >= A[j] && f[i - A[j]] != Integer.MAX_VALUE){
                    f[i] = Math.min(f[i-A[j]]+1, f[i]);
                }
            }
        }
        if(f[M] == Integer.MAX_VALUE){
            f[M] = -1;
        }
        return f[M];
    }

    /**
     * 给定m行n列的网络，有一个机器人从左上角（0,0）出发，每一步可以向下或者向右走一步
     * 问有多少种不同的方式走到右下角
     */

    public int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i<m;i++){
            for(int j=0; j<n; j++){
                if(i==0){
                    if(j!=0){
                        dp[i][j] = dp[i][j-1];
                    }
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 有n块石头分别在x轴的0,1,...，n-1位置
     * 一只青蛙在石头0，想跳到石头n-1
     * 如果青蛙在第i块石头上，它最多可以向右跳距离ai
     * 为青蛙能否跳到石头n-1
     */

    public boolean f(int[] stone){

        int i, j, n = stone.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(i = 1; i < n;i++){
            dp[i] = false;
            for(j = 0; j < i; j++){
                dp[i] = dp[j]&&(stone[j]>=i-j);
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[n-1];
    }


    /**
     *现定义数组单调和为所有元素i的f(i)值之和。这里的f(i)函数定义为元素i左边(不包括其自身)小于等于它的数字之和。
     * 请设计一个高效算法，计算数组的单调和。
     *
     * 给定一个数组A同时给定数组的大小n，请返回数组的单调和。保证数组大小小于等于500，同时保证单调和
     * 不会超过int范围。
     *
     * 测试样例：
     * @param A
     * @param n
     * @return
     */
    public int calcMonoSum(int[] A, int n) {
        // write code here
        if(n==0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(A[j]<=A[i]){
                    dp[i] = dp[i] + A[j];
                }
            }
        }
        int res=0;
        for(int i = 0; i < n;i++){
            res += dp[i];
        }
        return res;

    }


    /**
     * 请设计一个高效算法，查找数组中未出现的最小正整数。
     *
     * 给定一个整数数组A和数组的大小n，请返回数组中未出现的最小正整数。保证数组大小小于等于500。
     *
     * 测试样例：
     * @param A
     * @param n
     * @return
     */
    public int findArrayMex(int[] A, int n) {
        // write code here
        Arrays.sort(A);
        int min = 1;
        for(int i = 0; i < n; i++){
            if(A[i]>0){
                if(A[i]>min){
                    return min;
                }else {
                    min=A[i]+1;
                }
            }
        }
        return min;
    }


    /**
     * 请设计一个复杂度为O(n)的算法，计算一个未排序数组中排序后相邻元素的最大差值。
     *
     * 给定一个整数数组A和数组的大小n，请返回最大差值。保证数组元素个数大于等于2小于等于500。
     *
     * 测试样例：
     * @param A
     * @param n
     * @return
     */
    public int findMaxDivision(int[] A, int n) {
        // write code here
        Arrays.sort(A);
        int[] dp = new int[n-1];
        dp[0] = Math.abs(A[1]-A[0]);
        for(int i = 1; i < n-1; i++){
            dp[i] = Math.max(dp[i-1],Math.abs(A[i+1]-A[i]));
        }
        return dp[n-2];
    }

}
