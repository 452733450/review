package com.jack.test;

import java.util.PriorityQueue;

public class OrderedMessageQueue {

    private PriorityQueue<Message> messageQueue = new PriorityQueue<>();

    public void enqueue(Message message) {
        synchronized (messageQueue) {
            messageQueue.offer(message);
        }
    }

    public Message dequeue() {
        synchronized (messageQueue) {
            return messageQueue.poll();
        }
    }

    public static class Message implements Comparable<Message> {
        private String content;
        private int priority;

        public Message(String content, int priority) {
            this.content = content;
            this.priority = priority;
        }

        @Override
        public int compareTo(Message other) {
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return "Message{" +
                    "content='" + content + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }

    public static void main(String[] args) {
        OrderedMessageQueue messageQueue = new OrderedMessageQueue();

        messageQueue.enqueue(new Message("Message 1", 3));
        messageQueue.enqueue(new Message("Message 2", 1));
        messageQueue.enqueue(new Message("Message 3", 2));

        System.out.println("Dequeue messages in order:");
        while (!messageQueue.messageQueue.isEmpty()) {
            System.out.println(messageQueue.dequeue());
        }
    }
}

