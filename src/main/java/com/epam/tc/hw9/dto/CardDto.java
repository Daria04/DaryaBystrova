package com.epam.tc.hw9.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDto {
    private String id;
    private String name;
    private String idList;
    private String desc;
    private String url;
    private boolean dueComplete;
    private List<String> idMembers;
    private boolean closed;
    private Date dateLastActivity;
    private String idBoard;
    private List<String> idChecklists;
    private List<String> idMembersVoted;
    private String idShort;
    private String idAttachmentCover;
    private boolean manualCoverAttachment;
    private long pos;
    private String shortLink;
    private String shortUrl;
    private boolean subscribed;
}
