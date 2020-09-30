package com.service.Impl;

import com.bean.Detail;
import com.service.DetailService;
import com.dao.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailMapper detailMapper;

    @Override
    public List<Detail> queryList() {
        List<Detail> details = detailMapper.selectAll();
        return details;
    }
}
