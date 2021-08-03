package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tat.module4.Calculator;
import com.epam.tc.hw1.dataprovider.DataOperations;
import org.testng.annotations.Test;

public class DivideOperations {

    private final Calculator calculator = new Calculator();

    @Test(groups = {"secondGroup"}, dataProvider = "testLong", dataProviderClass = DataOperations.class)
    public void divOfLongNumbersTest(long x, long y) {
        long actual = calculator.div(x, y);
        long expected = x / y;
        assertThat(actual).isEqualTo(expected);
    }

    @Test (expectedExceptions = NumberFormatException.class,
            expectedExceptionsMessageRegExp = "Attempt to divide by zero", groups = {"secondGroup"})
    public void divideOnZero_exceptionWasThrown() {

        calculator.div(5, 0);
    }

    @Test(groups = {"secondGroup"}, dataProvider = "testDouble", dataProviderClass = DataOperations.class)
    public void divOfDoubleNumbersTest(double x, double y) {
        double actual = calculator.div(x, y);
        double expected = x / y;
        assertThat(actual).isEqualTo(expected);
    }

}
