package com.dtu.elibrary.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private List<BookDto> content;
    private int pageNo;
    private int pageSize;
    private Long totalElements;
    private int totalPage;
    private boolean isLastPage;
}
