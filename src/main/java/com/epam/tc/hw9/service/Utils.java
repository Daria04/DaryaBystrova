package com.epam.tc.hw9.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static String BASE_URI;
    public static String API_KEY;
    public static String TOKEN;
    public static String BOARD_NAME;
    public static String LIST_NAME;
    public static String CARD_NAME;
    public static String NEW_CARD_NAME;

    static {

        readCreds();
    }

    public static void readCreds() {
        try (InputStream input = new FileInputStream("src/test/resources/trello/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            BASE_URI = prop.getProperty("base_uri");
            API_KEY = prop.getProperty("key");
            TOKEN = prop.getProperty("token");
            BOARD_NAME = prop.getProperty("boardName");
            LIST_NAME = prop.getProperty("listName");
            CARD_NAME = prop.getProperty("cardName");
            NEW_CARD_NAME = prop.getProperty("newCardName");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
