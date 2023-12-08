package com.dtu.elibrary.controller;

import com.dtu.elibrary.service.CloudinaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {
    private final CloudinaryService cloudinaryService;

    public TestController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> TestGetRequest(){
        return ResponseEntity.ok("Get successfully");
    }

    @PostMapping("/test")
    public ResponseEntity<String> TestPostRequest(){
        return new ResponseEntity<>("Post successfully", HttpStatus.CREATED);
    }


    @PostMapping("/cloudinary")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file){
        Map data = this.cloudinaryService.upload(file);
        System.out.println(data.get("url").toString());
        return new ResponseEntity<>(data.get("url").toString(), HttpStatus.OK);
    }


    @GetMapping("/admin/test")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> TestAdmin(){
        return ResponseEntity.ok("Admin test successfully");
    }
}
