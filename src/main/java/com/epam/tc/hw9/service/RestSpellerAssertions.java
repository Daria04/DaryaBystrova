package com.epam.tc.hw9.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw9.dto.AnswerDto;

public class RestSpellerAssertions {

    private AnswerDto[] answer;
    private AnswerDto[][] answers;

    public RestSpellerAssertions(AnswerDto[] response) {
        this.answer = response;
    }

    public RestSpellerAssertions(AnswerDto[][] response) {
        this.answers = response;
    }

    public void verifyResponseIsEmpty() {
        assertThat(answer).isEmpty();
    }

    public RestSpellerAssertions verifyActualText(String text) {
        assertThat(answer[0].getWord()).isEqualTo(text);
        return this;
    }

    public void verifyHints(String expected) {
        assertThat(answer[0].getS().get(0)).isEqualTo(expected);
    }

    public void verifyResponseIsNotEmpty() {
        assertThat(answer).isNotEmpty();
    }

    public void verifyBodyResponseIsNotEmpty() {
        assertThat(answers[0]).isNotEmpty();
    }

}
