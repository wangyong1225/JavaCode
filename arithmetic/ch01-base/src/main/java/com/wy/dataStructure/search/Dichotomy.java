package com.wy.dataStructure.search;

import java.util.ArrayList;

public class Dichotomy {
    public static void main(String[] args) {
        int[] arr = {1,1,1,4,5,6};
        System.out.println(dichotomy2(arr,0,arr.length-1,1));

    }

    public static int dichotomy(int[] arr, int l, int r, int val){
        if(l>r){
            return -1;
        }
        int mid = l+((r-l)>>1);
        if(arr[mid] == val){
            return mid;
        }
        return arr[mid]>val ? dichotomy(arr, l, mid-1, val) : dichotomy(arr, mid+1, r, val);
    }

    public static ArrayList<Integer> dichotomy2(int[] arr, int l, int r, int val){
        if(l>r){
            return null;
        }
        int mid = l+((r-l)>>1);
        if(arr[mid] == val){
            ArrayList<Integer> res = new ArrayList<>();
            int temp = mid-1;
            while (true){
                if (temp<0 || arr[temp] != val){
                    break;
                }
                res.add(temp);
                temp--;
            }
            res.add(mid);
            temp = mid+1;
            while (temp<arr.length && arr[temp]==val){
                res.add(temp);
                temp++;
            }
            return res;
        }
        return arr[mid]>val ? dichotomy2(arr, l, mid-1, val) : dichotomy2(arr, mid+1, r, val);
    }
}
