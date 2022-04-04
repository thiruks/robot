package com.robot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("file:./application.properties")
public class Properties {

    @Value("${survivor.resources}")
    private String sResources;

    @Value("${robot.url}")
    private String rUrl;

    @Value("${robot.sort.key}")
    private String sortKey;

    public String getsResources() {
        return sResources;
    }

    public String getrUrl() {
        return rUrl;
    }

    public String getSortKey() {
        return sortKey;
    }
}
