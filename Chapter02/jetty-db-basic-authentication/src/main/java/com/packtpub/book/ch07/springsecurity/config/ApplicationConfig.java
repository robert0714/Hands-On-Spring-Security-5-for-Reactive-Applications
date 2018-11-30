package com.packtpub.book.ch07.springsecurity.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource(value = {"classpath:mysqldb.properties","classpath:h2.properties"})
public class ApplicationConfig {

    @Autowired
    private Environment env;

//    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("mysql.driver"));
        dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
        dataSource.setUsername(env.getProperty("mysql.username"));
        dataSource.setPassword(env.getProperty("mysql.password"));
        return dataSource;
    }
    @Bean
    public DataSource getH2DataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
//        dataSource.setUrl(env.getProperty("spring.datasource.url"));
//        dataSource.setUsername(env.getProperty("spring.datasource.username"));
//        dataSource.setPassword(env.getProperty("spring.datasource.password"));
//        return dataSource;
        final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        final DataSource database = builder.setType(EmbeddedDatabaseType.H2)
                .setName("dataSource")                
                .ignoreFailedDrops(true)
                .continueOnError(false)
                .addScript("classpath:database/h2/spring_security-schema.sql") 
                .addScript("classpath:database/h2/spring_security-data.sql") 
                .build();
        return database;
    }
}
