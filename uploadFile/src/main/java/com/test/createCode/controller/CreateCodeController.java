package com.test.createCode.controller;

import com.alibaba.fastjson.JSON;
import com.test.createCode.util.CreateCodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("createCode")
public class CreateCodeController {

    @RequestMapping("test1")
    public void test() throws Exception {
//        CreateCodeUtil createCodeUtil = new CreateCodeUtil();
//        String token = createCodeUtil.postToken();
////        HashMap<String, Integer> map = new HashMap<String, Integer>();
////        map.put("prodid",1116);
////        String sene = JSON.toJSONString(map);
//        createCodeUtil.getminiqrQr("1116",token);
    }

    public static void main(String[] args) throws Exception {
        CreateCodeUtil createCodeUtil = new CreateCodeUtil();
        String token = createCodeUtil.postToken();
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        map.put("prodid",1116);
//        String sene = JSON.toJSONString(map);
//        createCodeUtil.getminiqrQr("1116",token);

        createCodeUtil.postMiniqrQr2("31TrpPS0C9E",token);
//        System.out.println(token);
    }


}
