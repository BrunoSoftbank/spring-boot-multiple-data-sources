package com.softbank.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class LaboratorioDBConfig {

	@Bean("laboratorioDataSource")
    @ConfigurationProperties(prefix="laboratorio.datasource")
    public DataSource laboratorioDataSource() {
        return DataSourceBuilder.create().build();
    }
	
	@Bean("laboratorioDataSourceJDBC")
    public JdbcTemplate jdbcTemplatePortfolio(@Qualifier("laboratorioDataSource") DataSource dataSource) {
    	return new JdbcTemplate(dataSource);
    }
}
