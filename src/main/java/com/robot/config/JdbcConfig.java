package com.robot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Primary
    @Bean(name = "dSRobot")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSourceDbIrr() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcRobot")
    public JdbcTemplate jdbcTemplateIrr(@Qualifier("dSRobot") DataSource dSRobot) {
        return new JdbcTemplate(dSRobot);
    }
}
