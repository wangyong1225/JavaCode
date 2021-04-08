package com.wy.dataStructure.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
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

