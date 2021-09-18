package com.epam.tc.hw9.service;

import static org.hamcrest.Matchers.lessThan;

import com.epam.tc.hw9.dto.BoardDto;
import com.epam.tc.hw9.dto.CardDto;
import com.epam.tc.hw9.dto.ListDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpStatus;

public class TrelloServiceObject {

    private final Method requestMethod;
    private final Map<String, String> parameters;

    private TrelloServiceObject(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {

        private final Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            this.requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setName(String name) {
            parameters.put("name", name);
            return this;
        }

        public ApiRequestBuilder setListName(String listName) {
            parameters.put("name", listName);
            return this;
        }

        public ApiRequestBuilder setBoardId(String idBoard) {
            parameters.put("idBoard", idBoard);
            return this;
        }

        public ApiRequestBuilder setCardName(String cardName) {
            parameters.put("name", cardName);
            return this;
        }

        public ApiRequestBuilder setListId(String idList) {
            parameters.put("idList", idList);
            return this;
        }

        public TrelloServiceObject buildRequest() {
            return new TrelloServiceObject(parameters, requestMethod);
        }
    }

    public Response sendRequest(String basePath) {
        return RestAssured
            .given(requestSpec()).log().all()
            .queryParam("key", Utils.API_KEY)
            .queryParam("token", Utils.TOKEN)
            .queryParams(parameters)
            .request(requestMethod, Utils.BASE_URI + basePath)
            .prettyPeek();
    }

    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification correctResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static BoardDto getBoardFromResponse(Response response) {
        return new Gson()
                .fromJson(response.asString().trim(), new TypeToken<BoardDto>(){}.getType());
    }

    public static ListDto getListFromResponse(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<ListDto>(){}.getType());
    }

    public static CardDto getCardFromResponse(Response response) {
        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<CardDto>(){}.getType());
    }
}
