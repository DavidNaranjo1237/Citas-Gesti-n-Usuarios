package com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

public class PropiedadesJwt {

    @Configuration
    @ConfigurationProperties(prefix = "jwt")
    public class JwtProperties {
        private String secret;
        private int expiration;

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public int getExpiration() {
            return expiration;
        }

        public void setExpiration(int expiration) {
            this.expiration = expiration;
        }

    }
}
