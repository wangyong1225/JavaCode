package com.wy.dataStructure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 测试环形队列
        CircleArrayQueue arrayQuery = new CircleArrayQueue(4);//说明设置4，最大空间为3
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


class CircleArrayQueue{
    private int maxSize; // 数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据，模拟队列

    public CircleArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear+1) % maxSize == front;
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
        arr[rear] = n;
        // 将rear后移，这里必须考虑取模
        rear = (rear +1) % maxSize; // 让rear后移
    }

    // 获取队列的数据，出队列
    public int getQueue(){
        // 判断队列是否空
        if(isEmpty()){
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里需要分析front是指向队列的第一个元素
        // 1. 先把front对应的值保留到一个临时变量
        // 2. 将front后移，考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if(isEmpty()){
            System.out.println("队列为空，没有数据~~");
            return;
        }
        // 从front开始遍历
        for(int i = front; i < front+size(); i++){
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示队列的头数据，注意不是取出数据
    public int headQueue(){
        // 判断
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }

}