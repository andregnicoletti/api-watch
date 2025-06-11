package com.nicoletti.apiwatch.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiEndpointResponseDTO extends ResponseDTO {

    private Long id;
    private String name;
    private String url;
    private String method;
    private String headersJson;
    private String bodyJson;
    private Integer intervalMinutes;
    private Boolean active;
    private LocalDateTime lastCheck;

}
