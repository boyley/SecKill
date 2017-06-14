package com.danlu.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by lenovo on 2017/6/14.
 */
@EnableZuulProxy
@SpringCloudApplication
public class GatewayApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayApplication.class).web(true).run(args);
    }
}
