package com.nicoletti.apiwatch.controllers;

import com.nicoletti.apiwatch.model.dtos.ResponseDTO;
import com.nicoletti.apiwatch.model.dtos.UserResponseDTO;
import com.nicoletti.apiwatch.model.dtos.UserNewDTO;
import com.nicoletti.apiwatch.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<ResponseDTO> createNew(@RequestBody UserNewDTO userNewDTO) {
        ResponseDTO dto = service.create(userNewDTO);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> list() {
        ResponseDTO dto = service.listAllUser();
        return ResponseEntity.ok(dto);
    }

}
