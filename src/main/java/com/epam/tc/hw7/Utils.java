package com.epam.tc.hw7;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static String JSON_PATH;

    static {
        readCreds();
    }

    public static void readCreds() {
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            JSON_PATH = prop.getProperty("json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
