package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.sige.com.sige.dao")
public class WaterMachineApplication {
    public static void main(String[] args) {
        SpringApplication.run(WaterMachineApplication.class,args);
    }
}
