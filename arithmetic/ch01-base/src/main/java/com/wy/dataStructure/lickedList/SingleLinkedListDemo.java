package com.wy.dataStructure.lickedList;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode hero1 = new HeroNode(1,"宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用", "智多星");
        HeroNode hero4 = new HeroNode(4,"林冲", "豹子头");
        // 创建链表
        SingleLinkedList list = new SingleLinkedList();
        // 加入链表
        list.addByOrder(hero1);
        list.addByOrder(hero4);
        list.addByOrder(hero2);
        list.addByOrder(hero3);
        list.delete(hero4);

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "123");
        list.update(newHeroNode);

        // 显示
        list.list();
        System.out.println(getLength(list.getHead()));
        System.out.println(findLastIndexNode(list.getHead(),3));
        reverse(list.getHead());
        list.list();
        System.out.println("逆序打印~~");
        reversePrint(list.getHead());

    }

    // 方法：获取单链表的节点个数
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    // 方法：查找单链表的倒数k个节点
    // 思路

    public static HeroNode findLastIndexNode(HeroNode head, int index){
        if(head.next == null){
            return null;
        }
        int length = getLength(head);
        if(index<=0 || index > length)
            return null;
        HeroNode temp = head.next;
        for(int i = 0; i < length-index; i++){
            temp=temp.next;
        }
        return temp;
    }


    // 反转链表
    public static void reverse(HeroNode head){
        if(head.next == null || head.next.next==null)
            return;
        // 定义一个辅助的变量。帮助遍历
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null;
        // 遍历链表，每遍历一个节点，将其取出，并放在新的链表reverseHead的最前端
        while (cur != null){
            next = cur.next; // 先暂时保存当前节点的下一个节点，
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next; //让cur后移

        }
        // 将head.next 指向reverseHead.next
        head.next = reverseHead.next;
    }

    // 从尾到头打印单链表
    public static void reversePrint(HeroNode head){
        if(head.next == null)
            return;
        Stack<HeroNode> list = new Stack<>();
        HeroNode cur = head.next;
        while (cur!=null){
            list.push(cur);
            cur = cur.next;
        }
        while (!list.empty()){
            System.out.println(list.pop());
        }

    }

    // 合并两个顺序链表
    public static HeroNode combine(HeroNode head1, HeroNode head2){
        if(head1.next==null || head2.next==null){
            if(head1.next==null)
                return head2;
            return head1;
        }
        HeroNode cur1 = head1.next;
        HeroNode cur2 = head2.next;
        HeroNode head = new HeroNode(0,"","");
        HeroNode cur = head.next;
        while (!(cur1==null && cur2 ==null)){
            if(cur1.no < cur2.no){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur = cur.next;
                if(cur1.no == cur2.no){
                    cur1 = cur1.next;
                }
                cur2 = cur2.next;
            }
        }
        return head;
    }

}

// 定义SingleLinkedList管理
class SingleLinkedList{
    // 先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    // 思路，当不考虑编号顺序
    // 1. 找到当前链表的最后节点
    // 2.将最后这个节点的next，指向新的节点
    public void add(HeroNode heroNode){
        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            //
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    // 第二种方式在添加时，要按照顺序排序
    public void addByOrder(HeroNode heroNode){
        // 因为是单链表，我们找的temp是位于添加节点的前一个位置
        HeroNode temp = head;
        boolean flag = false; // 标志添加的编号是否存在，默认false
        while (true) {
            if(temp.next == null){
                // 说明temp已经在链表的最后
                break;
            }
            if(temp.next.no > heroNode.no) {
                // 位置找到了
                break;
            }
            if(temp.next.no == heroNode.no){
                // 说明希望添加的heroNode的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag的值
        if(flag){
            // 不能添加
            System.out.println("准备插入的英雄的编号"+heroNode.no+"已经存在，不能插入");
        }else {
            // 插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 显示链表
    public void list() {
        // 判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空~~");
            return;
        }
        HeroNode temp = head.next;
        while (temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 删除节点
    public void delete(HeroNode heroNode){
        //
        HeroNode temp = head;
        boolean flag = false; // 表示链表中是否存在要删除的节点，默认为false
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(!flag){
            System.out.println("链表中不存在该数据");
        }else {
            temp.next = temp.next.next;
        }
    }

    // 修改节点的信息，根据No编号来修改，即no编号不能改
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null){
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if(temp == null){
                break; // 已经遍历结束
            }
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没有找到编号"+newHeroNode.no+"的节点");
        }
    }

}

// 定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    // 构造器
    public HeroNode(int nHo, String nName, String nickname) {
        this.no = nHo;
        this.name = nName;
        this.nickname = nickname;
    }

    // 为了显示方便
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}