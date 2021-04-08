package com.wy.treenode;


import java.util.ArrayList;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public void preOrder(){
        if(left != null){
            left.preOrder();
        }
        System.out.println(val);
        if(right != null){
            right.preOrder();
        }
    }

    public static TreeNode creat(int[] arr){
        if(arr == null || arr.length == 0)
            return null;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (int val : arr){
            nodes.add(new TreeNode(val));
        }
        for(int i = 0, j = 1; j < arr.length; i++){
            nodes.get(i).left = nodes.get(j++);
            nodes.get(i).right = nodes.get(j++);
        }
        return nodes.get(0);
    }

    public void add(int val) {

        // 判断传入的结点的值，和当前子树的根结点的值的关系
        TreeNode node = new TreeNode(val);
        if (val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(val);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(val);
            }
        }

    }
}
