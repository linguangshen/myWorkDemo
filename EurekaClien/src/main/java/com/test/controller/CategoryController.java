package com.test.controller;


import com.test.Bean.Category;
import com.test.service.CategoryService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ceshi")
public class CategoryController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitTemplate.ConfirmCallback myConfirmCallback;

    @Autowired
    private RabbitTemplate.ReturnCallback returnCallback;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("ceshi")
    public List<Category> query(){
        List<Category> list = categoryService.list();
        return list;
    }

    @GetMapping("test")
    public String helloword(){
        return "hello";
    }

    @GetMapping("/404")
    public String notFoundPage() {
        return "/404";
    }

    @GetMapping("/403")
    public String accessError() {
        return "/403";
    }

    @GetMapping("/405")
    public String accessError2() {
        return "/405";
    }

    @GetMapping(value = "/user/login")
    private String loginPage(){
        return "/login";
    }

    @RequestMapping("send")
    //发送消息给mq
    public String send (){
        //设置回调函数
        rabbitTemplate.setConfirmCallback(myConfirmCallback);
        //设置回调函数
        //rabbitTemplate.setReturnCallback(returnCallback);

        rabbitTemplate.convertAndSend("myExchange","myBiding","hello,你好a");
        return "ok";
    }

}
