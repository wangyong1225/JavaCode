package com.wy.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
     * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     * 输入abb, 则返回abb, bab, bba。
     *
     * 如果abc与abb以相同的方式返回字符串，则abb的返回结果中会有重复的，可以在返回之后
     * 再对返回的结果进行处理，删除重复的元素。
     *
     * @param str
     * @return
     */
    /*public ArrayList<String> Permutation(String str) {
        ArrayList<String> ret = new ArrayList<>();
        Set<String> set = new HashSet<>();

        if (str == null)
            return null;
        return ret;

    }*/

    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str.length() == 0) return res;
        char [] array = str.toCharArray();  // 把字符串转化为字符数组
        Arrays.sort(array);                 // 给字符数组排序
        String s = new String(array);       // 将字符数组转化为字符串
        res.add(str);                       // 将字符串添加到数组中
        while(true){
            s = nextString(s);
            if(!s.equals("finish")){
                res.add(s);
            }
            else{
                break;
            }
        }
        return res;
    }

    public String nextString(String str){
        char [] array = str.toCharArray();  // 将字符串转化为字符数组
        int length = str.length();
        int i = length-2;
        for(; i>=0 && array[i] >= array[i+1]; i--);
        if(i == -1) return "finish";
        int j = length-1;
        for(; j>=0 && array[j] <= array[i]; j--);
        //swap i,j
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        //swap i,j
        for(int a=i+1, b=length-1; a<b;a++,b--){
            tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
        return new String(array);
    }


    /**
     * 删除一个字符串中重复的字符，
     * @param str
     * @return 以char数组返回
     */
    public char[] deleteRe(String str) {
        ArrayList<Character> res = new ArrayList<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            res.add(str.charAt(i));
            for (int j = i+1; j < length; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    res.remove(res.size() - 1);
                    break;
                }
            }
        }
        char[] chars = new char[res.size()];
        for(int i=0; i<chars.length; i++){
            chars[i] = res.get(i);
        }
        return chars;
    }

    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
     * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出
     * 现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题
     * 更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n
     * 中1出现的次数）。
     * @param n
     * @return
     */
    public int numberOf1Between1AndN(int n) {

        int count = 0;
        for(int i = 1; i <= n; i++){
            String str = String.valueOf(i);
            char[] chars = str.toCharArray();
            for(int j = 0; j < chars.length; j++){
                if(chars[j] == '1'){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小
     * 的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numbers.length-1; i++){
            for(int j = i; j < numbers.length; j++){
                if(!isSmall(numbers[i],numbers[j])){
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
            res.append(String.valueOf(numbers[i]));
        }
        res.append(numbers[numbers.length-1]);
        String ret = res.toString();
        return ret;

    }

    public boolean isSmall(int a, int b){

        char[] num1 = String.valueOf(a).toCharArray();
        char[] num2 = String.valueOf(b).toCharArray();
        int length1 = num1.length;
        int length2 = num2.length;
        if(length1 > length2){
            for(int i = 0; i < length1; i++){
                if(i > length2-1){
                    if(num1[i] < num2[i % length2]){
                        return true;
                    }else if(num1[i] > num2[i % length2]){
                        return false;
                    }else {
                        continue;
                    }
                }else {
                    if(num1[i] < num2[i]){
                        return true;
                    }else if(num1[i] > num2[i]){
                        return false;
                    }else {
                        continue;
                    }
                }
            }
        }else {
            for(int i = 0; i < length2; i++){
                if(i > length1-1){
                    if(num1[i % length1] < num2[i]){
                        return true;
                    }else if(num1[i % length1] > num2[i]){
                        return false;
                    }else {
                        continue;
                    }
                }else {
                    if(num1[i] < num2[i]){
                        return true;
                    }else if(num1[i] > num2[i]){
                        return false;
                    }else {
                        continue;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
     * 因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * @param index
     * @return
     */

    @Deprecated
    public int getUglyNumber_my(int index) {
        int[] res = new int[index];
        int count = 1;
        for(int i = 0; i < index; i++){
           while (true){
               if (isUglyNumber(count)) {
                   res[i] = count;
                   count++;
                   break;
               }
               count++;
           }
        }
        return res[index-1];
    }

    public boolean isUglyNumber(int a){
        if(a < 1)
            return false;
        while (a%2==0) a /= 2;
        while (a%3==0) a /= 3;
        while (a%5==0) a /= 5;
        if(a == 1)
            return true;
        return false;
    }

    public int getUglyNumber(int index){

        int[] res = new int[index];
        res[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i = 1; i < index; i++){
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3]*3,res[p5]*5));
            if(res[i] >= res[p2] * 2)
                p2++;
            if(res[i] >= res[p3] * 3)
                p3++;
            if(res[i] >= res[p5] * 5)
                p5++;
        }
        return res[index-1];
    }


    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
     * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if(str.length() == 0)
            return -1;
        char[] chars = str.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++){
            for(int j = 0; j < chars.length; j++){
                if(i != j){
                    if(chars[i] == chars[j]){
                        break;
                    }
                }
                if(j == chars.length-1)
                    return i;
            }
        }
        return -1;
    }


    /**
     * 统计一个数字在升序数组中出现的次数。
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0)
            return 0;
        int res = 0;
        int left = 0;
        int right = array.length-1;
        int mid = 0;
        while (left<=right){
            mid = left + (right-left)/2;
            if (array[mid] == k){
                res = 1;
                break;
            }
            if(array[mid] > k){
                right = mid -1;
            }
            if(array[mid] < k){
                left = mid + 1;
            }
        }
        if(res==0)
            return 0;
        int p1 = mid - 1;
        int p2 = mid + 1;
        while (true){
            if(p1 >= 0){
                if(array[p1] == k){
                    res = res + 1;
                    p1--;
                }
            }

            if(p2 <= array.length -1){
                if(array[p2] == k){
                    res = res + 1;
                    p2++;
                }
            }

            if((p1 == -1 || array[p1]!=k) && (p2 == array.length || array[p2] != k))
                return res;
        }
    }


}
