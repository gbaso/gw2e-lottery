package com.github.gbaso.gw2elottery.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.gbaso.gw2elottery.Gw2Properties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
@Service
@RequiredArgsConstructor
public class Gw2EfficiencyClient {

    private final OkHttpClient  client  = new OkHttpClient();
    private final HttpUrl       baseUrl = HttpUrl.get("https://api.gw2efficiency.com");

    private final Gw2Properties properties;

    Response get(String path, Map<String, String> params) throws IOException {
        HttpUrl httpUrl = buildUrl(path, params);
        Request getRequest = new Request.Builder().get().url(httpUrl).build();
        Response response = execute(getRequest);
        if (!response.isSuccessful()) {
            if (log.isDebugEnabled()) {
                try (var body = response.body()) {
                    log.debug("Error body: {}", body.string());
                }
            }
            throw new IOException("request to " + httpUrl + " failed: " + response.code() + " " + response.message());
        }
        return response;
    }

    private HttpUrl buildUrl(String path, Map<String, String> params) {
        var builder = baseUrl.newBuilder()
                .addPathSegments(path)
                .addQueryParameter("v", properties.getApi().getVersion());
        params.entrySet().forEach(e -> builder.addQueryParameter(e.getKey(), e.getValue()));
        return builder.build();
    }

    private Response execute(Request request) throws IOException {
        return client.newCall(request).execute();
    }

}
