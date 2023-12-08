package com.dtu.elibrary.controller;

import com.dtu.elibrary.payload.PublisherDto;
import com.dtu.elibrary.service.PublisherService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {
    PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping()
    public ResponseEntity<List<PublisherDto>> getAllPublisher(){
        return ResponseEntity.of(Optional.ofNullable(publisherService.getAllPublisher()));
    }

}
