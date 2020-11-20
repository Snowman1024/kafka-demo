//package com.kafka.demo.mode2;
//
//import com.kafka.demo.mode3.KafkaConfig;
//import org.apache.kafka.clients.producer.Producer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @Description
// * @Author Snowman2014
// * @Date 2020/1/14 17:41
// * @Version 1.0
// **/
//@Component
//public class KafkaProducer2 {
//
//    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer2.class);
//
//    @Autowired
//    private KafkaConfig kafkaConfig;
//
//    @Autowired
//    private Producer producer;
//
//
//    /**
//     * 发送
//     *
//     * @throws Exception
//     */
//    public void producer() {
//
//        String msg = "hello,kafka!";
//        ProducerRecord<String, String> record = new ProducerRecord<>(kafkaConfig.getTopic(), msg);
//        try {
//            producer.send(record, (recordMetadata, e) -> {
//
//                if (null == e) {
//                    logger.info("分区:{},偏移量:{}", recordMetadata.partition(), recordMetadata.offset());
//                } else {
//                    logger.error("消息发送返回失败:{}", e);
//                }
//            });
//        } catch (Exception e) {
//            logger.error("消息发送异常:{}", e);
//        }
//    }
//
//
//}
