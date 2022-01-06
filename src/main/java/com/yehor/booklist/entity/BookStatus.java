package com.yehor.booklist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BookStatus {

    @JsonProperty("not_reading")
    NOT_READING("not_reading"),

    @JsonProperty("in_progress")
    IN_PROGRESS("in_progress"),

    @JsonProperty("done")
    DONE("done");

    @Getter
    private String value;
}
