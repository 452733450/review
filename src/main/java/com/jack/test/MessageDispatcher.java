//package com.jack.test;
//
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.message.MessageExt;
//
//import java.util.List;
//
//public class MessageDispatcher {
//
//    public static void main(String[] args) throws Exception {
//        String consumerGroup = "your_consumer_group";
//        String nameServerAddress = "your_name_server_address";
//        String topic = "your_topic";
//
//        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
//        consumer.setNamesrvAddr(nameServerAddress);
//        consumer.subscribe(topic, "*");
//
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messages, ConsumeConcurrentlyContext context) {
//                for (MessageExt message : messages) {
//                    String messageBody = new String(message.getBody());
//                    System.out.println("Received message: " + messageBody);
//
//
//                    // For demonstration purposes, we mark the message as successfully consumed
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });
//
//        consumer.start();
//        System.out.println("Message Dispatcher started...");
//
//        // Keep the main thread alive
//        while (true) {
//            Thread.sleep(1000);
//        }
//    }
//}
//
