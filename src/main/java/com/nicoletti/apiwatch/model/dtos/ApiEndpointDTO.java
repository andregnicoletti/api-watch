package com.nicoletti.apiwatch.model.dtos;

import java.time.LocalDateTime;

public record ApiEndpointDTO(
        Long id,
        String name,
        String url,
        String method,
        String headersJson,
        String bodyJson,
        Integer intervalMinutes,
        Long userId,
        Boolean active,
        LocalDateTime lastCheck
) {
}
