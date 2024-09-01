package com.github.gbaso.gw2elottery.enterer;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration(proxyBeanMethods = false)
@EnableScheduling
class SchedulerConfiguration {}
