package com.danlu.seckill;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by lenovo on 2017/6/11.
 */
@EnableEurekaServer
@SpringBootApplication
public class ApplicationEurekaServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ApplicationEurekaServer.class).web(true).run(args);
    }
}
