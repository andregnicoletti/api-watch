package com.nicoletti.apiwatch.services;

import com.nicoletti.apiwatch.model.dtos.*;
import com.nicoletti.apiwatch.model.entities.UserEntity;
import com.nicoletti.apiwatch.model.mappers.UserMapper;
import com.nicoletti.apiwatch.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;

    @Transactional
    public ResponseDTO create(UserNewDTO userNewDTO) {

        if (repository.existsByEmail(userNewDTO.email())) {
            return new FailedResponseDTO("An user with email " + userNewDTO.email() + " already exists");
        }

        UserEntity entity = userMapper.toEntity(userNewDTO);
        UserEntity save = repository.save(entity);

        SuccessResponseDTO successResponseDTO = new SuccessResponseDTO();
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName(save.getName());
        responseDTO.setEmail(save.getEmail());
        return responseDTO;

    }

    public ResponseDTO listAllUser() {
        List<UserEntity> allUsers = repository.findAll();
        List<UserMinDTO> collect = allUsers.stream().map(e -> userMapper.toDto(e)).collect(Collectors.toList());
        return new UserResponseListDTO(collect);
    }

    public boolean hasUser(Long id) {
        return repository.existsById(id);
    }

    public UserEntity getEntityById(Long id) {
        Optional<UserEntity> userOptional = repository.findById(id);
        return userOptional.orElseThrow(() -> new RuntimeException("User id not found: " + id));
    }
}
