package com.wy.dataStructure.lickedList;

public class CircleListDemo {
    public static void main(String[] args) {
        // 测试
        CircleList head = new CircleList();
        head.addBoy(5);
        head.yueSeFu2(1,1,5);

    }

}

class CircleList{
    // 创建一个first节点，当前没有编号
    private Boy first = null;
    // 添加小孩节点，构建一个环形的链表
    public void addBoy(int num){
        if(num < -1){
            System.out.println("num的值不正确");
            return;
        }
        Boy curBoy = null;
        for(int i = 1; i <= num; i++){
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if(i == 1){
                first =  boy;
                first.next=first;
                curBoy = first;
            }else {
                curBoy.next = boy;
                boy.next = first;
                curBoy = boy;
            }

        }
    }

    // 遍历当前环形链表
    public void list(){
        // 先判断链表是否为空
        if(first == null){
            System.out.println("链表为空");
        }
        // 因为first指针不能动，所有要创建辅助指针
        Boy curBoy = first;
        while (true){
            System.out.println("小孩的编号为："+curBoy.val);
            if(curBoy.next==first){
                break;
            }
            curBoy = curBoy.next;
        }
    }

    public void yueSeFu(int k, int m, int n){
        if(first == null){
            System.out.println("没有小孩");
            return;
        }
        Boy help = first;
        for(int i = 1; i < k; i++){
            if(i == 1){
                first = first.next;
            }else {
                first = first.next;
                help = help.next;
            }
        }
       for(int i = n; i > 0; i--){
           if(i==1){
               System.out.println("编号为："+first.val);
           }else {
               int order = m % (i+1);
               for(int j = 1; j < order; j++){
                   if(help==first){
                       first = first.next;
                   }else {
                       first = first.next;
                       help = help.next;
                   }
               }
               System.out.println("编号为："+first.val);
               help.next=first.next;
               first=help.next;
           }
       }

    }

    public void yueSeFu2(int k, int m, int n){
        if(k<1 || k>n || m<0){
            System.out.println("数据输入不对！！");
            return;
        }
        if(m==1){
            Boy curBoy = first;
            System.out.println(curBoy.val);
            while (curBoy.next!=first){
                curBoy = curBoy.next;
                System.out.println(curBoy.val);
            }
            return;
        }
        for(int i = 0; i < k-1 ;i++){
            first=first.next;
        }
        while (first.next!=first){
            int order = m % (n+1);
            for(int i = 0; i < order-2;i++){
                first=first.next;
            }
            System.out.println("小孩的编号为："+first.next.val);
            first.next=first.next.next;
            first=first.next;
            n--;
        }
        System.out.println("最后小孩的编号为"+first.val);
    }


}

class Boy{
    int val;
    Boy next;
    public Boy(int i){
        val = i;
    }
}