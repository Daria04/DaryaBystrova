package com.epam.tc.hw1.dataprovider;

import org.testng.annotations.DataProvider;

public class DataOperations {

    @DataProvider(name = "testDouble")
    public static Object[][] test2() {
        return new Object[][] {
                {6.5, 7.9},
                {-12.3, -14.75},
                {2.8, -12.5},
                {-12.78, 1.987}
        };
    }

    @DataProvider(name = "testLong")
    public static Object[][] test1() {
        return new Object[][] {
                {65, 79},
                {-123, -1475},
                {2, -125},
                {-152, 1},
        };
    }

}
