package com.wy;

import com.wy.treenode.Solution;
import com.wy.treenode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

public class TestTreeNode {
    @Test
    public void TestConvert(){
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);

        TreeNode list = solution.Convert(treeNode);
        System.out.println(list);
    }

    @Test
    public void TestFind(){
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(solution.find(root,0));
    }
}
