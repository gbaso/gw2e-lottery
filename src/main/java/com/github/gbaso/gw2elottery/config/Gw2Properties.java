package com.github.gbaso.gw2elottery.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("gw2")
public record Gw2Properties(Gw2Properties.Api api) {

    public static record Api(String version) {}

}
