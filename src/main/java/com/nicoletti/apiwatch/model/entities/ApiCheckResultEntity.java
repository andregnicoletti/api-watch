package com.nicoletti.apiwatch.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_api_check_result")
public class ApiCheckResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long endpointId;
    Integer statusCode;
    Long responseTimeMs;
    String errorMessage;
    LocalDateTime checkTime;

}
