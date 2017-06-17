package com.danlu.user;

import com.danlu.user.config.AuthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lenovo on 2017/6/18.
 */
@Configuration
@EnableConfigurationProperties({AuthProperties.class})
public class AuthApplication {
}
