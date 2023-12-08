package com.dtu.elibrary.payload;

import com.dtu.elibrary.model.Author;
import com.dtu.elibrary.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private String description;
    private int quantity;
    private double price;
    private MultipartFile image;
    private LocalDate createDate;
    private LocalDate publishedYear;
    private String publisherId;
    private String authorId;
    private List<Integer> categoryIds;
}
