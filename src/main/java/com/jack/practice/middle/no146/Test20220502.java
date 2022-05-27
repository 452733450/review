package com.jack.practice.middle.no146;

import java.util.HashMap;

public class Test20220502 {
    HashMap<Integer, Node> map;
    DoubleLinkedList cache;
    int cap;

    public Test20220502(int capacity) {
        map = new HashMap<>(capacity);
        cache = new DoubleLinkedList();
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key).val;
            put(key, val);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (map.containsKey(key)) {
            cache.delete(map.get(key));
        } else {
            if (map.size() == cap) {
                int k = cache.deleteLast();
                map.remove(k);
            }
        }
        cache.addFirst(newNode);
        map.put(key, newNode);
    }

    class DoubleLinkedList {
        public Node head;
        public Node tail;

        public DoubleLinkedList() {
            // 初始化一个头节点(0,0), 一个尾结点(0,0)
            head = new Node(0, 0);
            tail = new Node(0, 0);
            // 连接头尾节点
            head.next = tail;
            tail.pre = head;
        }

        // 最近使用的key插入头节点下一个节点
        public void addFirst(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public int delete(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node.key;
        }

        public int deleteLast() {
            if (head == tail) {
                return -1;
            }
            return delete(tail.pre);
        }
    }

    class Node {
        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Test20220502 cache = new Test20220502(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
