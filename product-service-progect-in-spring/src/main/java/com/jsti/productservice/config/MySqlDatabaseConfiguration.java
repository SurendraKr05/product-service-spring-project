package com.jsti.productservice.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
@Configuration
public class MySqlDatabaseConfiguration {
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan("com.jsti.productservice.entity");
		sessionFactory.setHibernateProperties(getProperties());
		return sessionFactory;	
	}
	
	@Bean
	public DataSource getDataSource(){	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();	
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/database_jsti");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		return dataSource;
		}
	@Bean
	public Properties getProperties() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

}
