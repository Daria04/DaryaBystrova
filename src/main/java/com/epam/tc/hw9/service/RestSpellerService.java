package com.epam.tc.hw9.service;

import static com.epam.tc.hw9.data.Data.*;

import com.epam.tc.hw9.constants.URI;
import com.epam.tc.hw9.dto.AnswerDto;
import com.epam.tc.hw9.dto.CheckTextDto;
import com.epam.tc.hw9.dto.CheckTextsDto;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class RestSpellerService extends CommonService {

    public AnswerDto[] checkText(CheckTextDto request) {
        Map<String, Object> params = new HashMap<>();
        params.put(TEXT, request.getText());
        params.put(LANGUAGE, request.getLang());
        params.put(OPTIONS, request.getOptions());

        return
            new Gson().fromJson(
                new CommonService()
                    .getWithParams(URI.CHECK_TEXT, params)
                    .getBody().asString(), AnswerDto[].class);
    }

    public AnswerDto[][] checkTexts(CheckTextsDto request) {
        Map<String, Object> params = new HashMap<>();
        params.put(TEXT, request.getText());
        params.put(LANGUAGE, request.getLang());

        return
            new Gson().fromJson(
                new CommonService()
                    .getWithParams(URI.CHECK_TEXTS, params)
                    .getBody().asString(), AnswerDto[][].class);
    }
}
