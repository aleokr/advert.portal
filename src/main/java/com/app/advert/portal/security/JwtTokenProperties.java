package com.app.advert.portal.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "security.jwt")
@Component
@Data
public class JwtTokenProperties {

    private String secretKey;

    private Long expirationTime;

    private Long refreshExpirationTime;
}
