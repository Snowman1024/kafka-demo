package com.kafka.demo.controller;

import com.kafka.demo.mode3.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Snowman2014
 * @Date 2020/1/13 17:33
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

//    @Autowired
//    private KafkaProducer1 kafkaProducer1;

//    @Autowired
//    private KafkaProducer2 kafkaProducer2;

    @Autowired
    private KafkaService kafkaService;


    /**
     * 方式一
     * @return
     */
//    @GetMapping("/test")
//    public String test(){
//        try{
//            kafkaProducer1.produce();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return "falier";
//        }
//        return "success";
//    }


    /**
     * 方式二
     *
     * @return
     */
//    @GetMapping("/test2")
//    public String test2(){
//        try{
//            kafkaProducer2.producer();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return "falier2";
//        }
//        return "success2";
//    }
    @GetMapping("/test3")
    public String test3() {
        try {
            kafkaService.sendMessage("你好，kafka...");
        } catch (Exception e) {
            e.printStackTrace();
            return "falier3";
        }
        return "success3";
    }
}
