package com.epam.tc.hw9.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    private static String BASE_URI;

    public static String getBaseUri() {
        return BASE_URI;
    }

    static {

        readCreds();
    }

    public static void readCreds() {
        try (InputStream input = new FileInputStream("src/test/resources/yandex_speller/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            BASE_URI = prop.getProperty("base_uri");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
