package com.dtu.elibrary.service.impl;

import com.dtu.elibrary.model.Publisher;
import com.dtu.elibrary.payload.PublisherDto;
import com.dtu.elibrary.repository.PublisherRepository;
import com.dtu.elibrary.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    ModelMapper mapper;
    PublisherRepository publisherRepository;

    public PublisherServiceImpl(ModelMapper mapper, PublisherRepository publisherRepository) {
        this.mapper = mapper;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<PublisherDto> getAllPublisher() {
        return publisherRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private Publisher mapToEntity(PublisherDto publisherDto){
        return mapper.map(publisherDto, Publisher.class);
    }

    private PublisherDto mapToDto(Publisher publisher){
        return mapper.map(publisher, PublisherDto.class);
    }
}
