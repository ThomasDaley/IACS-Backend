package com.moncyja.iacs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.moncyja.iacs.dao")
public class IacsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IacsBackendApplication.class, args);
    }

}

