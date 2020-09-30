package com.test.ceshi;


import feign.Category;
import feign.CategroyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class FeignTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CategroyFeign categroyFeign;

    @RequestMapping("test")
    public List<Category> getList(){
        ArrayList<Category> list = new ArrayList<Category>();
        //ArrayList forObject = restTemplate.getForObject("http://localhost:18081/ceshi/ceshi", list.getClass());
        List<Category> query = categroyFeign.query();
        return query;
       // return forObject;
    }

}
