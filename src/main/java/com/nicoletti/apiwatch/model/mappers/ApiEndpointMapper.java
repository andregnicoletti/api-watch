package com.nicoletti.apiwatch.model.mappers;

import com.nicoletti.apiwatch.model.dtos.ApiEndpointDTO;
import com.nicoletti.apiwatch.model.dtos.ApiEndpointNewDTO;
import com.nicoletti.apiwatch.model.dtos.ApiEndpointResponseDTO;
import com.nicoletti.apiwatch.model.entities.ApiEndpointEntity;
import com.nicoletti.apiwatch.model.entities.UserEntity;
import org.mapstruct.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Mapper(componentModel = "spring")
public interface ApiEndpointMapper {

    ApiEndpointEntity toEntity(ApiEndpointNewDTO apiEndpointNewDTO);

    ApiEndpointDTO toDto(ApiEndpointEntity entity);

    ApiEndpointResponseDTO toDtoResponse(ApiEndpointEntity entity);

    // Atualização: aplica dados do DTO em uma entidade existente
    void updateFromDto(ApiEndpointDTO dto, @MappingTarget ApiEndpointEntity entity);

}
