package com.wy.treenode;

import java.util.ArrayList;

public class Solution {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        Convert(pRootOfTree,list);
        Convert(list);
        return  list.get(0);

    }

    public void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list){
        if(pRootOfTree == null){
            return;
        }
        if(pRootOfTree.left != null){
            Convert(pRootOfTree.left, list);
        }
        list.add(pRootOfTree);
        if(pRootOfTree.right!=null){
            Convert(pRootOfTree.right,list);
        }
    }

    public void Convert(ArrayList<TreeNode> list){
        if (list.size()<=1 || list==null){
            return;
        }
        for(int i = 0; i<list.size()-1; i++){
            list.get(i).right=list.get(i+1);
            list.get(i+1).left=list.get(i);
        }
        list.get(0).left=null;
        list.get(list.size()-1).right=null;
    }


    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）
     * 形成树的一条路径，最长路径的长度为树的深度。
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {
        if(root == null)
            return 0;
        return find(root,0);

    }

    public int find(TreeNode root, int num){
        num++;
        int p1 = 0;
        int p2 = 0;
        if(root.right == null && root.left == null)
            return num;
        if(root.left != null) {
            p1 = find(root.left, num);
        }
        if(root.right != null) {
            p2 = find(root.right, num);
        }
        return Math.max(p1,p2);
    }

    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右
     * 两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return getDeep(root) == -1 ? false : true;
    }

    public int getDeep(TreeNode root){
        if (root == null)return 0;
        int r = getDeep(root.right);
        if (r == -1) return -1;
        int l = getDeep(root.left);
        if (l == -1) return -1;
        return Math.abs(r-l) > 1 ? -1 : Math.max(r,l)+1;
    }


}
