package com.wy.dataStructure.stack;

import java.util.Scanner;

public class ListStackDemo {
    public static void main(String[] args) {
        ListStack stack = new ListStack(4);
        String key = "";
        boolean loop = true;
        Scanner sn = new Scanner(System.in);

        while (loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            key = sn.next();
            switch (key) {
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = sn.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try{
                        int res = stack.pop();
                        System.out.println("出栈的数据为："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    sn.close();
                    loop = false;
                    break;
                default:
                    System.out.println("请输入合法的命令");
                    break;
            }

        }
        System.out.println("程序结束！");
    }
}

class ListStack{
    private List list = new List(-1);
    private int maxSize;
    private int top = -1;
    public ListStack(int maxSize){
        this.maxSize = maxSize;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==maxSize-1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        list.next = new List(value);
        list.next.pre = list;
        list = list.next;
    }
    // 出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = list.value;
        top--;
        list=list.pre;
        list.next=null;
        return value;
    }

    // 遍历栈
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        List cur = list;
        for (int i = top; i >=0; i--){
            System.out.println("第"+i+"数据为："+cur.value);
            cur=cur.pre;
        }
    }



}

class List{
    int value;
    List next;
    List pre;
    public List(int val){
        value = val;
    }
}