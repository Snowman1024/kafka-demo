//package com.kafka.demo.mode2;
//
//import com.kafka.demo.mode3.KafkaConfig;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.Properties;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @Description
// * @Author Snowman2014
// * @Date 2020/1/15 14:59
// * @Version 1.0
// **/
//@Component
//public class KafkaConsumer2 implements InitializingBean {
//
//    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer2.class);
//
//    @Autowired
//    private KafkaConfig kafkaConfig;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        //每个线程一个KafkaConsumer实例，且线程数设置成分区数，最大化提高消费能力
//        int consumerThreadNum = 3;
//
//        int keepAliveTime = 0;
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(consumerThreadNum, consumerThreadNum, keepAliveTime,
//                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
//
//        for (int i = 0; i < consumerThreadNum; i++) {
//            executor.submit(new KafkaConsumerThread(kafkaConfig.customerConfigs(), kafkaConfig.getTopic()));
//
//        }
//    }
//
//
//    /**
//     * 消费者线程
//     */
//    public class KafkaConsumerThread implements Runnable {
//
//        private org.apache.kafka.clients.consumer.KafkaConsumer<String, String> kafkaConsumer;
//
//        public KafkaConsumerThread(Properties props, String topic) {
//            this.kafkaConsumer = new org.apache.kafka.clients.consumer.KafkaConsumer<String, String>(props);
//            this.kafkaConsumer.subscribe(Arrays.asList(topic));
//        }
//
//        @Override
//        public void run() {
//            try {
//                while (true) {
//
//                    ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
//
//                    for (ConsumerRecord<String, String> record : records) {
//                        logger.info("接收到消息:{}", record.value());
//                    }
//                }
//
//            } catch (Exception e) {
//                logger.error("接受消息异常:{}", e);
//            } finally {
//                kafkaConsumer.close();
//            }
//        }
//
//    }
//}
