package com.nicoletti.apiwatch.services;

import com.nicoletti.apiwatch.model.entities.ApiEndpointEntity;
import com.nicoletti.apiwatch.model.entities.ApiLogEntity;
import com.nicoletti.apiwatch.repositories.ApiLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApiMonitorScheduler {

    private final ApiEndpointService apiEndpointService;
    private final ApiLogRepository apiLogRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    // Executa a cada 1 minuto
    @Scheduled(fixedDelay = 60000)
    public void verificarApis() {
        List<ApiEndpointEntity> endpoints = apiEndpointService.findAll();

        for (ApiEndpointEntity endpoint : endpoints) {
            try {
                long start = System.currentTimeMillis();
                ResponseEntity<String> response = restTemplate.exchange(
                        endpoint.getUrl(),
                        HttpMethod.valueOf(endpoint.getMethod()),
                        null,
                        String.class
                );
                long duration = System.currentTimeMillis() - start;

                ApiLogEntity log = new ApiLogEntity();
                log.setEndpoint(endpoint);
                log.setStatusCode(response.getStatusCodeValue());
                log.setResponseBody(response.getBody());
                log.setSuccess(true);
                log.setExecutionTimeMs(duration);
                log.setTimestamp(LocalDateTime.now());

                apiLogRepository.save(log);
            } catch (Exception e) {
                ApiLogEntity log = new ApiLogEntity();
                log.setEndpoint(endpoint);
                log.setSuccess(false);
                log.setResponseBody(e.getMessage());
                log.setTimestamp(LocalDateTime.now());
                apiLogRepository.save(log);
            }
        }
    }

}

