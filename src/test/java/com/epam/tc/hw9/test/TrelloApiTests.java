package com.epam.tc.hw9.test;

import static com.epam.tc.hw9.service.TrelloServiceObject.correctResponseSpecification;
import static com.epam.tc.hw9.service.TrelloServiceObject.getBoardFromResponse;
import static com.epam.tc.hw9.service.TrelloServiceObject.getCardFromResponse;
import static com.epam.tc.hw9.service.TrelloServiceObject.getListFromResponse;
import static com.epam.tc.hw9.service.TrelloServiceObject.requestBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import com.epam.tc.hw9.constants.URI;
import com.epam.tc.hw9.dto.BoardDto;
import com.epam.tc.hw9.dto.CardDto;
import com.epam.tc.hw9.dto.ListDto;
import com.epam.tc.hw9.service.Utils;
import io.restassured.http.Method;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TrelloApiTests {

    private BoardDto newBoard;
    private ListDto newList;
    private CardDto newCard;

    @Test
    public void createABoardTest() {
        newBoard = getBoardFromResponse(requestBuilder()
            .setMethod(Method.POST)
            .setName(Utils.BOARD_NAME)
            .buildRequest().sendRequest(URI.BOARD_ENDPOINT)
            .then().assertThat()
            .spec(correctResponseSpecification())
            .extract().response());

        assertThat("Incorrect name of the Board", newBoard.getName().equals(Utils.BOARD_NAME));
    }

    @Test(dependsOnMethods = "createABoardTest")
    public void getABoardTest() {
        BoardDto boardFromResponse = getBoardFromResponse(requestBuilder()
            .buildRequest().sendRequest(URI.BOARD_ENDPOINT + newBoard.getId())
            .then().assertThat()
            .spec(correctResponseSpecification())
            .extract().response());

        assertThat("There is mismatch between Board from response and actual Board",
            boardFromResponse.equals(newBoard));
        assertThat("Board id has invalid value", boardFromResponse, Matchers.hasProperty("id",
            notNullValue()));
    }

    @Test(dependsOnMethods = "createABoardTest")
    public void createAListTest() {
        newList = getListFromResponse(requestBuilder()
            .setMethod(Method.POST)
            .setListName(Utils.LIST_NAME)
            .setBoardId(newBoard.getId())
            .buildRequest().sendRequest(URI.LIST_ENDPOINT));

        assertThat("Incorrect name of the List", newList.getName().equals(Utils.LIST_NAME));
    }

    @Test(dependsOnMethods = {"createABoardTest", "createAListTest"})
    public void createACardTest() {
        newCard = getCardFromResponse(requestBuilder()
            .setMethod(Method.POST)
            .setCardName(Utils.CARD_NAME)
            .setListId(newList.getId())
            .buildRequest().sendRequest(URI.CARD_ENDPOINT));

        assertThat("Incorrect name of the Card", newCard, Matchers.hasProperty("name",
            equalTo(Utils.CARD_NAME)));
    }

    @Test(dependsOnMethods = {"createABoardTest", "createAListTest", "createACardTest"})
    public void updateACardTest() {
        CardDto cardFromResponse = getCardFromResponse(requestBuilder()
            .setMethod(Method.PUT)
            .setName(Utils.NEW_CARD_NAME)
            .buildRequest().sendRequest(URI.CARD_ENDPOINT + newCard.getId()));

        assertThat("The name of the Card wasn't changed", cardFromResponse,
            Matchers.hasProperty("name", equalTo(Utils.NEW_CARD_NAME)));
    }

    @Test(dependsOnMethods = "createABoardTest", priority = 6)
    public void deleteABoardTest() {
        requestBuilder()
            .setMethod(Method.DELETE)
            .buildRequest().sendRequest(URI.BOARD_ENDPOINT + newBoard.getId())
            .then().assertThat()
            .spec(correctResponseSpecification());
    }

}
