package com.epam.tc.hw9.test;

import static com.epam.tc.hw9.data.Data.*;
import static com.epam.tc.hw9.data.RequestData.*;

import org.testng.annotations.DataProvider;

public class DataOperations {

    @DataProvider(name = "positiveDataCase")
    public static Object[][] positiveLanguageProvider() {
        return new Object[][] {
            {EN_CORRECT, ENGLISH},
            {RU_CORRECT, RUSSIAN},
            {UK_CORRECT, UKRAINIAN}
        };
    }

    @DataProvider(name = "negativeDataCase")
    public static Object[][] negativeLanguageProvider() {
        return new Object[][] {
            {EN_WITH_MISTAKES, ENGLISH, EN_CORRECT},
            {RU_WITH_MISTAKES, RUSSIAN, RU_CORRECT},
            {UK_WITH_MISTAKES, UKRAINIAN, UK_CORRECT}
        };
    }

    @DataProvider(name = "textWithNumbersCase")
    public static Object[][] textWithNumbersProvider() {
        return new Object[][] {
            {EN_TEXT_WITH_NUMBERS, ENGLISH},
            {RU_TEXT_WITH_NUMBERS, RUSSIAN},
            {UK_TEXT_WITH_NUMBERS, UKRAINIAN}
        };
    }

    @DataProvider(name = "repeatedTextCase")
    public static Object[][] repeatedTextProvider() {
        return new Object[][] {
            {EN_REPEATED_WORDS, ENGLISH},
            {RU_REPEATED_WORDS, RUSSIAN},
            {UK_REPEATED_WORDS, UKRAINIAN}
        };
    }

    @DataProvider(name = "ignoreCapitalLettersCase")
    public static Object[][] ignoreCapitalLettersProvider() {
        return new Object[][] {
            {EN_IGNORE_CAPITAL, ENGLISH},
            {RU_IGNORE_CAPITAL, RUSSIAN},
            {UK_IGNORE_CAPITAL, UKRAINIAN}
        };
    }

    @DataProvider(name = "incorrectStringsCase")
    public static Object[][] incorrectStringsProvider() {
        return new Object[][] {
            {new String[] {EN_FIRST_WRONG, EN_SECOND_WRONG, EN_THIRD_WRONG}, ENGLISH},
            {new String[] {RU_FIRST_WRONG, RU_SECOND_WRONG, RU_THIRD_WRONG}, RUSSIAN}
        };
    }
}
