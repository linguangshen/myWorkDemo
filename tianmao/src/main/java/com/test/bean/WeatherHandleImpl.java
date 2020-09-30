package com.test.bean;

import com.alibaba.da.coin.ide.spi.meta.ExecuteCode;
import com.alibaba.da.coin.ide.spi.meta.ResultType;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// 天气服务执行，根据NLU理解的结果做相应处理并返回回复语句
@Component
public class WeatherHandleImpl implements WeatherHandle {

    @Override
    public TaskResult execute(TaskQuery taskQuery) {
//        logger.info("WeatherHandleImpl execute...");

        //从请求中获取意图参数以及参数值
        Map<String, String> paramMap = taskQuery
                .getSlotEntities()
                .stream()
                .collect(
                        Collectors.toMap(slotItem -> slotItem.getIntentParameterName(),
                                slotItem -> slotItem.getStandardValue()));
        logger.info("paramMap ：" + paramMap.toString());
        //如果意图是询问空气质量，则执行空气质量逻辑
        if (taskQuery.getIntentName().equals("空气质量")) {
            return aqiQuery(taskQuery, paramMap);
            //如果意图是询问天气情况，则执行天气查询逻辑
        } else if (taskQuery.getIntentName().equals("天气查询")) {
            return baseQuery(taskQuery, paramMap);
        } else {
            return null;
        }
    }

}