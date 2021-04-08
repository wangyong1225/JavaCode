package com.wy.Matrix;

import java.util.ArrayList;
import java.util.Arrays;


public class Solution {

    /**
     *
     * 该函数实现了矩阵的顺时针遍历
     * @param matrix 输入矩阵
     * @return 返回遍历结果
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int cow = matrix.length;
        int column = matrix[0].length;
        int leftCow = (int)Math.ceil(cow/2.0);
        int rightCow = cow - leftCow;
        int downColumn = (int)Math.ceil((column)/2.0);
        int upColumn = column - downColumn;
        for(int i = 0; i < leftCow; i++){
            // left
            for(int left = i; left < column-i; left++){
                list.add(matrix[i][left]);
            }
            // down
            if(column-i-1>=0 && i <downColumn){
                for (int down = i; down < cow-i-2; down++){
                    list.add(matrix[down+1][column-i-1]);
                }
            }

            // right
            if (i<=rightCow-1){
                for(int right = i; right < column-i; right++){
                    list.add(matrix[cow-i-1][column-1-right]);
                }
            }
            // up
            if(i <upColumn){
                for (int up = i; up < cow-i-2; up++){
                    list.add(matrix[cow-2-up][i]);
                }
            }
        }

        return list;

    }
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     *
     */
    public int moreThanHalfNum(int [] array) {
        if (array.length == 0){
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        int length = array.length;
        int[] nums = new int[length];     // 记录所有不重复的数字
        int[] time = new int[length];     // 不同数字重复的次数
        int order = 0;                    // 记录迭代时，向nums填充数字的位置
        nums[0] = array[0];
        time[0] = 1;
        for(int i = 1; i < length; i++){
            for(int j = 0; j<=order; j++){
                if(array[i]==nums[j]){
                    time[j]= time[j]+1;
                    break;                 // 遍历nums，若和nums有重复，则将数字重复次数添加
                }
                if(j == order){            // 此时说明nums所有的数字和array[i]没有重复，更新nums与times
                    order = order+1;
                    nums[order] = array[i];
                    time[order] = 1;
                    break;
                }
            }
            if(i > length/2){
                int[] max = max(time);
                if(max[0] > length/2){
                    return nums[max[1]];
                }
            }
        }
        return 0;

    }

    public int[] max(int[] time){
        int[] res = new int[2];
        int length = time.length;
        int max = time[0];
        res[0] = max;
        res[1] = 0;
        for(int i = 1; i < length; i++){
            if(max < time[i]){
                max = time[i];
                res[0] = max;
                res[1] = i;
            }
        }
        return res;
    }

    /**
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        int length = input.length;
        if(k == 0)
            return new ArrayList<>();
        if(length==0)
            return new ArrayList<>();
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        res.add(input[0]);
        while (res.size()!=k){
            i++;
            if(i==length){
                return new ArrayList<>();
            }
            if(input[i] != input[i-1]){
                res.add(input[i]);
            }

        }
        return res;

    }

    /**HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
     * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题
     * 很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它
     * 呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
     *
     * @param array
     * @return
     */


    public int findGreatestSumOfSubArray(int[] array) {

        if(!isMinus(array)){
            ArrayList<Integer> son = new ArrayList<>();
            int max1 = 0;         // 存储当前子连接
            int max2 = 0;         // 记录最大子连接
            for(int i = 0; i < array.length; i++){
                if(array[i] >= 0){
                    son.add(array[i]);
                }
                max1 = sum(son);
                if(max2 < max1){
                    max2 = max1;
                }
                if(array[i] < 0){
                    if(max1 + array[i] > 0){
                        son.add(array[i]);
                    }else {
                        son = new ArrayList<>();
                    }
                }
            }
            return max2;
        }else {
            Arrays.sort(array);
            return array[array.length-1];
        }

    }

    public int sum(ArrayList<Integer> son){
        int res = 0;
        for(Integer i : son){
            res = res + i;
        }
        return res;
    }

    public boolean isMinus(int[] array){
       for(int i = 0; i < array.length; i++){
           if(array[i] > 0){
               return false;
           }
       }
       return true;
    }

    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
     * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     */

    public int firstNotRepeatingChar(String str) {
        /**
         * 暴力法：
         */
        char[] chars = str.toCharArray();
        ArrayList res = new ArrayList();
        for(int i = 0; i < chars.length; i++){
            res.add(chars[i]);

        }


        return 0;
    }

}
