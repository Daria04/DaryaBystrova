package com.epam.tc.hw9.data;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Options {

    IGNORE_DIGITS(2),
    FIND_REPEAT_WORDS(8),
    IGNORE_CAPITALIZATION(512);

    private final int value;

    public String getValue() {
        return String.valueOf(value);
    }
}
