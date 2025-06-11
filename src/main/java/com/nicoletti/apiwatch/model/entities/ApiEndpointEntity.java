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
    private Long id;
    private String name;
    private String url;
    private String method;
    private String headersJson;
    private String bodyJson;
    private Integer intervalMinutes;
    private Boolean active;
    private LocalDateTime lastCheck;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
