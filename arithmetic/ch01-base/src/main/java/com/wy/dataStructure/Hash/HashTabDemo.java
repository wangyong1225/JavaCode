package com.wy.dataStructure.Hash;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Scanner sn = new Scanner(System.in);
        String key = "";
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出");
            System.out.println("del:退出");
            key = sn.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = sn.nextInt();
                    System.out.println("输入姓名：");
                    String name = sn.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id：");
                    int empId = sn.nextInt();
                    hashTab.findEmpById(empId);
                    break;
                case "del":
                    System.out.println("请输入要删除的id：");
                    int delId = sn.nextInt();
                    hashTab.deleteEmpById(delId);
                    break;

                default:
                    break;
            }
        }

    }
}
// hash表
class HashTab{
    private EmpLickedList[] empLickedListArray;
    private int size;
    public HashTab(int size){
        this.size = size;
        empLickedListArray = new EmpLickedList[size];
        for(int i = 0; i < size; i++){
            empLickedListArray[i] = new EmpLickedList();
        }
    }

    public void add(Emp emp){
        int empLickedListNo = hashFun(emp.id);
        empLickedListArray[empLickedListNo].add(emp);

    }

    //遍历所有链表
    public void list(){
        if(size==0){
            System.out.println("链表为空");
        }
        for(int i = 0; i < size; i++){
            empLickedListArray[i].list(i);
        }
    }

    // 查找
    public void findEmpById(int id){
        int empLickedListNo = id % size;
        Emp emp = empLickedListArray[empLickedListNo].find(id);
        if(emp!=null){
            System.out.printf("在第%d条链表中找到了id：%d",empLickedListNo,id);
        }else {
            System.out.println("没有找到");
        }
    }

    //  删除
    public void deleteEmpById(int id){
        int empLickedListNo = id % size;
        empLickedListArray[empLickedListNo].deleteById(id,empLickedListNo);
    }

    // 编写散列函数，使用简单的取模法
    public int hashFun(int id){
        return id % size;
    }

}
// 表示一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp (int id, String name){
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }
}

// 表示一个链表
class EmpLickedList{
    private Emp head; // 头指针

    // 添加员工
    // 1.添加雇员时，id是自增长的，
    // 因此直接将雇员加入到链表的结尾
    public void add(Emp emp){
        if(head==null){
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next=emp;
    }

    // 遍历链表
    public void list(int n){
        if(head==null){
            System.out.println(n+1+"链表为空~~");
            return;
        }
        System.out.print(n+1+"链表的信息为:");
        Emp curEmp = head;
        while (true){
            if(curEmp==null){
                break;
            }
            System.out.print("[id="+curEmp.id+",name="+curEmp.name+"]");
            curEmp=curEmp.next;
        }
        System.out.println();
    }

     // 查找
    public Emp find(int id){
        // 判断链表是否为空
        if(head==null)
            return null;
        Emp curEmp = head;
        while (true){
            if(curEmp.id == id){
                break;
            }
            if(curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

    // 删除
    public void deleteById(int id, int i){
        if(head==null){
            System.out.println(i+"链表为空");
            return;
        }
        Emp curEmp = head;
        if(curEmp.id == id){
            head=head.next;
            System.out.println("删除成功！");
            return;
        }
        while (true){
            if(curEmp.next==null){
                System.out.println("删除失败，无此雇员");
                return;
            }
            if(curEmp.next.id == id){
                curEmp.next = curEmp.next.next;
                System.out.println("删除成功！");
                return;
            }
            curEmp = curEmp.next;
        }

    }

}