package com.xxx.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//Eureka client是客户端API，用来注册服务到Eureka server。
@SpringBootApplication
//@EnableDiscoveryClient   //Eureka客户端
public class JwtServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtServerApplication.class, args);
    }

}

