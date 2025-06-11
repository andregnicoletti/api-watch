package com.nicoletti.apiwatch.controllers;

import com.nicoletti.apiwatch.model.dtos.ApiEndpointDTO;
import com.nicoletti.apiwatch.model.dtos.ApiEndpointNewDTO;
import com.nicoletti.apiwatch.model.dtos.ResponseDTO;
import com.nicoletti.apiwatch.services.ApiEndpointService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watch")
@AllArgsConstructor
public class EndpointController {

    private final ApiEndpointService service;

    @PostMapping
    public ResponseEntity<ResponseDTO> createWatch(@RequestBody ApiEndpointNewDTO apiEndpointNewDTO) {
        ResponseDTO dto = service.setNewWatch(apiEndpointNewDTO);
        return ResponseEntity.ok(dto);
    }

}
