package com.epam.tc.hw1.pow.operations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.dataprovider.DataOperations;
import org.testng.annotations.Test;

public class Powering {

    private final Calculator calculator = new Calculator();

    @Test(groups = {"secondGroup"}, dataProvider = "testDouble", dataProviderClass = DataOperations.class)
    public void powOfDoubleNumbersTest(double x, double y) {
        double actual = calculator.pow(x, y);
        double expected = Math.pow(x, Math.floor(y));
        assertThat(actual).isEqualTo(expected);


    }
}
