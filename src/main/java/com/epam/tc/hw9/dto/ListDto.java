package com.epam.tc.hw9.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListDto {
    private String id;
    private String name;
    private List<CardDto> cards = new ArrayList<>();
    private boolean closed;
    private String idBoard;
    private int pos;
}
