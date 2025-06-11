package com.nicoletti.apiwatch.model.dtos;

public record UserNewDTO(
        String name,
        String email,
        String password
) {
}
