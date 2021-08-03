package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.dataprovider.DataOperations;
import org.testng.annotations.Test;

public class AddOperations {

    private final Calculator calculator = new Calculator();

    @Test(groups = {"firstGroup"}, dataProvider = "testLong", dataProviderClass = DataOperations.class)
    public void addOfLongNumbersTest(long x, long y) {
        long actual = calculator.sum(x, y);
        long expected = x + y;
        assertThat(actual).isEqualTo(expected);
    }

    @Test(groups = {"firstGroup"}, dataProvider = "testDouble", dataProviderClass = DataOperations.class)
    public void addOfDoubleNumbersTest(double x, double y) {
        double actual = calculator.sum(x, y);
        double expected = x + y;
        assertThat(actual).isEqualTo(expected);
    }

}
