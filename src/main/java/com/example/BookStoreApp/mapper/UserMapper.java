package com.example.BookStoreApp.mapper;

import com.example.BookStoreApp.dto.UserRequest;
import com.example.BookStoreApp.dto.UserResponse;
import com.example.BookStoreApp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.Mapping;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User requestToEntity(UserRequest userRequest);

    UserResponse entityToResponse(User user);
}
