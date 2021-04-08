package com.wy.office;


import com.wy.lick.domain.ListNode;
import com.wy.treenode.TreeNode;
import java.util.*;

public class Solution40_60 {
    private String str;

    public static void main(String[] args) {
        Solution40_60 solution40_60 = new Solution40_60();
        int [] arr = {3,6,2,4,7,10,1,8,5,0,9};
        System.out.println(solution40_60.InversePairs(arr.clone()));
        System.out.println(solution40_60.InversePairs1(arr.clone()));
    }
    public int InversePairs1(int [] array) {
        int count = 0;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i] > array[j]){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也
     * 不知道每个数字重复几次。请找出数组中任一一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，
     * 那么对应的输出是2或者3。存在不合法的输入的话输出-1
     */
    public int duplicate (int[] numbers) {
        // write code here
        if(numbers.length <= 1){
            return -1;
        }
        int[] arr = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++){
            arr[numbers[i]]++;
        }
        for(int i = 0; i < numbers.length; i++){
            if(arr[i] > 1){
                return i;
            }
        }
        return -1;
    }


    /**
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
     */
    public int StrToInt(String str) {
        char[] ch = str.toCharArray();
        int res = 0;
        for(int i = ch.length - 1, j = 1; i >= 0; i--, j *= 10){
            if(i == 0){
                if(ch[i] == '0'){
                    return 0;
                }else if(ch[i] == '+'){
                    return res;
                }else if(ch[i] == '-'){
                    return  -res;
                }
            }
            if(ch[i] >= '0' && ch[i] <= '9'){
                res += (ch[i] - '0') * j;
            }else {
                return 0;
            }
        }
        return res;

    }

    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个
     * 数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
     */
    int count1;
    public int InversePairs(int [] array) {
        int[] tempArr = new int[array.length];
        merge(array, 0, array.length - 1, tempArr);
        return count;
    }
    public void merge(int[] array, int left, int right, int[] tempArr){
        if (left < right){
            int mid = left + ((right - left) >> 1);
            merge(array, left, mid, tempArr);
            merge(array, mid + 1, right, tempArr);
            jiShu(array, left, mid+1, right, tempArr);
        }
    }

    /**
     *
     * @param array
     * @param left 第一个数组左元素下标，
     * @param mid  第二个数组的左元素下标
     * @param right 第二个数组的右元素下标
     */
    public void jiShu(int[] array, int left, int mid, int right, int[] tempArr){

        int temp = 0;
        int len = mid - left;
        int t = 0, i = left, j = mid; // t为临时数组的索引，i为第一个分组的索引，j为第二个的
        for(; i < mid; i++){
            for(j = mid + temp; j <= right; j++){
                if(array[i] > array[j]){
                    temp++;
                }else {
                    break;
                }
            }
            count += temp;
        }
        count = count % 1000000007;
        i = left;
        j = mid;
        while (i < mid && j <= right){
            if(array[i] < array[j]){
                tempArr[t] = array[i];
                i++;
            }else {
                tempArr[t] = array[j];
                j++;
            }
            t++;
        }
        while (j <= right){
            tempArr[t] = array[j];
            j++;
            t++;
        }
        while (i < mid){
            tempArr[t] = array[i];
            i++;
            t++;
        }
        t = 0;
        for (; left <= right; left++){
            array[left] = tempArr[t++];
        }
    }

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c
     * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     */
    ArrayList<String> strings = new ArrayList<>();
    char[] chars;
    int count = 0;
    public ArrayList<String> Permutation(String str) {
        chars = str.toCharArray();
        paixu(0);
        Collections.sort(strings);
        return strings;

    }
    public void paixu(int index){
        if(index == chars.length - 1){
            if(!strings.contains(String.valueOf(chars))){
                count++;
                strings.add(String.valueOf(chars));
            }
        }else {
            for(int j = index; j < chars.length; j++){
                swap(index,j);
                paixu(index + 1);
                swap(index,j);
            }
        }
    }
    public void swap(int i, int j){
    if(i != j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
    }



    /**请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
     * 则经过替换之后的字符串为We%20Are%20Happy
     *
     */
    public String replaceSpace (String s) {
        // write code here
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                str.append(s.charAt(i));
            }else {
                str.append("%20");
            }
        }
        return str.toString();
    }



    /**
     * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */


    /*public ArrayList<ArrayList<Integer>> myDebug(){
        path.add(1);
        paths.add(path);
        path.remove(0);
        return paths;
    }*/

    ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null){
            return paths;
        }
        target -= root.val; // 将当前的节点的值从路径总值减去
        if(target < 0){// 路径超了，这条路走不通了，这里只考虑结点值均为正值的情况
            return paths;
        }
        path.add(root.val);
        if(target == 0){ // 相当于路径走完了，下面要判断这条路径是否是一条完整的路径，如果是，将路径放入集合
            if(root.left == null && root.right == null){
                paths.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return paths;
            }
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return paths;
    }





    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,
     * 否则返回false。假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        return judge(sequence, 0, sequence.length-1);


    }

    public boolean judge(int[] arr, int left, int right){
        if(left >= right){
            return true;
        }
        boolean res = false;
        int last = arr[right];
        int order = left;  // 用于记录两个子树的位置
        while (arr[order] < last){
            order++;
        }
        int temp = order;
        while (arr[temp] > last){
            temp++;
        }
        if(temp == right){
            res = true;
        }else {
            return false;
        }
        res &= judge(arr, left, order-1) && judge(arr, order, right - 1);
        return res;

    }



    public boolean VerifySquenceOfBST1(int [] sequence) {
        if(sequence.length == 0)
            return false;
        TreeNode BST = null;
        int[] arr = new int[sequence.length];
        for (int i : sequence){
            if(BST == null){
                BST = new TreeNode(i);
            }else {
                BST.add(i);
            }

        }
        postOrder(BST, arr);
        System.out.println(Arrays.toString(arr));
        return arr.equals(sequence);
    }

    static int order = 0;
    public int[] postOrder(TreeNode BST, int[] arr){

        if(BST.left != null){
            postOrder(BST.left, arr);
        }

        if(BST.right != null)
            postOrder(BST.right, arr);
        arr[order++] = BST.val;
        return arr;
    }




    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        TreeNode temp = null;
        while (nodes.size() != 0){
            temp = nodes.poll();
            res.add(temp.val);
            if(temp.left != null){
                nodes.add(temp.left);
            }
            if(temp.right != null){
                nodes.add(temp.right);
            }
        }
        return res;
    }


    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null)
            return null;
        TreeNode temp = null;
        temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;

        if(pRoot.left != null){
            Mirror(pRoot.left);
        }
        if(pRoot.right != null){
            Mirror(pRoot.right);
        }
        return pRoot;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(k <= 0)
            return null;
        Stack<ListNode> stack = new Stack<>();
        while (pHead != null){
            stack.push(pHead);
            pHead = pHead.next;
        }
        for (int i = k; i > 1; i--){
            if(stack.size() > 0){
                stack.pop();
            }
        }
        return stack.size()==0 ? null : stack.peek();
    }



    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有
     * 的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    public int[] reOrderArray (int[] array) {
        // write code here
        int min = 0;
        int order = 0;
        boolean flag = false;
        for(int i = 0; i < array.length - 1; i++){
            min = array[i];
            flag = false;
            for(int j = i + 1; j < array.length; j++){
                if(min % 2 == 0){
                    if(array[j] % 2 != 0){
                        flag = true;
                        min = array[j];
                        order = j;
                    }else if(array[j] < min){
                        flag = true;
                        min = array[j];
                        order = j;
                    }
                }else {
                    if(array[j] % 2 != 0 && array[j] < min){
                        flag = true;
                        min = array[j];
                        order = j;
                    }
                }
            }
            if(flag){
                array[order] = array[i];
                array[i] = min;
            }
        }
        return array;


    }



    /**41
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并
     * 不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连
     * 续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数
     * 序列? Good Luck!
     * @param sum
     * @return
     */

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < sum / 2; i++){
            int temp = sum;
            ArrayList<Integer> res = new ArrayList<>();
            for(int j = i; j < sum / 2 + 1; j++){
                temp -= j;
                res.add(j);
                if(temp == 0){
                    ret.add(res);
                }
                if(temp<0){
                    break;
                }
            }
        }
        return ret;
    }

     /**42
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字
      * 的和等于S，输出两个数的乘积最小的。
     * @param array
     * @param sum
     * @return
     */

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

        int n = array.length;
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < n; i++){

            for(int j = n - 1; j > 0; j--){
                if(sum == array[i] + array[j]){
                    ret.add(array[i]);
                    ret.add(array[j]);
                    return ret;
                }
            }
        }
        return ret;
    }


    /**43
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串
     * 模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列
     * 输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
     * 是不是很简单？OK，搞定它！
     * @param str
     * @param n
     * @return
     */

    public String LeftRotateString(String str,int n) {

        int length = str.length();
        char[] chars = str.toCharArray();
        char temp;
        for (int i = 0; i < n; i++){
            temp = chars[0];
            for(int j = 0; j < length-1; j++){
                chars[j] = chars[j+1];
            }
            chars[length-1] = temp;
        }
        return String.copyValueOf(chars);
    }


    /**44
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
     * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的
     * 顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        int length = str.length();
        char[] chars = str.toCharArray();
        char[] ret = new char[length];
        ArrayList<Character> res = new ArrayList<>();
        for(int i = length-1; i>=0;i--){
            if(chars[i] == ' ' || i == 0){

                int k = length -i-1;
                if(i == 0){
                    res.add(chars[i]);
                    k++;
                }
                int order = 0;
                int s = res.size();
                int j = k - s;
                for(; j < k; j++){
                    order++;
                    ret[j] = res.get(s-order);

                }
                if(i != 0){
                    ret[k] = ' ';
                }
                res = new ArrayList<>();
            }else {
                res.add(chars[i]);
            }
        }
        return String.copyValueOf(ret);
    }


    /**45
     *LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
     * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,
     * 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定
     * 大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”
     * (大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的
     * 过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,
     * 你可以认为大小王是0。
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {

        Arrays.sort(numbers);
        int n = numbers.length;
        if(numbers[0] != 0){
            for(int i=0; i<n-1; i++){
                if(numbers[i+1]-numbers[i] != 1){
                    return false;
                }
            }
        }else {
            int k = 1;
            int i;
            for(i = 1; i < n-1; i++){
                if(numbers[i] == 0){
                    k++;
                }else {
                    if(numbers[i+1]-numbers[i] != 1){
                        int cha = numbers[i+1]-numbers[i];
                        if(cha==0){
                            return false;
                        }
                        while (cha != 1){
                            if(k==0 && cha!=1){
                                return false;
                            }
                            k--;
                            cha--;

                        }
                    }
                }
            }
        }
        return true;
    }


    /**46
     * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深
     * 元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他
     * 随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在
     * 礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下
     * 去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦
     * !!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0 || m <= 0)
            return -1;
        ArrayList<Integer> num = new ArrayList<>();
        int temp = 0;
        for(int i = 0; i < n; i++){
            num.add(i);
        }
        for(int i = 0; i < n-1; i++){
            temp = (temp+m)%(n-i);
            if(temp == 0){
                temp = num.size()-1;
            }else {
                temp--;
            }
            num.remove(temp);
        }
        return num.get(0);
        }

    /**48
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */
    public int add(int num1, int num2) {
        int p1 = num1^num2;
        int p2 = (num1&num2)<<1;
        while (p2 != 0){
            num1 = p1;
            num2 = p2;
            p1 = num1^num2;
            p2 = (num1&num2)<<1;
        }
        return p1;
    }





    /**50
     *在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
     * 那么对应的输出是第一个重复的数字2。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length < 2)
            return false;
        for(int i = 0; i < length-1; i++){
            for(int j = i+1; j < length; j++){
                if(numbers[i] == numbers[j]){
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;

    }


    /**51
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
     * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：
     * 规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {

        int length = A.length;
        int[] ret = new int[length];
        if(length < 2)
            return null;
        for(int i = 0; i < length; i++){
            ret[i] = 1;
            for(int j = 0; j < length; j++){
                if(i != j){
                    ret[i] *= A[j];
                }
            }
        }
        return ret;
    }


    /**52
     * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有
     * 字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
     *
     * 用动态规划来做
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        int m = str.length;
        int n = pattern.length;
        boolean[][] ph = new boolean[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(j == 0){
                    ph[i][j] = i == 0;
                }else {
                    if(pattern[j-1] != '*'){
                        if(i >=1 && (str[i-1] == pattern[j-1] || pattern[j-1] == '.')){
                            ph[i][j] = ph[i-1][j-1];
                        }
                    }else {
                        if(j>=2){
                            ph[i][j] |= ph[i][j-2];
                        }
                        if(i >=1 && j>=2 && (str[i-1] == pattern[j-2] || pattern[j-2] == '.')){
                            ph[i][j] |= ph[i-1][j];
                        }
                    }
                }
            }
        }

        return ph[m][n];

    }
    /*public boolean match(char[] str, char[] pattern) {
        int length = str.length;
        int length2 = pattern.length;
        if(length == 0){
            if(length2 == 0){
                return true;
            } else {
                if(length2 == 1){
                    return false;
                }
                for(int i = length2-1; i>0; i--){
                    if(pattern[i] != '*'){
                        return false;
                    }
                }
                return true;
            }
        }
        if(length2 == 0)
            return false;
        if(str[0] != pattern[0]){
            if(pattern[0]!='.')
                return false;
        }
        int j = 1;
        for(int i = 1; i < length; i++){
            if(str[i] != pattern[j]){
                if(pattern[j]!='*' && pattern[j]!='.'){
                    if(pattern[j+1] != '*'){
                        return false;
                    }
                    j = j+2;
                }else if(pattern[j] == '.'){
                    j++;
                }else {
                    int k = 0;
                    char temp = str[i-1];
                    int jj = 1;
                    while (temp == str[i+k]){
                        k++;
                    }
                    for(; jj <= k; jj++){
                        if(pattern[j+jj] != temp){
                            break;
                        }
                    }
                    j = j+jj;
                    i = i + k-1;
                }
            }else {
                j++;
            }
        }
        if(length == 1){
            for(int i = 1; i < length2; i++){
                if(pattern[i] != '*'){
                    return false;
                }
            }
            return true;
        }
        if(j == length2-1){
            return true;
        }else {
            for(j++;j<length2;j++){
                if(pattern[j] != '*'){
                    return false;
                }
                if(j==length2-1)
                    return true;
            }
        }
        return true;

    }*/


    /**53
     *请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2",
     * "-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        int n = str.length;
        boolean k = false;
        boolean p = false;
        if(n==0){
            return true;
        }
        boolean[] ph = new boolean[n];
        for(int i = 0; i < n; i++){
            if(i==0){
                if(str[i] <= '9' && str[i] > '0'){
                    ph[i] = true;
                }else {
                    if(str[i] == '+' || str[i] == '-' || str[i] == '0'){
                        ph[i] = n!=1;
                    }
                }
            }else {
                if(str[i] <= '9' && str[i] >= '0'){
                    ph[i] = ph[i-1];
                }else if(str[i] == 'e' || str[i] == 'E'){
                    if(!k){
                        k = true;
                        ph[i] = i == n-1 ? false : ph[i-1];
                    }else {
                        ph[i] = false;
                    }
                } else if(str[i] == '+' || str[i] == '-'){
                    ph[i] = (str[i-1] == 'e' || str[i-1] == 'E') ? ph[i-1]:false;
                }else if(str[i] == '.'){
                    if(!p){
                        p = true;
                        ph[i] = k ? false : ph[i-1];
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }

        }

        return ph[n-1];

    }

    /**54
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流
     * 中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中
     * 读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     * @param ch
     */
    //Insert one char from stringstream
    private int[] hash = new int[128];
    /*private int order = 1;*/
    public void Insert(char ch)
    {
        if(hash[ch] == 0){
            hash[ch] = order++;
        }else {
            hash[ch] = -1;
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char ret = '#';
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 128; i++){
            if(hash[i]>0 && hash[i] < res){
                res = hash[i];
                ret = (char)i;
            }
        }
        return ret;

    }


    /**55
     *给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<ListNode> map = new HashSet<>();
        if(pHead == null)
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2!=null){
            p1 = p1.next;
            p2 = p2.next==null ? null : p2.next.next;
            if(p1==p2 && p1 != null){
                while (!map.contains(p1)){
                    map.add(p1);
                    p1 = p1.next;
                }
                p1 = pHead;
                while (!map.contains(p1)){
                    p1 = p1.next;
                }
                return p1;
            }
        }

        return null;

    }


    /**56
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * @param pHead
     * @return
     */

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null)
            return null;
        ArrayList<Boolean> status = new ArrayList<>();
        ListNode p1 = pHead;

        while (p1!=null){
            ListNode p2 = pHead;
            while (p2!=null){
                if(p1.val == p2.val && p1 != p2){
                    status.add(true);
                    break;
                }
                p2=p2.next;
                if(p2==null){
                    status.add(false);
                }
            }
            p1 = p1.next;
        }
        for(int i = 0; i < status.size(); i++){
            if (status.get(i)) {
                pHead = pHead.next;
            }else {
                p1 = pHead;
                for(int j = i+1; j < status.size(); j++){
                    if(status.get(j)){
                        p1.next = p1.next.next;
                    }else {
                        p1 = p1.next;
                    }
                }
                break;
            }
        }
        return pHead;
    }


    /**57
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不
     * 仅包含左右子结点，同时包含指向父结点的指针。
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null)
            return null;
        TreeLinkNode ret = null;
        if(pNode.right != null){
            ret = getRight(pNode.right);
        }else {
            ret = getUp(pNode);
        }
        return ret;

    }
    public TreeLinkNode getRight(TreeLinkNode pNode){
        if(pNode.left == null)
            return pNode;
        return getRight(pNode.left);
    }
    public TreeLinkNode getUp(TreeLinkNode pNode){
        if(pNode.next == null)
            return null;
        if(pNode.next.left == pNode)
            return pNode.next;
        return getUp(pNode.next);
    }


    /**58
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的
     * 镜像是同样的，定义其为对称的。
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot){

        if(pRoot == null)
            return true;
        return isEqual(pRoot.left, pRoot.right);

    }
    public boolean isEqual(TreeNode left, TreeNode right){
        if(left == null && right == null)
            return true;
        if(left == null ^ right == null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return isEqual(left.left,right.right) && isEqual(left.right, right.left);

    }


    /**59
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推。
     * @param pRoot
     * @return
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        if(pRoot == null)
            return ret;

        ArrayList<TreeNode> parents = new ArrayList<>();
        parents.add(pRoot);
        addPiles(parents, 0);

        return ret;
    }

    public void addPiles(ArrayList<TreeNode> parents, int depth){
        int n = parents.size();
        if(n == 0)
            return;
        ArrayList<TreeNode> past = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(parents.get(i).val);
        }
        ret.add(res);
        if(depth % 2 == 0){
            for (int i = n-1; i > -1; i--){
                if(parents.get(i).right != null){
                    past.add(parents.get(i).right);
                }
                if(parents.get(i).left != null){
                    past.add(parents.get(i).left);
                }
            }
        }else {
            for (int i = n-1; i > -1; i--){
                if(parents.get(i).left != null){
                    past.add(parents.get(i).left);
                }
                if(parents.get(i).right != null){
                    past.add(parents.get(i).right);
                }
            }
        }
        addPiles(past,depth+1);

    }


    /**60
     *从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Printer(TreeNode pRoot){
        if(pRoot == null)
            return ret;
        ArrayList<TreeNode> parents = new ArrayList<>();
        parents.add(pRoot);
        addPiles(parents);
        return ret;
    }

    public void addPiles(ArrayList<TreeNode> parents){
        int n = parents.size();
        if(n == 0)
            return;
        ArrayList<TreeNode> past = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            res.add(parents.get(i).val);
        }
        ret.add(res);
        for (int i = 0; i < n; i++){
            if(parents.get(i).left != null){
                past.add(parents.get(i).left);
            }
            if(parents.get(i).right != null){
                past.add(parents.get(i).right);
            }
        }
        addPiles(past);

    }


    /**61
     *请实现两个函数，分别用来序列化和反序列化二叉树
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> node = new LinkedList<>();
        TreeNode temp = null;
        node.add(root);
        while (!node.isEmpty()){
            temp = node.poll();
            if(temp!=null){
                str.append(temp.val+",");
                node.add(temp.left);
                node.add(temp.right);
            }else {
                str.append("#,");
            }
        }
        if(str.length()!=0)
            str.deleteCharAt(str.length()-1);
        return str.toString();

    }
    public TreeNode Deserialize(String str) {
        if(str=="")
            return null;
        String[] node = str.split(",");
        TreeNode[] ret = new TreeNode[node.length];
        for(int i = 0; i< node.length; i++){
            if(!node[i].equals("#")){
                ret[i] = new TreeNode(Integer.parseInt(node[i]));
            }
        }
        for(int i = 0, j = 1; j < ret.length; i++){
            if(ret[i] != null){
                ret[i].left = ret[j++];
                ret[i].right = ret[j++];
            }
        }
        return ret[0];
    }


    /**62
     * 给定一棵二叉搜索树，请找出其中的第k小的结点
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k == 0)
            return null;
        int order = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        while (!stack.empty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                order++;
                TreeNode res = stack.pop();
                if(order == k)
                    return res;
                node = res.right;
            }
        }
        return null;
    }


    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后
     * 位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均
     * 值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
     * @param num
     */

    private int length = 0;
    private ArrayList<Integer> list = new ArrayList<>();
    public void Insert(Integer num) {

        if(length == 0){
            list.add(num);
        }else {
            int left = 0;
            int right = length;
            int mid = 0;
            while (left < right){
                mid = left + ((right - left)>>1);
                if(num < list.get(mid)){
                    right = mid - 1;

                }else {
                    left = mid + 1;
                }
            }
            if(num < list.get(mid)){
                list.add(mid, num);
            }else {
                list.add(mid+1,num);
            }

        }
        length++;
    }

    public Double GetMedian() {

        if(length%2==0){
            return (list.get(length/2-1) + list.get(length/2))/2.0;
        }
        return (double)list.get(length/2);

    }

    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组
     * {2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为
     * {4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
     * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
     * {2,3,4,2,6,[2,5,1]}。
     * @param num
     * @param size
     * @return
     */
    /*public ArrayList<Integer> maxInWindows(int [] num, int size){

        int length = num.length;
        if(length == 0 || size > length)
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < length - size; i++){
            for(int j = i; j < i + size; j++){

            }
        }
    }*/


    /**65
     *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子
     * 开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路
     * 径不能再进入该格子。 例如
     *    矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
     *    因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    /*public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(){

                }
            }
        }
        return false;

    }*/


    /**66
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为
     * 3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */

    public int movingCount(int threshold, int rows, int cols)
    {

        boolean[][] flag = new boolean[rows][cols];
        int res = 0;
        if(threshold>=0)
            flag[0][0]=true;
        for(int i = 0; i < rows; i++){
            int sumI = 0;
            int ii = i;
            while (ii>=10){
                sumI += ii%10;
                ii /= 10;
            }
            sumI += ii;
            for(int j = 0; j < cols; j++){

                int sum = 0;
                int jj = j;
                while (jj >= 10){
                    sum += jj%10;
                    jj /= 10;
                }
                sum += jj;
                sum += sumI;
                if(i!=0 || j!=0){
                    if(sum<=threshold){
                        flag[i][j] = (i==0 ? false:flag[i-1][j]) || (j==0 ? false:flag[i][j-1]);
                    }
                }
                if(flag[i][j])
                    res++;

            }

        }
        return res;

    }


    /**
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为
     * k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别
     * 为2、3、3的三段，此时得到的最大乘积是18。
     * @param target
     * @return
     */
    public int cutRope(int target) {

        int ph[] = new int[target+1];
        ph[1] = 1;
        for(int i = 2; i < target+1; i++){
            ph[i] = i;
            for(int j = 1; j < i; j++){
                ph[i] = Math.max(ph[i],ph[j]*ph[i-j]);
            }
        }
        return ph[target];

    }
    public int minNumberInRotateArray(int [] array) {
        int res = Integer.MAX_VALUE;
        if(array.length==0)
            return 0;
        for(int i = 0; i < array.length; i++){
            res = Math.min(res,array[i]);
        }
        return res;

    }

    @Deprecated
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        int length = pushA.length;
        int j = 0;
        for(int i = length-1; i >= 0; i--){
            if(pushA[i] == popA[j] && i+j==length-1){
                j++;
            }else {
                int temp = j;
                do{
                    j++;
                    if(j==length)
                        return false;
                }while (pushA[i] != popA[j]);
                int temp2 = j;
                for(j--;j>=temp;j--){
                    i--;
                    if(pushA[i]!=popA[j])
                        return false;
                }
                j = temp2+1;
            }
        }
        return true;
    }

    public boolean isPopPush(int [] pushA,int [] popA){
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for(int i = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && popA[idx] == stack.peek()){
                stack.pop();
                idx ++;
            }
        }
        return stack.isEmpty();
    }

}
