package com.github.gbaso.gw2elottery.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("gw2")
record Gw2Properties(Api api) {

    record Api(String version) {}

}
