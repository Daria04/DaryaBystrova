package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public Calculator calculator = new Calculator();

    @BeforeTest
    public void before() {
        calculator = new Calculator();
    }

    @AfterTest
    public void after() {
        calculator = null;
    }
}
