package com.github.jozijug.service.querydsl;

import com.github.jozijug.utils.jta.atomikos.AtomikosJtaConfiguration;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Corneil du Plessis
 */
@Configuration
@ComponentScan("com.github.jozijub")
@Import({ModuleConfig.class, AtomikosJtaConfiguration.class})
public class DataSourceConfig {
    BasicDataSource dataSource;

    public DataSourceConfig() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:data-repositories;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1");
    }

    @Bean
    public DataSource createDataSource() {
        return dataSource;
    }

    @Bean
    public Connection createConnection() throws SQLException {
        return dataSource.getConnection();
    }


    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setJtaDataSource(createDataSource());
        lcemfb.setJpaDialect(new HibernateJpaDialect());
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter());
        lcemfb.setPackagesToScan("com.github.jozijub");
        lcemfb.setPersistenceUnitName("customerdb");
        lcemfb.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        lcemfb.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
        lcemfb.getJpaPropertyMap().put("hibernate.hbm2ddl.format", "false");
        lcemfb.getJpaPropertyMap().put("hibernate.hbm2ddl.export", "true");
        lcemfb.getJpaPropertyMap().put("cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        lcemfb.getJpaPropertyMap().put("hibernate.transaction.jta.platform", "com.github.jozijug.utils.jta.atomikos.AtomikosJtaPlatform");
        lcemfb.afterPropertiesSet();
        return lcemfb.getObject();
    }

    @Bean(name = "entityManager")
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean(name = "jpaVendorAdapter")
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setDatabasePlatform(org.hibernate.dialect.H2Dialect.class.getCanonicalName());
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }
}
