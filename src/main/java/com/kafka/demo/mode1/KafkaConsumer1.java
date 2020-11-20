//package com.kafka.demo.mode1;
//
//import com.kafka.demo.common.Constant;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Description
// * @Author Snowman2014
// * @Date 2020/1/13 17:52
// * @Version 1.0
// **/
//@Component
//public class KafkaConsumer1 {
//
//     private static Logger logger = LoggerFactory.getLogger(KafkaConsumer1.class);
//
//    @KafkaListener(topics = {Constant.TOPIC_A})
//    public void listen(String msg) {
//        logger.info("消费者接受消息: "+ msg);
//
//    }
//
//}
