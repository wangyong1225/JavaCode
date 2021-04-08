package com.wy.office;

import com.wy.lick.domain.ListNode;

public class Practice {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        int i=0,j=0;
        for(; i < numbers.length-1; i++){
            for(j = i+1; j < numbers.length; j++){
                if(numbers[i]+numbers[j]==target){
                    res[0] = i+1;
                    res[1] = j+1;
                    return res;
                }
            }
        }
        return res;
    }

    int poow(int a , int b)
    {
        int ans = 1 ;
        int base = a ;
        while(b != 0)
        {
            if((b & 1) != 0)
                ans = (ans * base)%107;
            base *= base ;
            b >>= 1 ;
        }
        return ans;
    }

    public int min(int[] a){
        int res = Integer.MAX_VALUE;
        int order = 0;
        for(int i = 0; i < a.length; i++){
            if(res > a[i]){
                order = i;
            }
        }
        a[order] = Integer.MAX_VALUE;
        return res;
    }

    /*public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(k<=1)
            return head;
        int length = 0;
        ListNode root = head;
        while (root!=null){
            length++;
            root = root.next;
        }
        root = head;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = head;
        p2.next = null;
        int time = length / k;
        for(int i = 0; i < time; i++){
            for (int j = 0; j < k; j++){

            }
        }


    }*/




}
