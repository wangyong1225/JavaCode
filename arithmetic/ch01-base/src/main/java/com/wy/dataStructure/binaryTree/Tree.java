package com.wy.dataStructure.binaryTree;

public class Tree {

    public static void main(String[] args) {
        Tree root = new Tree(1);
        Tree node2 = new Tree(2);
        Tree node3 = new Tree(3);
        Tree node4 = new Tree(4);
        root.left=node2;
        root.right=node3;
        node3.right=node4;
        System.out.println(root.preSearch(2));
        root.deleteById(5);
        root.preOrder();
        /*System.out.println("前序");
        root.preOrder();
        System.out.println("中序");
        root.infixOrder();
        System.out.println("后序");
        root.postOrder();*/
    }

    int val;
    Tree left;
    Tree right;
    public Tree(int val){
        this.val = val;
    }

    /**
     * 删除
     * 1）如果是叶子节点，就删除叶子节点
     * 2）如果不是，就删除子树
     * @param id
     */
    public void deleteById(int id){

        if(this.left != null && this.left.val == id){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.val == id){
            this.right = null;
            return;
        }
        if(this.left != null){
            this.left.deleteById(id);
        }
        if(this.right != null){
            this.right.deleteById(id);
        }

    }

    // 前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "val=" + val +
                '}';
    }

    // 后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序查找
    static int count = 0;
    public Tree preSearch(int val){
        count++;
        Tree res = null;
        if(this.val == val){
            System.out.println(count);
            return this;
        }
        if(this.left != null){
            res = this.left.preSearch(val);
            if(res!=null){
                return res;
            }
        }
        if(this.right != null){
            res = this.right.preSearch(val);
            if(res != null){
                return res;
            }
        }
        return res;
    }

    // 中序查找
    public boolean infixSearch(int val){
        if(this.left!=null){
            if(this.left.infixSearch(val)){
                return true;
            }
        }
        if(this.val == val){
            return true;
        }
        if(this.right != null){
            if(this.right.infixSearch(val)){
                return true;
            }
        }
        return false;
    }

}
