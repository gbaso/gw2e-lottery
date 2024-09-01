package com.github.gbaso.gw2elottery.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@EnableConfigurationProperties(Gw2Properties.class)
@Configuration(proxyBeanMethods = false)
public class AppConfiguration {

}
