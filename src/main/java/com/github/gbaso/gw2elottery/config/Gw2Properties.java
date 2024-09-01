package com.github.gbaso.gw2elottery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("gw2")
public record Gw2Properties(Api api) {

    public record Api(String version) {}

}
