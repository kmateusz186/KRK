package com.capgemini.krk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MultiDbConfiguration {

    @Autowired
    private DataSourceProperties properties;

    @Bean
    @ConfigurationProperties(
            prefix = "spring.datasource"
    )
    public DataSource dataSource() {
        Map<Object,Object> resolvedDataSources = new HashMap<>();

        DataSourceBuilder dataSourceBuilder1 = new DataSourceBuilder(this.getClass().getClassLoader());
        dataSourceBuilder1.driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/krkdb?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .username("root")
                .password("ROOT");

        resolvedDataSources.put(DbContextEnum.DB1, dataSourceBuilder1.build());

        DataSourceBuilder dataSourceBuilder2 = new DataSourceBuilder(this.getClass().getClassLoader());
        dataSourceBuilder2.driverClassName("com.mysql.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/krkdb2?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC")
                .username("root")
                .password("ROOT");

        resolvedDataSources.put(DbContextEnum.DB2, dataSourceBuilder2.build());

        MultiDbDataSource dataSource = new MultiDbDataSource();
        dataSource.setDefaultTargetDataSource(defaultDataSource());
        dataSource.setTargetDataSources(resolvedDataSources);

        dataSource.afterPropertiesSet();

        return dataSource;
    }

    private DataSource defaultDataSource() {
        DataSourceBuilder dataSourceBuilder = new DataSourceBuilder(this.getClass().getClassLoader())
                .driverClassName(properties.getDriverClassName())
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword());

        if(properties.getType() != null) {
            dataSourceBuilder.type(properties.getType());
        }

        return dataSourceBuilder.build();
    }
}