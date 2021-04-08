package com.wy.dataStructure.search;

public class Interpolation {
    public static void main(String[] args) {
        int[] arr = {1,1,1,4,5,6};
        System.out.println(interpolation(arr,0,arr.length-1,1));
    }


    public static int interpolation(int[] arr, int l, int r, int val){
        if(l>r || val < arr[l] || val>arr[r]){
            return -1;
        }
        int mid = l+(r-l)*((val-arr[l])/(arr[r]-arr[l]));
        if(arr[mid] == val){
            return mid;
        }
        return arr[mid]>val ? interpolation(arr, l, mid-1, val) : interpolation(arr, mid+1, r, val);
    }
}
