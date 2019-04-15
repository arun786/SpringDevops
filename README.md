# Spring Dev ops

## Read Properties file in Spring boot

1. PropertySourcesPlaceholderConfigurer

    
    
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


2. Environment

    
        package com.arun.springdevops.external.props;
        
        import com.arun.springdevops.jms.FakeJmsBroker;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.PropertySource;
        import org.springframework.core.env.Environment;
        
        @Configuration
        @PropertySource("classpath:testing.properties")
        public class ExternalPropertiesEnvironment {
        
            /**
             * When we are using Environment we don't need to use PropertySourcesPlaceHolderConfigurer
             */
            @Autowired
            private Environment env;
        
            @Bean
            public FakeJmsBroker fakeJmsBroker() {
                FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
                fakeJmsBroker.setUrl(env.getProperty("guru.jms.server"));
                fakeJmsBroker.setPort(env.getProperty("guru.jms.port", Integer.class));
                fakeJmsBroker.setUser(env.getProperty("guru.jms.user"));
                fakeJmsBroker.setPassword(env.getProperty("guru.jms.password"));
                return fakeJmsBroker;
            }
        }


## Multiple Properties

    
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
