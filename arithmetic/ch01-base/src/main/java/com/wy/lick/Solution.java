package com.wy.lick;


import com.wy.lick.domain.ListNode;
import com.wy.lick.domain.RandomListNode;

public class Solution {

    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
     * 一个指向下一个节点，另一个特殊指针random指向一个随机节点），
     * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果
     * 中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * @param pHead
     * @return
     */
    public RandomListNode clone(RandomListNode pHead) {
        //  1 把复制的结点链接在原始链表的每一对应结点后面
        if (null == pHead)
            return null;
        RandomListNode currentNode = pHead;
        while (currentNode != null){
            RandomListNode node = new RandomListNode(currentNode.label);
            node.next = currentNode.next;
            currentNode.next=node;
            currentNode = currentNode.next.next;

        }
        // 2 重新遍历链表，复制老结点的随机指针给新结点，
        currentNode = pHead;
        while (currentNode != null){
            currentNode.next.random=currentNode.random==null ? null : currentNode.random.next;
            currentNode=currentNode.next.next;

        }
        // 3 拆分链表，将复制的结点形成一个新的链表
        pHead=pHead.next;
        currentNode=pHead;
        while (currentNode != null){
            currentNode.next=currentNode.next==null ? null : currentNode.next.next;
            currentNode=currentNode.next;
        }

        return pHead;
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null || p1 != null){
            if(p1 == p2){
                return true;
            }
            p1 = p1.next;
            p2 = p2.next == null ? null : p2.next.next;
        }
        return false;

    }

}
