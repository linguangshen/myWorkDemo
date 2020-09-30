package com.tst.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@ConfigurationProperties(prefix = "spring.datasource.database2")
@Component
@Data
@Table(name = "wm_detail")
public class DataBase2Properties {

    @Id
    private int id;

    @Column(name = "temperature")
    private String temp;

    @Column(name = "thing_name")
    private String thingName;

    private String num;

}