package com.wy.dataStructure.stack;

public class Calculator {
    public static void main(String[] args) {

        Calculator solve = new Calculator();
        String expression = "30+2*6-21";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        // 定义需要的变量
        int index = 0;
        int num1 = 0, num2 = 0;
        int res = 0;
        char ch = ' ';
        StringBuilder keepNum = new StringBuilder();
        while (true){
            ch = expression.substring(index, index+1).charAt(0);
            if(operStack.isOper(ch)){
                if (operStack.isEmpty()){
                    operStack.push(ch);
                }else {
                    if(operStack.priority(ch)<=operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        res = operStack.cal(num1, num2, operStack.pop());
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }
                }
            }else {
                keepNum = keepNum.append(ch);
                if(index+1>=expression.length() || operStack.isOper(expression.charAt(index+1))){
                    numStack.push(Integer.valueOf(keepNum.toString()));
                    keepNum = new StringBuilder();
                }
            }
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        while (!operStack.isEmpty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            res=operStack.cal(num1, num2, operStack.pop());
            numStack.push(res);
        }
        System.out.println(expression+"="+res);
    }


}
