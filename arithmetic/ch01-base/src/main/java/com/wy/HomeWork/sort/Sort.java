package com.wy.HomeWork.sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 334, 32, -4};
        Sort sort = new Sort();
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 堆排序
     */
    public void heapSort(int[] arr){
        int temp = 0;
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }
        for(int i = arr.length - 1; i > 0; i--){
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i);
        }


    }
    public void adjustHeap(int[] arr, int i, int length){
        // i的左子结点为i * 2 + 1
        int temp = arr[i];
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if(k + 1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if(temp < arr[k]){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }

}
