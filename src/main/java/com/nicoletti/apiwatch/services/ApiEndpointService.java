package com.nicoletti.apiwatch.services;

import com.nicoletti.apiwatch.model.dtos.ApiEndpointNewDTO;
import com.nicoletti.apiwatch.model.dtos.FailedResponseDTO;
import com.nicoletti.apiwatch.model.dtos.ResponseDTO;
import com.nicoletti.apiwatch.model.entities.ApiEndpointEntity;
import com.nicoletti.apiwatch.model.entities.UserEntity;
import com.nicoletti.apiwatch.model.mappers.ApiEndpointMapper;
import com.nicoletti.apiwatch.repositories.ApiEndpointRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ApiEndpointService {

    private final ApiEndpointRepository repository;
    private final UserService userService;
    private final ApiEndpointMapper mapper;


    public ResponseDTO setNewWatch(ApiEndpointNewDTO newDTO) {
        try {
            UserEntity userEntity = userService.getEntityById(newDTO.userId());
            ApiEndpointEntity entity = mapper.toEntity(newDTO);
            entity.setUser(userEntity);
            ApiEndpointEntity save = repository.save(entity);

            return mapper.toDtoResponse(save);

        } catch (Exception e) {
            return new FailedResponseDTO(e.getMessage());
        }
    }

    public List<ApiEndpointEntity> findAll() {
        return this.repository.findAll();
    }
}
