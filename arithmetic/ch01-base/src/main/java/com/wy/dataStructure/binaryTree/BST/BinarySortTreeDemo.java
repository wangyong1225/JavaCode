package com.wy.dataStructure.binaryTree.BST;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i:arr){
            binarySortTree.add(new Node(i));
        }
        System.out.println("原二叉树");
        binarySortTree.infixSort();
        binarySortTree.delete(7);
        System.out.println("删除后");
        binarySortTree.infixSort();
    }
}

class BinarySortTree{
    private Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    public void infixSort(){
        if(root == null){
            return;
        }
        root.infixList();
    }

    public Node getRoot() {
        return root;
    }

    public void delete(int val){
        if(root.val == val){
            delete();
        }else {
            root.delete(val);
        }
    }
    private void delete(){
        if(root.left == null && root.right == null){
            root = null;
        }else {
            if(root.right != null && root.left != null){
                root.val = root.delRightTreeMin(root.right);
            }else {
                if(root.left == null){
                    root = root.right;
                }else {
                    root = root.left;
                }
            }

        }

    }
}


class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }

    /**
     * 添加结点
     * 递归的形式添加结点，满足二叉排序树的要求
     */
    public void add(Node node){
        if(node == null){
            return;
        }
        // 判断传入的结点的值，和当前子树的根结点的值的关系
        if(node.val < this.val){
            if(this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    // 中序遍历
    public void infixList(){
        if(this.left !=null)
            this.left.infixList();
        System.out.println(this.val);
        if(this.right != null)
            this.right.infixList();
    }

    // 删除节点
    /**
     * findDelete:找到要要删除的结点，将该结点存放到targetNode中，他的父节点存放在parent中
     */
    public static Node parent;
    public static Node targetNode;
    public void findDelete(int val){
        if(val < this.val){
            if(this.left != null){
                if(val == this.left.val){
                    parent = this;
                    targetNode = this.left;
                    return;
                }else {
                    this.left.findDelete(val);
                }
            }
        }else {
            if(this.right != null){
                if(val == this.right.val){
                    parent = this;
                    targetNode = this.right;
                    return;
                }else {
                    this.right.findDelete(val);
                }
            }
        }
    }

    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left != null){
            target = target.left;
        }
        delete(target.val);
        return target.val;
    }

    public void delete(int val){
        findDelete(val);
        if(targetNode.left == null && targetNode.right == null){
            if(parent.left == targetNode){
                parent.left = null;
            }else {
                parent.right = null;
            }
            return;
        }
        if(targetNode.left != null && targetNode.right != null){
            targetNode.val = delRightTreeMin(targetNode.right);
        }
        if(targetNode.left != null){
            if(parent.left == targetNode){
                parent.left = targetNode.left;
            }else {
                parent.right = targetNode.left;
            }
        }else {
            if(parent.left == targetNode){
                parent.left = targetNode.right;
            }else {
                parent.right = targetNode.right;
            }
        }
    }





    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

}