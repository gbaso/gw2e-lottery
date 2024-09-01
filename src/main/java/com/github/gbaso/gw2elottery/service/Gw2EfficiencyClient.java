package com.github.gbaso.gw2elottery.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.ResponseSpec;

import com.github.gbaso.gw2elottery.config.Gw2Properties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class Gw2EfficiencyClient {

    private final RestClient client = RestClient.create("https://api.gw2efficiency.com");

    private final Gw2Properties properties;

    ResponseSpec get(String path, Map<String, String> params) {
        Map<String, List<String>> multiValueParam = params
                .entrySet()
                .stream()
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, e -> List.of(e.getValue())));
        return getMultivalue(path, multiValueParam);
    }

    ResponseSpec getMultivalue(String path, Map<String, List<String>> params) {
        String apiVersion = properties.api().version();
        return client
                .get()
                .uri(uri -> uri
                        .path(path)
                        .queryParam("v", apiVersion)
                        .queryParams(new LinkedMultiValueMap<>(params))
                        .build())
                .retrieve();
    }

}
