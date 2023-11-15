package com.example.BookStoreApp.mapper;


import com.example.BookStoreApp.dto.StudentRequest;
import com.example.BookStoreApp.dto.StudentResponse;
import com.example.BookStoreApp.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.Mapping;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    Student requestToEntity(StudentRequest studentRequest);

    StudentResponse entityToResponse(Student student);

}
