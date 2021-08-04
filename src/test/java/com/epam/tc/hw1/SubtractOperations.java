package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw1.dataprovider.DataOperations;
import org.testng.annotations.Test;

public class SubtractOperations extends BaseTest {

    @Test(groups = {"firstGroup"}, dataProvider = "testLong", dataProviderClass = DataOperations.class)
    public void subOfLongNumbersTest(long x, long y) {
        long actual = calculator.sub(x, y);
        long expected = x - y;
        assertThat(actual).isEqualTo(expected);
    }

    @Test(groups = {"firstGroup"}, dataProvider = "testDouble", dataProviderClass = DataOperations.class)
    public void subOfDoubleNumbersTest(double x, double y) {
        double actual = calculator.sub(x, y);
        double expected = x - y;
        assertThat(actual).isEqualTo(expected);
    }

}
