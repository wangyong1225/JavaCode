package com.wy;

import com.wy.exam.Main;
import com.wy.lick.Solution;
import com.wy.lick.domain.RandomListNode;
import com.wy.lintcode.Solution1;
import org.junit.Test;

public class TestLick {
    Solution1 main = new Solution1();
    @Test
    public void testClone(){
        // 创建求解对象
        Solution solution = new Solution();
        // 创建随机链表
        RandomListNode list1 = new RandomListNode(1);
        list1.next = new RandomListNode(2);
        list1.next.next = new RandomListNode(3);
        list1.random = list1.next.next;
        RandomListNode res = solution.clone(list1);
        System.out.println(res);
        System.out.println("list1:"+list1);


    }

    @Test
    public void TestHasCycle(){
        int d = 2088;
        int day = d*365+(d-1)/4-(d-1)/100+(d-1)/400;
        day+=6;
        System.out.println(day%7);


    }

    @Test
    public void Test01(){

        int jiangli[] = {195,316,943,249,716,476,681};
        int[] c = {0,0,0,1,1,1,0,1,1,0,0,1,0,0,0,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1};
        int sum = 0;
        int day = 0;
        for(int i = 0; i < c.length; i++){
            sum += c[i]*jiangli[day];
            if(day==6){
                day = 0;
            }else {
                day++;
            }
        }
        System.out.println(sum);
    }

    @Test
    public void Test02(){
        int a=2791,b=9;
        Main solution = new Main();
        int len[] = solution.riqi(a,b);
        int jiangli[] = {195,316,943,249,716,476,681};
        int[] c = {0,0,0,1,1,1,0,1,1,0,0,1,0,0,0,1,0,1,0,0,1,1,1,1,0,1,1,0,1,1};
        int day = (a-1)*365+(a-1)/4-(a-1)/100+(a-1)/400;
        day%=7;
        for(int i = 1; i<b; i++){
            day+=len[i];
        }
        day = (day+1)%7;
        System.out.println("day="+day);
        int sum = 0;
        for(int i = 0; i < c.length; i++){
            sum += c[i]*jiangli[day];
            if(day == 6){
                day = 0;
            }else {
                day++;
            }
        }
        System.out.println("sum="+sum);
    }


    @Test
    public void Test03(){

    }
}
