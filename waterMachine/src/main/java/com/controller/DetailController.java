package com.controller;

import com.bean.Detail;
import com.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @RequestMapping("/queryDetail")
    public Object queryDetail(){
        List<Detail> details = detailService.queryList();
        return details;
    }
}
