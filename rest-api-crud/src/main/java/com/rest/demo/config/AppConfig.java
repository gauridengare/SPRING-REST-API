package com.rest.demo.config;

import java.beans.PropertyVetoException;

import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.rest.demo")
@PropertySource({ "classpath:mysql.properties" })
public class AppConfig implements WebMvcConfigurer {

	// properties from properties file are added to this Spring Environment
	@Autowired
	private Environment e;

	@Bean
	public DataSource myDataSource() {
		MysqlDataSource sql = null;
		sql = new MysqlDataSource();
		sql.setUrl(e.getProperty("jdbc.url"));
		sql.setUser(e.getProperty("jdbc.user"));
		sql.setPassword(e.getProperty("jdbc.password"));
		return sql;
	}

	private Properties getHibernateProperties() {
// set hibernate properties
		Properties props = new Properties();
		// properties class represents a persistent set of properties. The Properties
		// can be saved to a stream
		// Properties class inherits from Hashtable
		// setProperty - associate value with a key
		props.setProperty("hibernate.dialect", e.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", e.getProperty("hibernate.show_sql"));
		return props;
	}

	// read environment property and convert to int
	private int getIntProperty(String propertyName) {
		String propValue = e.getProperty(propertyName);
		// now convert to int
		int intProp = Integer.parseInt(propValue);
		return intProp;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
// create session factory
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(e.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
// setup transaction manager based on session factory
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(sessionFactory);
		return tx;
	}

}
