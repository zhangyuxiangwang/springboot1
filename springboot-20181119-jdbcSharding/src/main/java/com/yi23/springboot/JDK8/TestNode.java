package com.yi23.springboot.JDK8;

import com.yi23.springboot.bean.Node;

/**
 * @Author : 王斌
 * @Date : 2019/3/22 下午1:17
 * @Description 单向链表反转
 */
public class TestNode {

    public static void main(String[] args) {

        Node node = reserver3(initNode());
        System.out.println(node);
    }


    public static Node reserver3(Node node){
        Node build = Node.builder().next(null).nodeId(-1).build();
        Node next = node.getNext();
        while (next !=null){
            Node next1 = next.getNext();
            System.out.println(next1);
            next.setNext(build.getNext());
            build.setNext(next);
            next=next1;
        }
        return build;
    }
















    public static Node reserver2(Node node){
        Node build = Node.builder().nodeId(-1).next(null).build();
        Node next = node.getNext();
        while(next !=null){
            Node next1 = next.getNext();
            next.setNext(build.getNext());
            build.setNext(next);
            next=next1;
        }
        return build;
    }

























    public static Node reserver1(Node node){

        Node node1 = Node.builder().nodeId(-1).next(null).build();

        Node next = node.getNext();

        while(next !=null){
            Node head=next.getNext();
            next.setNext(node1.getNext());
            node1.setNext(next);
            next=head;
        }

        return node1;

    }














    public static Node reverse(Node node){
        Node build = Node.builder().next(null).nodeId(-1).build();
        Node next = node.getNext();
        while(next !=null){
            Node rem = next.getNext();
            next.setNext(build.getNext());
            build.setNext(next);
            next=rem;
        }
        return build;
    }

    public static Node initNode() {
        Node node = new Node();
        node.setNodeId(0);
        node.setNext(Node.builder().nodeId(1).next(Node.builder().nodeId(2).next(Node.builder().nodeId(3).next(Node.builder().nodeId(4).next(null).build()).build()).build()).build());
       // System.out.println(node);
        return node;
    }

    public static Node reverseNode(Node node) {

        if (node == null || node.getNext() == null) {
            return node;
        }

//        Node newNode = node.getNext();
        Node node1 = reverseNode(node.getNext());
        if(node1 ==null){

        }else{

            Node next = node1.getNext();
            if (next == null){
                next.setNext(node);
            }

        }


        return node1;
    }

    static Node reverseList(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        // 我们先把递归的结果保存起来，先不返回，因为我们还不清楚这样递归是对还是错。，
        Node newList = reverseList(head.getNext());
        return newList;
    }


    // 1.就地反转法
    public static Node reverseList1(Node head) {
        if (head == null){
            return head;
        }
        Node dummy = new Node(-1,null);
        dummy.setNext(head) ;
        System.out.println(dummy);
        Node prev = dummy.getNext();
        Node pCur = prev.getNext();
        while (pCur != null) {
            prev.setNext(pCur.getNext());
            pCur.setNext(dummy.getNext());
            dummy.setNext(pCur);
            pCur = prev.getNext();
        }
        return dummy;
    }

    // 2.新建链表,头节点插入法
    public static Node reverseList2(Node head) {
        Node dummy = new Node(-1,null);
        Node pCur = head;
        while (pCur != null) {
            Node pNex = pCur.getNext();
          //  System.out.println("dummy.getNext()--"+dummy.getNext());
            pCur.setNext(dummy.getNext());
            System.err.println("----"+pCur);
            dummy.setNext(pCur);
            System.out.println(dummy);
            pCur = pNex;
        }
        return dummy.getNext();
    }
}
