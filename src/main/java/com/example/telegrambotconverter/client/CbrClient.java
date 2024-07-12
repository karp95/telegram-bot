package com.example.telegrambotconverter.client;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CbrClient {
    @Autowired
    OkHttpClient client;
    @Value("${crb.url}")
    private String cbrUrl;

    public String getCurrencyRateXML() throws IOException {
        var request = new Request.Builder()
                .url(cbrUrl)
                .build();

        var response = client.newCall(request).execute();
        var body = response.body();
        return body == null ? null : body.string();
    }
}
