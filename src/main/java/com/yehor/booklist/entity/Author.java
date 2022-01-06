package com.yehor.booklist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {

    private long id;
    @JsonProperty("full_name")
    private String fullName;

}
