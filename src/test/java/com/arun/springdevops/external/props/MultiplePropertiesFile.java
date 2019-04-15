package com.arun.springdevops.external.props;

import com.arun.springdevops.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({@PropertySource("classpath:testing.properties"), @PropertySource("classpath:encryptedTesting.properties")})
public class MultiplePropertiesFile {
    @Autowired
    private Environment env;

    @Bean
    public FakeJmsBroker setCredentials() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(env.getProperty("guru.jms.server"));
        fakeJmsBroker.setUser(env.getProperty("guru.jms.user"));
        fakeJmsBroker.setPassword(env.getProperty("guru.jms.encrypted.password"));
        fakeJmsBroker.setPort(env.getProperty("guru.jms.port", Integer.class));
        return fakeJmsBroker;
    }
}
