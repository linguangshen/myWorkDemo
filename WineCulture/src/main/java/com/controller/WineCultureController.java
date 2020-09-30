package com.controller;


import com.bean.ParmList;
import com.bean.WineCulture;
import com.service.WineCultureService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wineCulture")
public class WineCultureController {

    @Autowired
    private WineCultureService wineCultureService;

    //查询所有红酒文化
    @GetMapping("/queryCulture")
    public ResponseEntity<List<WineCulture>> queryCulture(){
        List<WineCulture>list = wineCultureService.queryAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/test")
    public void insertCulture(@RequestBody ParmList parmList){
        List<String> picturePath = parmList.getPicturePath();
        System.out.println(parmList);
    }
}
