package com.nicoletti.apiwatch.model.dtos;

public record ApiEndpointNewDTO(
        String name,
        String url,
        String method,
        String headersJson,
        String bodyJson,
        Integer intervalMinutes,
        Long userId,
        Boolean active
) {
}
