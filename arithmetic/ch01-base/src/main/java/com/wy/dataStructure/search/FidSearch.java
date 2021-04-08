package com.wy.dataStructure.search;

import java.util.ArrayList;
import java.util.Arrays;

public class FidSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(fidSearch(arr,1));


    }
    static int MAX = 20;
    public static int[] fib(){
        int[] f = new int[MAX];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < MAX; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
    public static int fidSearch(int[] arr, int val){
        int l = 0;
        int k = 0;
        int[] f = fib();
        while (f[k]<arr.length){
            k++;
        }
        int[] temp = Arrays.copyOf(arr,f[k]);
        for(int i = arr.length; i < temp.length; i++){
            temp[i] = arr[arr.length-1];
        }
        int r = temp.length;
        while (l<=r){
            int mid = l + f[k-1]-1;
            if(temp[mid]>val){
                r=mid-1;
                k--;
            }else if(temp[mid]<val){
                l=mid+1;
                k-=2;
            }else {
                if(mid>=arr.length){
                    return arr.length-1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }


}
