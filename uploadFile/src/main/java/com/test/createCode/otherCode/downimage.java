package com.test.createCode.otherCode;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class downimage {

    public BufferedInputStream saveToFile(String destUrl) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
//            fos = new FileOutputStream("D:\\haha.png");
//            while ((size = bis.read(buf)) != -1) {
//                fos.write(buf, 0, size);
//            }
//            fos.flush();
            return bis;
        } catch (Exception e) {
        }  finally {
            try {
                fos.close();
                bis.close();
                httpUrl.disconnect();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        // TODO Auto-generated method stub

        downimage dw = new downimage();
        dw.saveToFile("https://m9cool.oss-cn-shenzhen.aliyuncs.com/2020/08/c8a674222db948eb8e0a456d9b0410e8.jpg");

    }
}