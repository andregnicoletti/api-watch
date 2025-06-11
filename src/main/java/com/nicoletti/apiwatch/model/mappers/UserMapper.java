package com.nicoletti.apiwatch.model.mappers;


import com.nicoletti.apiwatch.model.dtos.UserDTO;
import com.nicoletti.apiwatch.model.dtos.UserMinDTO;
import com.nicoletti.apiwatch.model.dtos.UserNewDTO;
import com.nicoletti.apiwatch.model.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserMinDTO userMinDTO);

    UserEntity toEntity(UserNewDTO userNewDTO);

    UserMinDTO toDto(UserEntity entity);

    // Atualização: aplica dados do DTO em uma entidade existente
    void updateFromDto(UserDTO dto, @MappingTarget UserEntity entity);

}
