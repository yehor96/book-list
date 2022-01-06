package com.yehor.booklist.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private long id;
    private String title;
    @JsonProperty("author_id")
    private long authorId;
    private BookStatus status;

}
