package com.nicoletti.apiwatch.model.dtos;

import java.util.List;

public record UserDTO(
        Long id,
        String name,
        String email,
        List<ApiEndpointDTO> endpoints
) {
}
