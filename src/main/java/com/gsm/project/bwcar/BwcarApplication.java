package com.gsm.project.bwcar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.gsm.project.bwcar.dao")
@ServletComponentScan(basePackages="com.gsm.project.bwcar.config")
public class BwcarApplication {
    public static void main(String[] args) {
        SpringApplication.run(BwcarApplication.class, args);
    }

}
