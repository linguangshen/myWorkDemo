package com.test.controller;

import com.test.Bean.Material;
import com.test.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("Demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

//    @RequestMapping
//    public ResponseEntity<List<Material>> getAll(){
//        List<Material> materials = demoService.
//    }
}
