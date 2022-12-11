package com.github.gbaso.gw2elottery.config;

import javax.sql.DataSource;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.DatabaseStartupValidator;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableConfigurationProperties(Gw2Properties.class)
@Configuration
public class AppConfiguration {

	@Bean
	DatabaseStartupValidator databaseStartupValidator(DataSource dataSource) {
		var validator = new DatabaseStartupValidator();
		validator.setDataSource(dataSource);
		return validator;
	}

	@Bean
	static BeanFactoryPostProcessor dependsOnPostProcessor() {
		return bf -> {
			String[] beanNames = bf.getBeanNamesForType(EntityManagerFactory.class);
			for (String beanName : beanNames) {
				var beanDefinition = bf.getBeanDefinition(beanName);
				beanDefinition.setDependsOn("databaseStartupValidator");
			}
		};
	}

}
