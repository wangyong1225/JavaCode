package com.wy.treenode;


import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNodeTolls {
    /**
     * 返回一个树的遍历放到一个链表当中
     * @param root
     * @return
     */
    public static LinkedList<TreeNode> traversingBinaryTree(TreeNode root){
        if (root == null){
            return null;
        }
        LinkedList<TreeNode> link1 = new LinkedList<>();
        LinkedList<TreeNode> link2 = new LinkedList<>();
        link1.add(root);
        while (link1.size() != 0){
            link2.add(link1.peek());
            root=link1.pop();
            if(root.left != null){
                link1.add(root.left);
            }
            if(root.right != null){
                link1.add(root.right);
            }
        }
        return link2;
    }

    public static boolean hasSubtree(TreeNode root1,TreeNode root2){
        if(root1 == null || root2 == null){
            return false;
        }
        boolean res = false;
        LinkedList<TreeNode> link1 = new LinkedList<>();
        link1.add(root1);
        TreeNode root = root1;
        while (link1.size() != 0){
            root=link1.pop();
            if(root.val == root2.val){
                if(isInTree(root, root2)){
                    return true;
                }
            }
            if(root.left != null){
                link1.add(root.left);
            }
            if(root.right != null){
                link1.add(root.right);
            }
        }
        return res;
    }
    public static boolean isInTree(TreeNode root1,TreeNode root2){
        if(root1.val != root2.val){
            return false;
        }
        if(root2.left == null && root2.right == null){
            return true;
        }
        boolean res1 = false;
        boolean res2 = false;
        if(root1.left == null){
            res1 = true;
        }
        if(root2.right == null){
            res2 = true;
        }
        if(root2.left != null){
            if(root1.left!=null){
                res1 = isInTree(root1.left,root2.left);
            }else {
                res1 = false;
            }
        }
        if(root2.right != null){
            if(root1.right!=null){
                res2 = isInTree(root1.right,root2.right);
            }else {
                res2 = false;
            }

        }
        return res1&&res2;

    }


    /**
     * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     */
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        dfs(root, target, new ArrayList<>());
        return ret;
    }

    public void dfs(TreeNode root, int target, ArrayList<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            ret.add(new ArrayList<>(list));
        else {
            dfs(root.left, target, list);
            dfs(root.right, target, list);
        }
        list.remove(list.size() - 1);
    }
}
