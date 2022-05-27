package com.jack.practice.middle.no146;

import java.util.HashMap;

public class Solution20220503 {
    // map查找的时间复杂度为O(1)
    HashMap<Integer, ListNode> map;
    // map没有办法记录最近最少使用的key
    // 如果用数组缓存，进行缓存更新的时候，要对数组下标进行维护，时间复杂度为O(N),链表的插入删除为(1)
    // 链表查找的时间复杂度为O(N)
    DoubleLinkedList cache;
    int cap;

    public Solution20220503(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // 取出之后将key放到缓存的第一位
        int val = map.get(key).val;
        // 取出之后将原来的缓存删除
        cache.delete(map.get(key));
        // 更新到缓存的第一位
        cache.addFirst(map.get(key));
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // key在map中已经存在，那么cache中一定有这个缓存node，要先删除这个缓存
            cache.delete(map.get(key));
        } else {
            // 如果key在map中不存在
            if (map.size() == cap) {
                // map满了，说明缓存也满了，删除掉最后一个缓存node
                int k = cache.deleteLast();
                map.remove(k);
            }
        }
        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        cache.addFirst(newNode);
    }

    class DoubleLinkedList {
        public ListNode head;
        public ListNode tail;

        public DoubleLinkedList() {
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(ListNode newNode) {
            ListNode next = head.next;
            head.next = newNode;
            newNode.pre = head;
            newNode.next = next;
            next.pre = newNode;
        }

        public int delete(ListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node.key;
        }

        public int deleteLast() {
            if (head.next == tail) {
                return -1;
            }
            return delete(tail.pre);
        }
    }
}

class ListNode {
    int key;
    int val;
    ListNode pre;
    ListNode next;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;

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
