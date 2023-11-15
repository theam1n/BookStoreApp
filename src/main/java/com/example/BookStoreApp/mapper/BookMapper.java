package com.example.BookStoreApp.mapper;

import com.example.BookStoreApp.dto.BookRequest;
import com.example.BookStoreApp.dto.BookResponse;
import com.example.BookStoreApp.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.Mapping;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {


    @Mapping(target = "id", ignore = true)
    Book requestToEntity(BookRequest bookRequest);

    BookResponse entityToResponse(Book book);

}
