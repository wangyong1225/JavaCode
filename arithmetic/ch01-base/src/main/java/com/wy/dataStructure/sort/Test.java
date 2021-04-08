package com.wy.dataStructure.sort;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Sort main = new Sort();

        int[] arr = new int[80000];
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*1000000);
        }

        Date date;
        long time1, time2;


        /*date = new Date();
        time1 = date.getTime();
        main.bubble(arr.clone());
        date = new Date();
        time2 = date.getTime();
        System.out.print("冒泡排序的运算时间：");
        System.out.println(time2-time1);*/

        /*date = new Date();
        time1 = date.getTime();
        main.select(arr.clone());
        date = new Date();
        time2 = date.getTime();
        System.out.print("选择排序的运算时间：");
        System.out.println(time2-time1);*/

        /*date = new Date();
        time1 = date.getTime();
        main.insert(arr.clone());
        date = new Date();
        time2 = date.getTime();
        System.out.print("插入排序的运算时间：");
        System.out.println(time2-time1);*/

        /*date = new Date();
        time1 = date.getTime();
        Arrays.sort(arr.clone());
        date = new Date();
        time2 = date.getTime();
        System.out.print("内置函数的运算时间：");
        System.out.println(time2-time1);*/

       /* date = new Date();
        time1 = date.getTime();
        main.shell3(arr.clone());

        date = new Date();
        time2 = date.getTime();
        System.out.print("希尔排序交换法的运算时间：");
        System.out.println(time2-time1);*/


        /*date = new Date();
        time1 = date.getTime();
        main.quick(arr.clone(),0,arr.length-1);

        date = new Date();
        time2 = date.getTime();
        System.out.print("快速排序排序交换法的运算时间：");
        System.out.println(time2-time1);*/

        /*date = new Date();
        time1 = date.getTime();
        main.mergeSort(arr.clone(),0,arr.length-1,temp);

        date = new Date();
        time2 = date.getTime();
        System.out.print("归并排序排序交换法的运算时间：");
        System.out.println(time2-time1);*/

        /*date = new Date();
        time1 = date.getTime();
        main.radixSort(arr);

        date = new Date();
        time2 = date.getTime();
        System.out.print("基数排序的运算时间：");
        System.out.println(time2-time1);*/

        date = new Date();
        time1 = date.getTime();
        main.heapSort(arr);

        date = new Date();
        time2 = date.getTime();
        System.out.print("堆排序的运算时间：");
        System.out.println(time2-time1);


    }




}
