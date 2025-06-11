package com.nicoletti.apiwatch.controllers;

import com.nicoletti.apiwatch.model.dtos.StatusHealthDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusHealth {

    @GetMapping
    public ResponseEntity<StatusHealthDTO> check(){
        StatusHealthDTO dto = new StatusHealthDTO(Boolean.TRUE);
        return ResponseEntity.ok(dto);
    }

}
