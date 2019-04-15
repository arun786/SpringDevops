package com.arun.springdevops.external.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "guru.jms")
@PropertySource("classpath:testing.properties")
@Getter
@Setter
public class PropertySourceConfig {
    private String server;
    private String port;
    private String user;
    private String password;
}
