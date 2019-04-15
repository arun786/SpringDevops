package com.arun.springdevops.test.external.props;


import com.arun.springdevops.external.props.ExternalPropsPropertySourceConfig;
import com.arun.springdevops.external.props.PropertySourceConfig;
import com.arun.springdevops.jms.FakeJmsBroker;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExternalPropsPropertySourceConfig.class, PropertySourceConfig.class})
public class PropertySourceTest {

    @Autowired
    private FakeJmsBroker fakeJmsBroker;
    @Autowired
    private PropertySourceConfig propertySourceConfig;

    private String server = "10.10.1.2";
    private Integer port = 2303;
    private String user = "Ron";
    private String password = "Burgundy";


    @Test
    public void testJMSProperty() {

        assertEquals(server, fakeJmsBroker.getUrl());
        assertEquals(port, fakeJmsBroker.getPort());
        assertEquals(user, fakeJmsBroker.getUser());
        assertEquals(password, fakeJmsBroker.getPassword());
    }

    @Ignore
    @Test
    public void testProperSourceConfig() {
        assertEquals(server, propertySourceConfig.getServer());
        assertEquals(port, propertySourceConfig.getPort());
        assertEquals(user, propertySourceConfig.getUser());
        assertEquals(password, propertySourceConfig.getPassword());
    }

}
