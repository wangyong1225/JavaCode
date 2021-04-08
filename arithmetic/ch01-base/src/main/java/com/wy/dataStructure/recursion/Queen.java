package com.wy.dataStructure.recursion;


public class Queen {
    public static void main(String[] args) {
        Queen main = new Queen();
        main.check(0);
        System.out.println(main.count);
    }
    int max = 8;
    int[] arr = new int[max];
    int count = 0;
    public void check(int n){
        if(n==max){
            print();
            return;
        }
        for(int i = 0; i < max; i++){
            arr[n] = i;
            if(judge(n,i)){
                check(n+1);
            }
        }
    }
    public boolean judge(int n, int val){
        for(int i=0; i < n; i++){
            if(arr[i]==val){
                return false;
            }
            if(Math.abs(arr[i]-val)== Math.abs(i-n)){
                return false;
            }
        }
        return true;
    }
    public void print(){
        count++;
        System.out.print("八皇后放在的位置为：");
        for(int i = 0; i < max; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
