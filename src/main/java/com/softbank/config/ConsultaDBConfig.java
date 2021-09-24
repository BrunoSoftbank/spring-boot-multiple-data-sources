package com.softbank.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ConsultaDBConfig {
	
	@Bean("consultaDataSource")
    @ConfigurationProperties(prefix="consulta.datasource")
    public DataSource consultaDataSource() {
        return DataSourceBuilder.create().build();
    }
	
	@Bean("consultaDataSourceJDBC")
    public JdbcTemplate jdbcTemplatePortfolio(@Qualifier("consultaDataSource") DataSource dataSource) {
    	return new JdbcTemplate(dataSource);
    }

}
