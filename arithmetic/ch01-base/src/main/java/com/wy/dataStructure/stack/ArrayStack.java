package com.wy.dataStructure.stack;

// 定义一个ArrayStack来模拟栈
public class ArrayStack{
    private int maxSize; // 栈的大小
    private int[] stack; // 数组，数组模拟栈，数据就放在该数组
    private int top = -1;
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    // 栈空
    public boolean isEmpty(){
        return top == -1;
    }

    // 入栈
    public void push(int value){
        // 先判断栈是否满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 显示栈顶
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        return stack[top];
    }

    // 遍历栈
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        for(int i = top; i >=0; i--){
            System.out.println("stack["+i+"]="+stack[i]);
        }
    }

    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }
    // 判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    // 计算方法
    public int cal(int num1, int num2, int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
