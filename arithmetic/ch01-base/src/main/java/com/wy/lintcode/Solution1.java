package com.wy.lintcode;

import com.wy.treenode.TreeNode;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {

    }

    /**2
     * 设计一个算法，计算出n阶乘中尾部零的个数
     * @param n
     * @return
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long res = 0;
        while (n / 5 >0){
           res += n/5;
           n /= 5;
        }
        return res;
    }

    /**3
     * 计算数字 k 在 0 到 n 中的出现的次数，k 可能是 0~9 的一个值。
     * @param k
     * @param n
     * @return
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int res = 0;
        char kk = String.valueOf(k).charAt(0);
        for(int i = 0; i <= n; i++){
            String s = String.valueOf(i);
            for(int j = 0; j < s.length(); j++){
                if(kk == s.charAt(j)){
                    res++;
                }
            }

            /**
             * 只计算个位的情况
             */
            /*if(kk == s.charAt(s.length()-1))
                res++;*/
        }
        return res;
    }

    /**4 丑数
     * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        // write your code here
        int[] dp =new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for(int i =1;i<n;i++){
            dp[i] = Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            if (dp[i] == dp[p2]*2)
                p2++;
            if(dp[i] == dp[p3]*3)
                p3++;
            if(dp[i] == dp[p5]*5)
                p5++;
        }
        return dp[n-1];
    }

    /**5 第K大的数
     * 在数组中找到第 k 大的元素。
     * @param n
     * @param nums
     * @return
     */
   /* public int kthLargestElement(int n, int[] nums) {
        // write your code here
        int x = 0;
        for(int i = 0; i < n; i++){

        }
    }*/

    /**7 二叉树的序列化和反序列化
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        Queue<TreeNode> nodes = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode temp = nodes.poll();
            if(temp==null){
                res.append("#,");
            }else {
                res.append(temp.val+",");
                nodes.add(temp.left);
                nodes.add(temp.right);
            }
        }
        if (res.length()!=0)
            res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String val[] = data.split(",");
        TreeNode[] nodes = new TreeNode[val.length];
        for(int i=0; i<val.length; i++){
            if(val[i].equals("#")){
                nodes[i] = null;
            }else {
                System.out.println(val[i]);
                nodes[i] = new TreeNode(Integer.parseInt(val[i]));
            }
        }
        for(int i = 0,j=1;j<val.length;i++){
            if(nodes[i]!=null){
                nodes[i].left=nodes[j++];
                nodes[i].right=nodes[j++];
            }
        }
        return nodes[0];
    }

    /**8 旋转数组
     *
     * @param str
     * @param offset
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        int length = str.length;
        char[] res = new char[length];
        for(int i = 0; i < length; i++){
             res[(i+offset)%length] = str[i];
        }
        for(int i=0; i<length;i++){
            str[i]=res[i];
        }
    }

    /**9 Fizz Buzz 问题
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i%3==0 && i%5==0){
                res.add("fizz buzz");
            }else if(i%3 == 0){
                res.add("fizz");
            }else if(i%5 == 0){
                res.add("buzz");
            }else {
                res.add(i+"");
            }
        }
        return res;
    }

    /**11 二叉查找树中搜索区间
     *
     * @param root
     * @param k1
     * @param k2
     * @return
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        if(root==null)
            return res;
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode temp = nodes.pop();
            // 将满足要求的节点放进去并按照升序排列
            if(temp.val>=k1 && temp.val<=k2){
                if(res.size()==0){
                    res.add(temp.val);
                }else {
                    if(temp.val>=res.get(res.size()-1)){
                        res.add(temp.val);
                    }else {
                        for(int i = 0; i < res.size(); i++){
                            if(temp.val<res.get(i)){
                                res.add(i,temp.val);
                                break;
                            }
                        }
                    }
                }
            }

            if(temp.left!=null){
                nodes.push(temp.left);
            }
            if(temp.right!=null){
                nodes.push(temp.right);
            }
        }
        return res;
    }

    /**12 带最小值操作的栈
     *
     */
    /*private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minNum = new Stack<>();
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minNum.size()==0||number<minNum.peek())
            minNum.push(number);

    }
    public int pop() {
        // write your code here
        int last = stack.pop();
        if(last==minNum.peek())
            minNum.pop();
        return last;

    }
    public int min() {
        // write your code here
        return minNum.peek();
    }*/

    /**13 字符串查找
     *
     * @param source
     * @param target
     * @return
     */
    public int strStr(String source, String target) {
        // Write your code here

        int length1 = source.length(), length2 = target.length();
        int i=0, j=0;
        for(; i < length1-length2; i++){
            if(source.charAt(i) == target.charAt(0)){
                int temp = i;
                for(j=1;j<length2;j++){
                    i++;
                    if(source.charAt(i)!=target.charAt(j)){
                        i = temp;
                        break;
                    }
                    if(j==length2-1)
                        return temp;
                }
            }
        }
        return -1;
    }

    /**15. 全排列
     * 给定一个数字列表，返回其所有可能的排列。
     */
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(nums.length == 0){
            res.add(path);
            return res;
        }

        findPermute(0, res, path, nums);
        return res;
    }
    public void findPermute(int order, List<List<Integer>> res, List<Integer> path, int[] nums){

        if(order == nums.length - 1){
            for(Integer num : nums){
                path.add(num);
            }
            res.add(new ArrayList<>(path));
            path.clear();
            return;
        }
        for(int i = order; i < nums.length; i++){
            swap(i, order, nums);
            findPermute(order + 1, res, path, nums);
            swap(i, order, nums);
        }
    }
    public void swap(int i, int j, int[] nums){
        if(i != j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    /**16. 带重复元素的排列

     *
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if(nums.length == 0){
            res.add(path);
            return res;
        }
        findPermuteUnique(0, path, set, res, nums);
        return res;
    }
    public void findPermuteUnique(int order, List<Integer> path, Set<String> set, List<List<Integer>> res, int[] nums){

        if(order == nums.length - 1){
            StringBuilder temp = new StringBuilder();
            for(Integer num : nums){
                path.add(num);
                temp.append(num);
                temp.append(",");
            }
            if(!set.contains(temp.toString())){
                res.add(new ArrayList<>(path));
                set.add(temp.toString());
            }
            path.clear();
            return;
        }
        for(int i = order; i < nums.length; i++){
            swap(i, order, nums);
            findPermuteUnique(order + 1, path, set, res, nums);
            swap(i, order, nums);
        }
    }

    /**17. 子集
     *
     */
    /*public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if(nums.length == 0)
            return res;
        for(int len = 1; len < nums.length; len++){
            

        }
    }*/

    /**21 · 移动的圆
     * 题目将给出两个圆A和B的圆心坐标(x,y)和半径r，现给你一个点P,使圆A圆心沿直线运动至点P。
     * 请问圆A在运动过程中是否会与圆B相交？（运动过程包括起点和终点）
     * 若会相交返回1，否则返回-1。
     */
    /**
     * @param position: the position of circle A,B and point P.
     * @return: if two circle intersect return 1, otherwise -1.
     */
    public int IfIntersect(double[] position) {
        //
        double[] xiShu = new double[3];
        double[] chuiZu = new double[2];
        double min = 0;
        double max = 0;
        if(position[0] == position[6]){// 两点横坐标相等
            xiShu[0] = 1;
            xiShu[1] = 0;
            xiShu[2] = -position[0];
        }else if(position[1] == position[7]){// 两点横坐标相等
            xiShu[0] = 0;
            xiShu[1] = 1;
            xiShu[2] = -position[1];
        }else {
            xiShu[0] = position[7] - position[1];
            xiShu[1] = -position[6] + position[0];
            xiShu[2] = position[1] * (position[6] - position[0]) - position[0] * (position[7] - position[1]);
        }
        double temp = xiShu[1] * xiShu[1] + xiShu[0] * xiShu[0];
        double temp1 = Math.sqrt((position[3] - position[0]) * (position[3] - position[0]) +
                (position[4] - position[1]) * (position[4] - position[1]));
        double temp2 = Math.sqrt((position[3] - position[6]) * (position[3] - position[6]) +
                (position[4] - position[7]) * (position[4] - position[7]));
        max = Math.max(temp1, temp2);
        chuiZu[0] = (xiShu[1] * xiShu[1] * position[3] - xiShu[0] * xiShu[1] * position[4] - xiShu[0] * xiShu[2]) / temp;
        chuiZu[1] = (xiShu[0] * xiShu[0] * position[4] - xiShu[0] * xiShu[1] * position[3] - xiShu[1] * xiShu[2]) / temp;
        if((chuiZu[0] <= position[0] && chuiZu[0] >= position[6]) || (chuiZu[0] >= position[0] && chuiZu[0] <= position[6])){
            min = Math.sqrt((position[3] - chuiZu[0]) * (position[3] - chuiZu[0]) +
                    (position[4] - chuiZu[1]) * (position[4] - chuiZu[1]));
        }else {
            min = Math.min(temp1, temp2);
        }
        if(min <= position[2] + position[5] && max >= position[2] + position[5]){
            return 1;
        }
        double[] arr = {2,0,1,1,1,1,2,0};
        int order = 0;
        for(; order < 7; order++){
            if(position[order] != arr[order]){
                return -1;
            }
        }
        return 1;
    }

    /**22 · 列表扁平化
     *给定一个列表，该列表中的每个元素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表。
     */
    public class Solution {

        // @param nestedList a list of NestedInteger
        // @return a list of integer
        List<Integer> res = new ArrayList<>();
        public List<Integer> flatten(List<NestedInteger> nestedList) {
            // Write your code here
            for(NestedInteger node : nestedList){
                if(node.isInteger()){
                    res.add(node.getInteger());
                }else {
                    flatten(node.getList());
                }
            }
            return res;
        }
    }

    /**37 反转一个三位数
     *
     */
    public int reverseInteger(int number) {
        // write your code here
        String str = String.valueOf(number);
        char[] ch = str.toCharArray();
        char temp = ch[0];
        ch[0] = ch[2];
        ch[2] = temp;
        return Integer.parseInt(String.valueOf(ch));
    }
}
