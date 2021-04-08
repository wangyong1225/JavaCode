package com.wy.dataStructure.sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {

       int[] arr = {4, 6, 8, 5, 9, 34, -34, 432, 42, 0};
       Sort sort = new Sort();
       sort.adjustHeap(arr,1,5);

       sort.heapSort(arr);
       System.out.println(Arrays.toString(arr));


    }

    /**
     * 堆排序
     */
    public void heapSort(int arr[]){
        System.out.println("堆排序");
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i, arr.length);
        }

        for(int j = arr.length - 1; j > 0; j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }

    /**
     * 将一个数组，调整为一个大顶堆
     *
     * @param arr  待调整的数组
     * @param i    表示非叶子结点在数组中的索引
     * @param length 表示对多少个元素进行调整
     */
    public void adjustHeap(int arr[], int i, int length){

        int temp = arr[i]; // 先取出当前元素的值
        // 开始调整
        //  k = i * 2 + 1, k 是i结点的左子节点
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1){
            if(k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        // 当for循环结束后，我们已经将以i为父节点的数的最大值，放在了最顶上
        arr[i] = temp;

    }


    /**
     * 桶排序
     * @param arr
     */
    public void radixSort(int[] arr){
        // 存放数据的桶
        int[][] bucket = new int[10][arr.length];
        // 桶中元素的个数
        int[] num = new int[10];
        // 每次选择的数的数位上的数字，初始化为0
        int val = 0;


        // 写循环体，循环的次数为数组中最大数字的位数首先找到最大数字
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        int step = 1;  // 循环次数，初始为0，
        while (max/10!=0){
            step++;
            max/=10;
        }
        for(int i = 0, ii = 1; i<=step; i++, ii*=10){
            for(int j = 0; j < arr.length; j++){
                // 将arr中元素按照对应位置的数放入桶中
                val = (arr[j]/ii) % 10;
                bucket[val][num[val]] = arr[j];
                num[val]++;
            }
            // 将桶中的元素返回到arr中
            for(int m = 0,j=0; m < 10; m++){
                for(int k = 0; k < num[m]; k++){
                    arr[j++] = bucket[m][k];
                }
            }
            num = new int[10];
        }


    }



    /**
     * 冒泡排序
     * @param arr 输入矩阵
     */
    public void bubble(int[] arr){
        boolean flag = false;
        int length = arr.length;
        for(int i=0; i < length-1;i++){
            for(int j = 0; j < length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(flag){
                flag = false;

            }else {
                break;
            }
        }
    }

    /**
     * 选择排序
     * @param arr 输入矩阵
     */
    public void select(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            min = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = min;
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public void insert(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int insertVal = arr[i];
            int insertInd = i - 1;
            while (insertInd >= 0 && insertVal < arr[insertInd]){
                arr[insertInd+1] = arr[insertInd];
                insertInd--;
            }
            arr[insertInd+1] = insertVal;
        }
    }

    /**
     * 希尔排序：交换法
     * @param arr
     */
    public void shell(int[] arr){
        int temp = 0;
        for(int lam = arr.length/2; lam > 0; lam/=2){
            for(int i = lam; i < arr.length; i++){
                for(int j = i - lam; j >=0; j -= lam){
                    if(arr[j] > arr[j+lam]){
                        temp = arr[j];
                        arr[j] = arr[j+lam];
                        arr[j+lam] = temp;
                    }
                }
            }
        }
    }

    /**
     * 希尔排序移动法
     * @param arr
     */
    public void shell2(int[] arr){
        int temp = 0;
        for(int lam = arr.length/2; lam > 0; lam/=2){
            // 从lam个元素，逐个对其所在的组进行直接插入排序
            for(int i = lam; i < arr.length; i++){
                int j = i-lam;
                temp = arr[i];
                while (j  >=0 && temp < arr[j]){
                    // 移动
                    arr[j+lam] = arr[j];
                    j -= lam;
                }
                arr[j+lam] = temp;
            }
        }
    }

    /**
     * 希尔排序优化
     * @param arr
     */
    public void shell3(int[] arr){
        int temp = 0;
        for(int lam = arr.length/2; lam > 0; lam/=2){
            // 从lam个元素，逐个对其所在的组进行直接插入排序
            for(int i = lam; i < arr.length; i++){
                int j = i;
                temp = arr[i];
                while (j-lam >=0 && temp < arr[j-lam]){
                    // 移动
                    arr[j] = arr[j-lam];
                    j -= lam;
                }
                arr[j] = temp;
            }
        }
    }


    public void quick(int[] arr, int left, int right){
        //
        int l = left; // 左下标
        int r = right; // 右下标
        int pivot = arr[left+((right-left)>>1)];
        int temp = 0;
        while (l < r){
            while (arr[l] < pivot){
                // 在pivot左边一直找，找到大于pivot才退出
                l++;
            }
            while (arr[r] > pivot){
                r--;
            }
            if (l>=r){
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 交换完后，发现arr[l] == pivot值
            if(arr[l] == pivot){
                r -= 1;
            }
            // 交换完后，发现arr[r] == pivot值
            if(arr[r] == pivot){
                l += 1;
            }

        }
        // 如果l == r， 必须l++，r--，否则会出现栈溢出
        if(l == r){
            l ++;
            r --;
        }
        // 向左递归
        if(left < r){
            quick(arr,left,r);
        }
        // 向右递归
        if(right>l){
            quick(arr,l,right);
        }
    }




    public void mergeSort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = left+((right-left)>>1);
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            marget(arr, left, mid, right, temp);
        }

    }


    /**
     *
     * @param arr  要排序的数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引(左边有序序列的右边索引)
     * @param right 右边索引
     * @param temp 中间数组
     */
    public static void marget(int[] arr, int left, int mid, int right, int[] temp){
        // 初始化
        int i = left;
        int j = mid+1;
        int t = 0; // 指向temp数组的当前索引
        // 先把左右两边数据按照规则填充到temp，直到有一个有序序列填充完毕
        while (i <= mid && j <=right){
            if(arr[i] <= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        while (i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = arr[j];
            t++;
            j++;
        }
        // 将temp数组的元素拷贝到arr
        t=0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }

    /**
     *
     * @param arr  要排序的数组
     * @param left 左边有序序列的初始索引
     * @param mid  中间索引(左边有序序列的右边索引)
     * @param right 右边索引
     * @param temp 中间数组
     */
    public void margetDebug(int[] arr, int left, int mid, int right, int[] temp){
        // 初始化
        int i = left;
        int length = mid-left;
        int j = right;
        int t = 0; // 指向temp数组的当前索引

        // 先把左右两边数据按照规则填充到temp，直到有一个有序序列填充完毕

        // 把剩余的有序序列直接填充到temp中
        for(; t < temp.length; t++){
            if(i==mid+1){
                temp[t]=arr[j];
                j++;
            }else if(j - right > length){
                temp[t]=arr[i];
                i++;
            } else {
                if(arr[i]<arr[j]){
                    temp[t] = arr[i];
                    i++;
                }else {
                    temp[t] = arr[j];
                    j++;
                }
            }
        }
        arr = temp.clone();

    }




}
