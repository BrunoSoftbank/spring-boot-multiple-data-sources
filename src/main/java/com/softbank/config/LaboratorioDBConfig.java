package com.softbank.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		transactionManagerRef = "laboratorioTransactionManager",
        entityManagerFactoryRef = "laboratorioEntityManagerFactory",
        basePackages = { "com.softbank.laboratorio" }
)
public class LaboratorioDBConfig {

    @Primary
    @Bean(name="laboratorioDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "laboratorioDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource laboratorioDataSource(@Qualifier("laboratorioDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "laboratorioEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean laboratorioEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("laboratorioDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.softbank.laboratorio")
                .persistenceUnit("laboratorio")
                .build();
    }

    @Primary
    @Bean(name = "laboratorioTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager laboratorioTransactionManager(@Qualifier("laboratorioEntityManagerFactory") EntityManagerFactory laboratorioEntityManagerFactory) {
        return new JpaTransactionManager(laboratorioEntityManagerFactory);
    }
}
