package com.yehor.booklist.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {

    private long id;
    private String fullName;

}
