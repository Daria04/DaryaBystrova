package com.epam.tc.hw9.test;

import static com.epam.tc.hw9.data.Options.*;

import com.epam.tc.hw9.dto.AnswerDto;
import com.epam.tc.hw9.dto.CheckTextDto;
import com.epam.tc.hw9.dto.CheckTextsDto;
import com.epam.tc.hw9.service.RestSpellerAssertions;
import com.epam.tc.hw9.service.RestSpellerService;
import org.testng.annotations.Test;

public class YandexSpellerTest {

    @Test(dataProvider = "positiveDataCase", dataProviderClass = DataOperations.class)
    public void positiveLanguageCase(String text, String lang) {
        CheckTextDto checkTextRequest = CheckTextDto.builder()
                                                    .text(text)
                                                    .lang(lang)
                                                    .build();

        AnswerDto[] response = new RestSpellerService().checkText(checkTextRequest);

        new RestSpellerAssertions(response).verifyResponseIsEmpty();
    }

    @Test(dataProvider = "negativeDataCase", dataProviderClass = DataOperations.class)
    public void negativeLanguageCase(String actualText, String lang, String expectedText) {
        CheckTextDto checkTextRequest = CheckTextDto.builder()
                                                    .text(actualText)
                                                    .lang(lang)
                                                    .build();

        AnswerDto[] response = new RestSpellerService().checkText(checkTextRequest);

        new RestSpellerAssertions(response).verifyActualText(actualText)
                                           .verifyHints(expectedText);
    }

    @Test(dataProvider = "textWithNumbersCase", dataProviderClass = DataOperations.class)
    public void textWithNumbers(String text, String lang) {
        CheckTextDto checkTextRequest = CheckTextDto.builder()
                                                    .text(text)
                                                    .lang(lang)
                                                    .options(IGNORE_DIGITS.getValue())
                                                    .build();

        AnswerDto[] response = new RestSpellerService().checkText(checkTextRequest);

        new RestSpellerAssertions(response).verifyResponseIsEmpty();
    }

    @Test(dataProvider = "repeatedTextCase", dataProviderClass = DataOperations.class)
    public void repeatedTextTest(String text, String lang) {
        CheckTextDto checkTextRequest = CheckTextDto.builder()
                                                    .text(text)
                                                    .lang(lang)
                                                    .options(FIND_REPEAT_WORDS.getValue())
                                                    .build();

        AnswerDto[] response = new RestSpellerService().checkText(checkTextRequest);

        new RestSpellerAssertions(response).verifyResponseIsNotEmpty();
    }

    @Test(dataProvider = "ignoreCapitalLettersCase", dataProviderClass = DataOperations.class)
    public void ignoreCapitalLettersTest(String text, String lang) {
        CheckTextDto checkTextRequest = CheckTextDto.builder()
                                                    .text(text)
                                                    .lang(lang)
                                                    .options(IGNORE_CAPITALIZATION.getValue())
                                                    .build();

        AnswerDto[] response = new RestSpellerService().checkText(checkTextRequest);

        new RestSpellerAssertions(response).verifyResponseIsEmpty();
    }

    @Test(dataProvider = "incorrectStringsCase", dataProviderClass = DataOperations.class)
    public void incorrectStringsTest(String[] text, String lang) {
        CheckTextsDto checkTextsRequest = CheckTextsDto.builder()
                                                       .text(text)
                                                       .lang(lang)
                                                       .build();
        AnswerDto[][] response = new RestSpellerService()
            .checkTexts(checkTextsRequest);

        new RestSpellerAssertions(response).verifyBodyResponseIsNotEmpty();
    }
}
