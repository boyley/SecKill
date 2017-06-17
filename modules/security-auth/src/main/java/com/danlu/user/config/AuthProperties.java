package com.danlu.user.config;

import com.sun.istack.internal.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lenovo on 2017/6/15.
 */
@ConfigurationProperties(prefix = "auth", ignoreUnknownFields = false)
public class AuthProperties {

    private final Security security = new Security();

    public Security getSecurity() {
        return security;
    }

    public static class Security {

        private final RememberMe rememberMe = new RememberMe();

        public RememberMe getRememberMe() {
            return rememberMe;
        }

        public static class RememberMe {

            @NotNull
            private String key;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }
}
