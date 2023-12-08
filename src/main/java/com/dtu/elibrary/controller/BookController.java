package com.dtu.elibrary.controller;

import com.dtu.elibrary.payload.BookDto;
import com.dtu.elibrary.payload.BookResponse;
import com.dtu.elibrary.service.BookService;
import com.dtu.elibrary.service.CloudinaryService;
import com.dtu.elibrary.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookController {

    BookService bookService;
    CloudinaryService cloudinaryService;

    public BookController(BookService bookService, CloudinaryService cloudinaryService) {
        this.bookService = bookService;
        this.cloudinaryService = cloudinaryService;
    }

    @GetMapping()
    public ResponseEntity<BookResponse> getAllBook(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int pageNo,
                                                   @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
                                                   @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY) String sortBy,
                                                   @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION) String sortDir){
        BookResponse bookResponse = bookService.getAllBook(pageNo, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(bookResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable int id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<BookResponse> findBookByTitle(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int pageNo,
                                                       @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int pageSize,
                                                       @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY) String sortBy,
                                                       @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION) String sortDir,
                                                       @RequestParam(value = "title") String title){
        BookResponse bookResponse = bookService.findBookByName(pageNo, pageSize, sortBy, sortDir, title);
        return ResponseEntity.ok(bookResponse);
    }

    @PostMapping()
    public ResponseEntity<BookDto> addNewBook(@ModelAttribute BookDto bookDto){
        return new ResponseEntity<>(bookService.addNewBook(bookDto), HttpStatus.CREATED);
    }

//    @RequestPart("image") MultipartFile file,
//    @PostMapping()
//    public ResponseEntity<BookDto> addNewBook(@RequestParam(value = "file") MultipartFile file ,@RequestBody BookDto bookDto){
//        Map data = this.cloudinaryService.upload(file);
//        System.out.println(data.get("url").toString());
//        bookDto.setImage(data.get("url").toString());
//        return new ResponseEntity<>(bookService.addNewBook(bookDto), HttpStatus.CREATED);
//    }


//    @PostMapping( consumes = { "multipart/form-data" })
//    public ResponseEntity<BookDto> addNewBook(@RequestParam(value = "file", required = false) MultipartFile file, @RequestPart("bookDto") BookDto bookDto) {
//        try {
////            // Validate MultipartFile
////            if (file.isEmpty()) {
////                return ResponseEntity.badRequest().body("File is required");
////            }
//
//            // Upload file to Cloudinary
//            Map<String, String> data = this.cloudinaryService.upload(file);
//            String imageUrl = data.get("url");
//
//            // Set image URL in BookDto
//            bookDto.setImage(imageUrl);
//
//            // Add new book
//            BookDto savedBook = bookService.addNewBook(bookDto);
//
//            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
//        } catch (Exception e) {
//            // Handle exceptions (e.g., Cloudinary service exception)
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
