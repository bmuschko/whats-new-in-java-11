package com.bmuschko.java11.httpclient;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteRequestTest {
    public static final String URL_ENDPOINT = "https://postman-echo.com/delete";

    @Test
    void canSendSynchronousPutRequest() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_ENDPOINT))
                .DELETE()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());
        assertEquals(List.of("application/json; charset=utf-8"), response.headers().allValues("content-type"));
        assertTrue(response.body().contains("\"args\":{}"));
        assertTrue(response.body().contains("\"data\":{}"));
    }
}
