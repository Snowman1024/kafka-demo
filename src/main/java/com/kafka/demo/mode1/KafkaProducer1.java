//package com.kafka.demo.mode1;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.kafka.demo.common.Constant;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.concurrent.ListenableFuture;
//
///**
// * @Description
// * @Author Snowman2014
// * @Date 2020/1/13 17:07
// * @Version 1.0
// **/
//@Component
//public class KafkaProducer1 {r
//
//    private static Logger logger = LoggerFactory.getLogger(KafkaProducer1.class);
//
//
//    @Autowired
//    KafkaTemplate kafkaTemplate;
//
//
//    public void produce() {
//        logger.info("发送消息开始..");
//        String msg = "kafka哈哈哈";
//        ListenableFuture s = kafkaTemplate.send(Constant.TOPIC_A, msg);
//
//        String result =  JSON.toJSONString(s, SerializerFeature.WriteMapNullValue);
//        logger.info("发送消息返回:{}",result);
//    }
//
//
//}
