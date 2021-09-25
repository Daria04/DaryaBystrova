package com.epam.tc.hw9.service;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import java.util.Map.Entry;

public class CommonService {

    private final RequestSpecification requestSpecification;

    public CommonService() {
        enableLoggingOfRequestAndResponseIfValidationFails();
        requestSpecification = new RequestSpecBuilder()
            .setBaseUri(Utils.getBaseUri())
            .addFilter(new RequestLoggingFilter())
            .build();
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification requestSpec = given(requestSpecification);

        for (Entry<String, Object> param : params.entrySet()) {
            requestSpec.param(param.getKey(), param.getValue());
        }

        return requestSpec.get(uri);
    }
}
