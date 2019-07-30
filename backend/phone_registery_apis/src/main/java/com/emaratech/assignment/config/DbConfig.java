package com.emaratech.assignment.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.apache.commons.dbcp2.BasicDataSource;
@Configuration
public class DbConfig {

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${spring.datasource.url}")
	private String jdbcURL;
	@Bean
	public DataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(jdbcURL);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
//	@Bean
//	public DataSource dataSourceScript(){
//		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
//		return embeddedDatabaseBuilder
//				.addScript("classpath:org/springframework/batch/core/schema-h2.sql")
//				.setType(EmbeddedDatabaseType.H2)
//				.build();
//	}
//	
	
}

