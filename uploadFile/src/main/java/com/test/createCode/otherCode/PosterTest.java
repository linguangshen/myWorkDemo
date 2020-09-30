package com.test.createCode.otherCode;

import com.quaint.poster.core.impl.PosterDefaultImpl;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;

/**
 * @author Holger_Wei
 * @data 2020/9/14 0014
 */

public class PosterTest {

    public static void main(String[] args) throws Exception{
        downimage downimage = new downimage();
        BufferedInputStream bufferedInputStream = downimage.saveToFile("https://m9cool.oss-cn-shenzhen.aliyuncs.com/2020/08/c8a674222db948eb8e0a456d9b0410e8.jpg");


        // 测试注解, 这里读取图片如果不成功，请查看target 或者 out 目录下是否加载了资源。 如需使用，请引入spring core依赖
        BufferedImage background = ImageIO.read(new ClassPathResource("image/1.png").getInputStream());
        BufferedImage head = ImageIO.read(new ClassPathResource("image/test.jpg").getInputStream());
        BufferedImage mainImage = ImageIO.read(bufferedInputStream);
        SamplePoster poster = SamplePoster.builder()
                .backgroundImage(background)
                .head(head)
                .nickName("微信扫一扫即可购买")
                .slogan("拉法奇米拉")
                .mainImage(mainImage)
                .build();
        PosterDefaultImpl<SamplePoster> impl = new PosterDefaultImpl<>();
        BufferedImage test = impl.annotationDrawPoster(poster).draw(null);
        ImageIO.write(test,"png",new FileOutputStream("annTest.png"));

    }




}
