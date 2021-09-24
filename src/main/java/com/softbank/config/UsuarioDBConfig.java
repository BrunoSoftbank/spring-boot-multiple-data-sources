package com.softbank.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "usuarioTransactionManager",
        entityManagerFactoryRef = "usuarioEntityManagerFactory",
        basePackages = { "com.softbank.usuario" }
)
public class UsuarioDBConfig {
	
    @Bean(name="usuarioDataSourceProperties")
    @ConfigurationProperties("usuario.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean(name = "usuarioDataSource")
    @ConfigurationProperties("usuario.datasource")
    public DataSource dataSource(@Qualifier("usuarioDataSourceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "usuarioEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean usuarioEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("usuarioDataSource") DataSource usuarioDataSource) {
        return builder.dataSource(usuarioDataSource).packages("com.softbank.usuario").persistenceUnit("usuario").build();
    }

    @Bean(name = "usuarioTransactionManager")
    @ConfigurationProperties("usuario.jpa")
    public PlatformTransactionManager usuarioTransactionManager(@Qualifier("usuarioEntityManagerFactory") EntityManagerFactory usuarioEntityManagerFactory) {
        return new JpaTransactionManager(usuarioEntityManagerFactory);
    }
}