package com.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bean.WineCulture;
import com.dao.WineCultureMapper;
import com.service.WineCultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineCultureServiceImpl implements WineCultureService {

    @Autowired
    private WineCultureMapper wineCultureMapper;

    //查询所有红酒文化
    @Override
    public List<WineCulture> queryAll() {
        //List<WineCulture> wineCultures = wineCultureMapper.selectAll();
        List<WineCulture> wineCultures = wineCultureMapper.queryWineCulturesList();
        return wineCultures;
    }
}
