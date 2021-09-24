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
		transactionManagerRef = "exameTransactionManager",
        entityManagerFactoryRef = "exameEntityManagerFactory",
        basePackages = { "com.softbank.exame" }
)
public class ExameDBConfig {

    @Primary
    @Bean(name="exameDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "exameDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource exameDataSource(@Qualifier("exameDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "exameEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean exameEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("exameDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.softbank.exame")
                .persistenceUnit("exame")
                .build();
    }

    @Primary
    @Bean(name = "exameTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager exameTransactionManager(@Qualifier("exameEntityManagerFactory") EntityManagerFactory exameEntityManagerFactory) {
        return new JpaTransactionManager(exameEntityManagerFactory);
    }
}
