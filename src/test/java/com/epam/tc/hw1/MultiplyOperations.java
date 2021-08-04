package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.dataprovider.DataOperations;
import org.testng.annotations.Test;

public class MultiplyOperations extends BaseTest {

    @Test(groups = {"secondGroup"}, dataProvider = "testLong", dataProviderClass = DataOperations.class)
    public void multOfLongNumbersTest(long x, long y) {
        long actual = calculator.mult(x, y);
        long expected = x * y;
        assertThat(actual).isEqualTo(expected);
    }

    @Test(groups = {"secondGroup"}, dataProvider = "testDouble", dataProviderClass = DataOperations.class)
    public void multOfDoubleNumbersTest(double x, double y) {
        double actual = calculator.mult(x, y);
        double expected = Math.floor(x * y);
        assertThat(actual).isEqualTo(expected);
    }

}
