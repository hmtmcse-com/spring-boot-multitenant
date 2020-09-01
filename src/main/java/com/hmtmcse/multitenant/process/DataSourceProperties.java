package com.hmtmcse.multitenant.process;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "tenants")
public class DataSourceProperties {

    private Map<Object, Object> dataSources = new LinkedHashMap<>();

    public Map<Object, Object> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Map<String, Map<String, String>> dataSources) {
        dataSources.forEach((key, value) -> this.dataSources.put(key, convert(value)));
    }

    public DataSource convert(Map<String, String> source) {
//        HikariDataSource dataSource = new HikariDataSource();
//
//        dataSource.setInitializationFailTimeout(0);
//        dataSource.setMaximumPoolSize(5);
//        dataSource.setDataSourceClassName(source.get("driverClassName"));
//        dataSource.addDataSourceProperty("url", source.get("jdbcUrl"));
//        dataSource.addDataSourceProperty("user", source.get("username"));
//        dataSource.addDataSourceProperty("password", source.get("password"));


        return DataSourceBuilder.create()
                .url(source.get("jdbcUrl"))
                .driverClassName(source.get("driverClassName"))
                .username(source.get("username"))
                .password(source.get("password"))
                .build();
    }
}
