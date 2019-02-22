package com.me.ready.node;

/**
 * @Autor syl
 * @Date 2019/2/22 10:06
 **/
public class NodeReverse {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode h = head;
        while (null != h) {
            System.out.print(h.data + " ");
            h = h.next;
        }

        // 递归方式反转单链表
//        head = reverse(head);
//
//        System.out.println("\n---------------------------");
//        while (null != head) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }

        // 遍历方式反转单链表
//        head = reverse2(head);
//
//        System.out.println("\n---------------------------");
//        while (null != head) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }

        ListNode listNode = reverseBetween2(head, 2, 4);
        System.out.println("\n---------------------------");
        while (null != listNode) {
            System.out.print(listNode.data + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        if (head == null || head.next == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }
        ListNode reHead = reverse(head.next);// 先反转后续节点head.getNext()
        head.next.next = head;// 将当前结点的指针域指向前一结点
        head.next = null;// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    public static ListNode reverse2(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;    // 上一节点
        ListNode cur = head.next;  // 当前节点
        ListNode tmp;                   // 临时节点，用于保存当前节点的下一节点
        while (cur != null) {   // 当前节点为null，说明为尾节点
            tmp = cur.next;
            cur.next = pre;   // 反转指针指向

            // 指针向下移动
            pre = cur;
            cur = tmp;
        }
        // 最好将原链表的头节点的指针域设置为null，返回新链表的头结点，即原链表的尾节点
        head.next = null;
        return pre;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;

        int length = 0;
        ListNode dom = new ListNode(0);
        dom.next = head;
        ListNode pre = dom;

        // 查找反转的位置
        while (length < m - 1) {
            length++;
            pre = pre.next;
        }

        // 获取需要反转的Sublist，并做反转
        ListNode rHead = null;
        ListNode rTail = null;
        ListNode tmp = pre.next;
        ListNode next;
        while (length < n) {
            next = tmp.next;
            if (rTail == null) {
                rHead = tmp;
                rTail = tmp;
            } else {
                tmp.next = rHead;
                rHead = tmp;
            }

            tmp = next;
            length++;
        }

        // 将反转的Sublist并入原来的List中
        if (rHead != null) {
            pre.next = rHead;
            rTail.next = tmp;
        }
        return dom.next;
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode pNoden = null;
        ListNode pNodennext = null;
        ListNode pNodemprev = head;
        ListNode pNode = pNodemprev.next;
        ListNode pNodem = pNode;
        if (m == 1) {
            pNodemprev = null;
            pNode = head;
        } else {
            for (int i = 0; i < m - 2; i++) {
                pNodemprev = pNodemprev.next;
            }
            pNode = pNodemprev.next;
        }
        pNodem = pNode;
        ListNode pPrev = null;
        for (int i = 0; i < n - m + 1; i++) {
            ListNode pNext = pNode.next;
            if (i == n - m) {
                pNoden = pNode;
                if (pNext == null)
                    pNodennext = null;
                else
                    pNodennext = pNext;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        if (pNodemprev == null) {
            pNodem.next = pNodennext;
            return pNoden;
        }
        pNodemprev.next = pNoden;
        pNodem.next = pNodennext;
        return head;
    }

    public ListNode reverseBetween3(ListNode head, int m, int n) {
        /*
        思路：头插法 和 尾插法 的结合
        */
        if(head == null || m == n) return head;
        ListNode r = new ListNode(-1),res = r,s = new ListNode(-1),tail  = null;
        int i = 1;
        while(i <= n){
            ListNode node = new ListNode(head.data);
            if(i < m){
                r.next = node;  // r -1 0
                r = r.next; // r 0
            }else if(i <= n){
                if(i == m) tail = node;     // tail = 1
                node.next = s.next; // node 1 null
                s.next = node;      // s -1 1 null
            }
            head = head.next;   //
            i++;
        }
        tail.next = head;   // null
        r.next = s.next;    // 3 2 1
        return res.next;
    }
}
