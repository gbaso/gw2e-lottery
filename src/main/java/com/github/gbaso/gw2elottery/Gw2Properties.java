package com.github.gbaso.gw2elottery;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("gw2")
public class Gw2Properties {

    private Api api = new Api();

    @Data
    public static class Api {
        private String version;
    }

}
