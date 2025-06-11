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
@Table(name = "tb_api_endpoint")
public class ApiEndpointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String url;
    String method;
    String headersJson;
    String bodyJson;
    Integer intervalMinutes;
    Long userId;
    Boolean active;
    LocalDateTime lastCheck;

    @ManyToOne
    @JoinColumn(name = "endpoints")
    UserEntity user;

}
