package com.dao;



import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bean.WineCulture;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface WineCultureMapper extends Mapper<WineCulture> {

    //查询所有红酒文化
    List<WineCulture> queryWineCulturesList();
}
