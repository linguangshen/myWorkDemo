package com.test.createCode.otherCode;

import com.quaint.poster.annotation.PosterBackground;
import com.quaint.poster.annotation.PosterFontCss;
import com.quaint.poster.annotation.PosterImageCss;
import com.quaint.poster.core.abst.AbstractDefaultPoster;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Tolerate;

import java.awt.image.BufferedImage;

/**
 * @author Holger_Wei
 * @data 2020/9/14 0014
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class SamplePoster extends AbstractDefaultPoster {

    /**
     * 背景图
     */
    @PosterBackground(width = 800,height = 1200)
    private BufferedImage backgroundImage;

    /**
     * 头像
     */
    @PosterImageCss(position = {550,930},width = 200, height = 200, circle = true)
    private BufferedImage head;

    /**
     * 昵称
     */
    @PosterFontCss(position = {569,1150}, center = true, color = {0,0,0})
    private String nickName;

    /**
     * 广告语
     */
    @PosterFontCss(position = {20,1030},center = true, size = 45, color = {0,0,2}, canNewLine={1,221,30})
    private String slogan;

    /**
     * 主图
     */
    @PosterImageCss(position = {0,0},width = 800,height = 900)
    private BufferedImage mainImage;

    @Tolerate
    public SamplePoster() {}
}
