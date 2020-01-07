package com.kd.core.resource.external;

import com.kd.core.util.PropertiesUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author: latham
 * @Date: 2020/1/3 23:23
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    private final String corsOrigins = PropertiesUtil.readValue("service.corsOrigin");

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(corsOrigins, "null")
                .allowedMethods("POST", "GET", "OPTIONS")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
