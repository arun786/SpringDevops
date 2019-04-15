package com.arun.springdevops.jms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeJmsBroker {
    private String url;
    private Integer port;
    private String user;
    private String password;
}
