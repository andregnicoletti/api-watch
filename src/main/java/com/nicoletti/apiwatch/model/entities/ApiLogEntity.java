package com.nicoletti.apiwatch.model.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "api_logs")
public class ApiLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    private boolean success;

    private Integer statusCode;

    @Lob
    private String responseBody;

    private Long executionTimeMs; // tempo de execução em milissegundos

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endpoint_id")
    private ApiEndpointEntity endpoint;
}


