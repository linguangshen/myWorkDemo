package com.tst.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ConfigurationProperties(prefix = "spring.datasource.database1")
@Component
@Data
@Table(name = "tz_app_connect")
public class DataBase1Properties {
    @Id
    private int id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "biz_user_id")
    private String bizUserId;
}