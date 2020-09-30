package com.test.controller;

import com.alibaba.da.coin.ide.spi.standard.ResultModel;
import com.alibaba.da.coin.ide.spi.standard.TaskQuery;
import com.alibaba.da.coin.ide.spi.standard.TaskResult;
import com.alibaba.da.coin.ide.spi.trans.MetaFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {

//    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private WeatherHandle weatherHandle;

    /**
     * skill开发者提供的技能执行路径地址，请求方式为POST请求
     * 
     * @param taskQuery
     * @return
     */
    @RequestMapping(value = "/skill/weather", method = RequestMethod.POST)
    public @ResponseBody
    ResultModel<TaskResult> getResponse(@RequestBody String taskQuery) {

        /**
         * 将开发者平台识别到的语义理解的结果（json字符串格式）转换成TaskQuery
         */
//        logger.info("TaskQuery:{}", taskQuery.toString());
        TaskQuery query = MetaFormat.parseToQuery(taskQuery);

        /**
         * 构建服务返回结果
         */
        ResultModel<TaskResult> resultModel = new ResultModel<TaskResult>();
        try {
            /**
             * 调用天气服务执行并构建回复内容
             */
            TaskResult result = weatherHandle.execute(query);
            resultModel.setReturnCode("0");
            resultModel.setReturnValue(result);
        } catch (Exception e) {
            resultModel.setReturnCode("-1");
            resultModel.setReturnErrorSolution(e.getMessage());
        }

        /**
         * 直接返回ResultModel<TaskResult>对象就ok
         */

        return resultModel;
    }

}