package com.epam.tc.hw9.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardDto {
    private String id;
    private String name;
    private String desc;
    private boolean closed;
    private String idOrganization;
    private boolean pinned;
    private String url;
    private Map<String, String> labelNames;
    private String shortUrl;
    private List<ListDto> lists  = new ArrayList<>();
}
