package com.wy.dataStructure.queue;

import java.util.Scanner;

public class ArrayQueueDemo{
    // 测试
    // 创建一个队列
    public static void main(String[] args) {
        ArrayQuery arrayQuery = new ArrayQuery(3);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输入一个菜单
        while(loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    arrayQuery.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入加入队列的数据");
                    int num = scanner.nextInt();
                    arrayQuery.addQueue(num);
                    break;
                case 'g':
                    try{
                        int res = arrayQuery.getQueue();
                        System.out.println("取出的数据是："+res);
                    }catch (Exception e){
                        //
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = arrayQuery.headQueue();
                        System.out.println("队列头的数据是："+res);
                    }catch (Exception e){
                        //
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");


    }



}

// 使用数组模拟队列-编写一个类ArrayQuery
class ArrayQuery {
    private int maxSize; // 数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据，模拟队列

    // 创建队列的构造器
    public ArrayQuery(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;  //指向队列尾，指向队列尾的数据（即队列最后一个数）
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据队列
    public void addQueue(int n){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列满，不能加入数据");
            return;
        }
        rear++; // 让rear后移
        arr[rear] = n;
    }

    // 获取队列的数据，出队列
    public int getQueue(){
        // 判断队列是否空
        if(isEmpty()){
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }
    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if(isEmpty()){
            System.out.println("队列为空，没有数据~~");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据，注意不是取出数据
    public int headQueue(){
        // 判断
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front+1];
    }




}