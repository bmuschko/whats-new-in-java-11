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

public class PostRequestTest {
    public static final String URL_ENDPOINT = "https://postman-echo.com/post";

    @Test
    void canSendSynchronousPostRequestWithoutBody() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_ENDPOINT))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());
        assertEquals(List.of("application/json; charset=utf-8"), response.headers().allValues("content-type"));
        assertTrue(response.body().contains("\"args\":{}"));
        assertTrue(response.body().contains("\"data\":{}"));
    }

    @Test
    void canSendSynchronousPostRequestWithTextPlainBody() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_ENDPOINT))
                .header("Content-Type", "text/plain; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("This is a test"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());
        assertEquals(List.of("application/json; charset=utf-8"), response.headers().allValues("content-type"));
        assertTrue(response.body().contains("\"args\":{}"));
        assertTrue(response.body().contains("\"data\":\"This is a test\""));
    }

    @Test
    void canSendSynchronousPostRequestWithFormUrlEncodedBody() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_ENDPOINT))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString("foo1=bar1&foo2=bar2"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());
        assertEquals(List.of("application/json; charset=utf-8"), response.headers().allValues("content-type"));
        assertTrue(response.body().contains("\"args\":{}"));
        assertTrue(response.body().contains("\"data\":\"\""));
        assertTrue(response.body().contains("\"form\":{\"foo1\":\"bar1\",\"foo2\":\"bar2\"}"));
    }

    @Test
    void canSendSynchronousPostRequestWithJsonBody() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_ENDPOINT))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{ \"foo1\": \"bar1\", \"foo2\": \"bar2\"}"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());
        assertEquals(List.of("application/json; charset=utf-8"), response.headers().allValues("content-type"));
        assertTrue(response.body().contains("\"args\":{}"));
        assertTrue(response.body().contains("\"data\":{\"foo1\":\"bar1\",\"foo2\":\"bar2\"}"));
    }
}
