package com.wy.dataStructure.lickedList;

public class DoubleLickedListDemo {
    public static void main(String[] args) {
        // 测试
        // 创建节点
        HeroNode2 hero1 = new HeroNode2(1,"宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲", "豹子头");
        // 创建链表
        DoubleLickedList list = new DoubleLickedList();

        // 加入链表
        list.addByOrder(hero4);
        list.addByOrder(hero3);
        list.addByOrder(hero2);
        list.addByOrder(hero1);

        //显示
        list.list();

        // 修改
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        list.update(newHeroNode);
        System.out.println("修改后的链表");
        list.list();

        // 删除
        list.delete(hero3);
        System.out.println("删除之后的链表");
        list.list();

    }
}

class DoubleLickedList{
    // 先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    public void add(HeroNode2 heroNode){
        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        // 遍历链表，找到最后
        while (true) {
            //
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 第二种方式在添加时，要按照顺序排序
    public void addByOrder(HeroNode2 heroNode){
        // 因为是单链表，我们找的temp是位于添加节点的前一个位置
        HeroNode2 temp = head;
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
           heroNode.next=temp.next;
           if(temp.next!=null){
               temp.next.pre=heroNode;
           }
           temp.next=heroNode;
           heroNode.pre=temp;
        }
    }


    // 修改节点的信息，根据No编号来修改，即no编号不能改
    public void update(HeroNode2 newHeroNode) {
        // 判断是否为空
        if (head.next == null){
            System.out.println("链表为空~");
            return;
        }
        //找到需要修改的节点
        HeroNode2 temp = head.next;
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

    // 删除节点
    public void delete(HeroNode2 heroNode){
        //
        if(head.next == null){
            System.out.println("链表为空~~");
            return;
        }

        HeroNode2 temp = head;
        boolean flag = false; // 表示链表中是否存在要删除的节点，默认为false
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(!flag){
            System.out.println("链表中不存在该数据");
        }else {
            temp.pre.next=temp.next;
            if(temp.next!=null){
                temp.next.pre=temp.pre;
            }
        }
    }

    // 显示链表
    public void list() {
        // 判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空~~");
            return;
        }
        HeroNode2 temp = head.next;
        while (temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    // 构造器
    public HeroNode2(int nHo, String nName, String nickname) {
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