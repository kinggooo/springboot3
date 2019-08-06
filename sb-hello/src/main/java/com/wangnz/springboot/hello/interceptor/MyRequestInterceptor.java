package com.wangnz.springboot.hello.interceptor;

import com.wangnz.springboot.hello.controller.Test1Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class MyRequestInterceptor implements ClientHttpRequestInterceptor {
    private static Logger log = LoggerFactory.getLogger(MyRequestInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        traceRequest(request, bytes);

        ClientHttpResponse response = execution.execute(request, bytes);
        ClientHttpResponse responseCopy = new BufferingClientHttpResponseWrapper(response);

        traceResponse(responseCopy);

        return responseCopy;


    }

    /**
     * 打印请求数据
     *
     * @param request 请求
     * @param bytes   请求体
     */
    private void traceRequest(HttpRequest request, byte[] bytes) {
        HttpMethod method = request.getMethod();
        URI uri = request.getURI();
        String path = uri.getPath();
        String query = uri.getQuery();
        String body = new String(bytes, StandardCharsets.UTF_8);
        log.info("Request URL = [{}] {}?{}", method, path, query);
        log.info("Request Body = {}", body);
    }

    /**
     * 打印响应结果
     *
     * @param response 响应结果
     * @throws IOException io
     */
    private void traceResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(response.getBody(), StandardCharsets.UTF_8))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                inputStringBuilder.append(line);
                // inputStringBuilder.append('\n');
                line = bufferedReader.readLine();
            }
        }
        log.info("Response : {} {}", response.getStatusCode(), response.getStatusText());
        log.info("Response Body: {}", inputStringBuilder.toString());
    }

}
