package com.todolist.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.todolist.dao.TaskDao;
import com.todolist.dao.TaskDaoImpl;

@Configuration
@ComponentScan(basePackages="com.todolist")
@PropertySource("classpath:/properties/database.properties")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Value("${db.drivername}")
	private String dbDriver;
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.username}")
	private String userName;
	
	@Value("${db.password}")
	private String password;

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbDriver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public TaskDao getContactDAO() {
		return new TaskDaoImpl(getDataSource());
	}
}
