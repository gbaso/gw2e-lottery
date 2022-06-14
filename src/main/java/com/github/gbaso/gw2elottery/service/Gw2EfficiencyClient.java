package com.github.gbaso.gw2elottery.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class Gw2EfficiencyClient {

    private final OkHttpClient client = new OkHttpClient();
    private final HttpUrl baseUrl = HttpUrl.get("https://api.gw2efficiency.com");

    Response execute(String path, Map<String, String> params) throws IOException {
        var builder = baseUrl.newBuilder()
                .addPathSegments(path);
        params.entrySet().forEach(e -> builder.addQueryParameter(e.getKey(), e.getValue()));
        Request request = new Request.Builder().get().url(builder.build()).build();
        return client.newCall(request).execute();
    }

}
