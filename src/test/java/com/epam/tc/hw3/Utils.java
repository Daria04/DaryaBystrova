package com.epam.tc.hw3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static String URL;
    public static String LOGIN;
    public static String PASSWORD;

    static {

        readCreds();
    }

    public static void readCreds() {

        try (InputStream input = new FileInputStream("src/test/resources/data.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            URL = prop.getProperty("URL");
            LOGIN = prop.getProperty("login");
            PASSWORD = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
