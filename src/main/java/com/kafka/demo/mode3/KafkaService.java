package com.kafka.demo.mode3;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Optional;

/**
 * @Description
 * @Author Snowman2014
 * @Date 2020/1/16 17:24
 * @Version 1.0
 **/
@Service
public class KafkaService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaService.class);


    @Autowired
    private KafkaConfig kafkaConfig;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    /**
     * 发送消息
     * 异步，可以注销，除非网络出问题，否则发送消息到kafka服务器非常快
     */
    @Async
    public void sendMessage(String msg) {
        long start = System.currentTimeMillis();
        String topic = kafkaConfig.getTopic();

        //等同于加事务注解	@Transactional(rollbackFor = RuntimeException.class)
//        kafkaTemplate.executeInTransaction(t->{
//           t.send(topic,msg);
//           t.send(topic,"");
//           return true;
//        });

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, msg);
        //异步获取
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("发送消息异常,ex={},topic={},data={}", ex, topic, msg);
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                logger.info("发送消息成功,topic={},data={}", topic, msg);
            }
        });
        long end = System.currentTimeMillis();
        logger.info("写入kafka耗时:{}毫秒", (end - start));
    }


    /**
     * 接受消息
     *
     * @param record
     */
    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.name}",
            errorHandler = "myKafkaErrorHandler")
    public void consumer(ConsumerRecord<String, String> record) {

        Optional<String> messageOptional = Optional.ofNullable(record.value());
        if (messageOptional.isPresent()) {
            String message = messageOptional.get();
            logger.info("接受kafka消息:{}", message);
        }
    }

}
