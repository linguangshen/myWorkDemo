package com.sendMessage.Demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sendMessage.JavaBean.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class wechatMsg {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${myUrl.path.buyOrderUrl}")
    private String pathaaa;

    public static void main(String[] args) {
        wechatMsg wm = new wechatMsg();
//        wm.SendWeChatMsg(wm.getToken());

        System.out.println(wm.test());
    }

    public String test(){
        String path =pathaaa;
        return path;
    }

    /**
     * 获取token
     * @return token
     */
    public String getToken(){
        //授予形式
        String grant_type = "client_credential";
        String appid = "wxe959611781a45286";
        String secret = "f9aa3fe3d7d134ad0ef76b41b47de4e6";
        //接口地址拼接参数
        String getTokenApi = "https://api.weixin.qq.com/cgi-bin/token?grant_type="+grant_type+"&appid="+appid+"&secret="+secret;

        String tokenJsonStr =  doGetPost(getTokenApi,"GET",null);
        JSONObject tokenJson = JSONObject.parseObject(tokenJsonStr);
        String token = tokenJson.get("access_token").toString();
        System.out.println("获取到的TOKEN : "+token);

        return token;
    }


    /***
     * 发送消息
     * @param token
     */
    public void SendWeChatMsg(String token ){
        //接口地址
        String sendMsgApi = "https://api.weixin.qq.com/cgi-bin/message/templates/send?access_token="+token;
        //openId
        String toUser = "oURX75lPOd95aomwS1cRiDWNYlz8";
        //消息模板ID
        String template_id = "ZYkp2S2ENBHWaZTeOvdgEWzY4FqBwNXVHJAZPNqeimw";
        //String toUrl = "http://weixin.qq.com/download";
        String toUrl = "http://www.baidu.com";

        //整体参数map
        Map<String, Object> paramMap = new HashMap<String, Object>();
        //点击消息跳转相关参数map
        Map<String, String> miniprogramMap = new HashMap<String, String>();
        //消息主题显示相关map
        Map<String, Object> dataMap = new HashMap<String, Object>();

        miniprogramMap.put("appid","");
        miniprogramMap.put("pagepath","");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataMap.put("first",new DataEntity("订单提交成功","#000000"));
        dataMap.put("keyword1",new DataEntity("2342433242","#000000"));
        dataMap.put("keyword2",new DataEntity(simpleDateFormat.format(new Date()),"#000000"));
        dataMap.put("remark",new DataEntity("谢谢您的惠顾","#000000"));


        paramMap.put("touser", toUser);
        paramMap.put("template_id", template_id);
        paramMap.put("url", toUrl);
        paramMap.put("miniprogram", miniprogramMap);
        paramMap.put("data", dataMap);
        System.out.println(doGetPost(sendMsgApi,"POST",paramMap));

    }

    /**
     * 调用接口 post
     * @param apiPath
     */
    public String doGetPost(String apiPath,String type,Map<String,Object> paramMap){

        OutputStreamWriter out = null;
        InputStream is = null;
        String result = null;
        try{
            URL url = new URL(apiPath);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod(type) ; // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();

            if(type.equals("POST")){
                out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
                out.append(JSON.toJSONString(paramMap));
                out.flush();
                out.close();
            }


            // 读取响应
            is = connection.getInputStream();
            int length = (int) connection.getContentLength();// 获取长度
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                result = new String(data, "UTF-8"); // utf-8编码

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  result;
    }




}

