package com.sendMessage.Demo;

import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;


public class Test {

    @Value("${myUrl.buyOrderUrl}")
    private String url1;

    @Value("${myUrl.buyOrderUrl2}")
    private String url2;


    public static void main(String[] args) {
        Test test = new Test();
        List<String> test1 = test.test();
        System.out.println(test1.toString());
    }

    public List<String> test(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add(url1);
        strings.add(url2);
        return strings;
    }
}
