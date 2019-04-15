package com.arun.springdevops;

import com.arun.springdevops.external.props.PropertySourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties(PropertySourceConfig.class)
public class SpringdevopsApplicationTests {

    @Test
    public void contextLoads() {
    }

}
