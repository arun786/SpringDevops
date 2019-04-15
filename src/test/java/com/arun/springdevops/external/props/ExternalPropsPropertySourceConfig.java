package com.arun.springdevops.external.props;


import com.arun.springdevops.jms.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:testing.properties")
public class ExternalPropsPropertySourceConfig {

    @Value("${guru.jms.server}")
    private String jmsServer;
    @Value("${guru.jms.port}")
    private Integer jmsPort;
    @Value("${guru.jms.user}")
    private String jmsUser;
    @Value("${guru.jms.password}")
    private String jmsPassword;

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUrl(jmsServer);
        fakeJmsBroker.setPort(jmsPort);
        fakeJmsBroker.setUser(jmsUser);
        fakeJmsBroker.setPassword(jmsPassword);
        return fakeJmsBroker;
    }
}
