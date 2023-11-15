package com.example.BookStoreApp.mapper;

import com.example.BookStoreApp.dto.AuthorRequest;
import com.example.BookStoreApp.dto.AuthorResponse;
import com.example.BookStoreApp.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.Mapping;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthorMapper {

    @Mapping(target = "id", ignore = true)
    Author requestToEntity(AuthorRequest studentRequest);

    AuthorResponse entityToResponse(Author author);

}
