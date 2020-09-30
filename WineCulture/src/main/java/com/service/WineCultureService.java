package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.bean.WineCulture;

import java.util.List;

public interface WineCultureService {
    //查询所有红酒文化
    List<WineCulture> queryAll();
}
