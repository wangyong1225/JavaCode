package com.wy;

import com.wy.office.Solution40_60;
import com.wy.treenode.TreeNode;
import com.wy.treenode.TreeNodeTolls;
import org.junit.Test;

import java.util.LinkedList;

public class Test01 {
    /**
     * 验证pop与peek
     */
    @Test
    public void Test01(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        System.out.println(linkedList.peek()+"元素个数为："+linkedList.size());
        System.out.println(linkedList.pop()+"元素个数为："+linkedList.size());


    }
    /**
     * 测试traversingBinaryTree(TreeNode treeNode)
     */
    @Test
    public void Test02(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        LinkedList<TreeNode> list = TreeNodeTolls.traversingBinaryTree(root);
        if (list != null){
            for (TreeNode tree : list){
                System.out.println(tree.val);
            }
        }else {
            System.out.println(list);
        }

    }

    @Test
    public void Test03(){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(4);
        root2.left.left.left = new TreeNode(4);

        boolean res = TreeNodeTolls.hasSubtree(root1,root2);
        System.out.println(res);
    }

    @Test
    public void Test04(){
        String str = "123";
        char[] chars = str.toCharArray();
        System.out.println(chars[0] < chars[1]);
    }

    /**
     * 验证public, private, no modifier, protected的区别
     */
    @Test
    public void Test05(){
        Solution40_60 solution40_60 = new Solution40_60();
        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        System.out.println(solution40_60.VerifySquenceOfBST(arr));



    }


}
