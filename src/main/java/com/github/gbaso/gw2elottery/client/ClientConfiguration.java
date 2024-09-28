package com.github.gbaso.gw2elottery.client;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(Gw2Properties.class)
@Configuration(proxyBeanMethods = false)
class ClientConfiguration {}
