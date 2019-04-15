package com.arun.springdevops.test.external.props;

import com.arun.springdevops.external.props.ExternalPropertiesEnvironment;
import com.arun.springdevops.jms.FakeJmsBroker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExternalPropertiesEnvironment.class})
public class ExternalPropertiesEnvTest {

    @Autowired
    private FakeJmsBroker fakeJmsBroker;

    private String server = "10.10.1.2";
    private Integer port = 2303;
    private String user = "Ron";
    private String password = "Burgundy";

    @Test
    public void testEnvProperties() {
        assertEquals(server, fakeJmsBroker.getUrl());
        assertEquals(port, fakeJmsBroker.getPort());
        assertEquals(user, fakeJmsBroker.getUser());
        assertEquals(password, fakeJmsBroker.getPassword());
    }
}
