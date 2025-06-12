package com.nicoletti.apiwatch.services;

import com.nicoletti.apiwatch.model.entities.ApiEndpointEntity;
import com.nicoletti.apiwatch.model.entities.ApiLogEntity;
import com.nicoletti.apiwatch.repositories.ApiEndpointRepository;
import com.nicoletti.apiwatch.repositories.ApiLogRepository;
import jakarta.transaction.Transactional;
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
    private final ApiEndpointRepository apiEndpointRepository;

    @Transactional
    @Scheduled(fixedDelay = 60000)
    public void verificarApis() {
        List<ApiEndpointEntity> endpoints = apiEndpointRepository.findAll();

        for (ApiEndpointEntity endpoint : endpoints) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime lastRun = endpoint.getLastCheck();
            int interval = endpoint.getIntervalMinutes() != null ? endpoint.getIntervalMinutes() : 1;

            boolean deveExecutar = (lastRun == null) || lastRun.plusMinutes(interval).isBefore(now);

            if (deveExecutar) {
                executarRequisicao(endpoint);
                endpoint.setLastCheck(now); // no need to call save explicitly
            }
        }
    }

    private void executarRequisicao(ApiEndpointEntity endpoint) {
        try {
            long start = System.currentTimeMillis();

            ResponseEntity<String> response = restTemplate.exchange(
                    endpoint.getUrl(),
                    HttpMethod.valueOf(endpoint.getMethod()),
                    null,
                    String.class
            );

            long duration = System.currentTimeMillis() - start;

            ApiLogEntity log = ApiLogEntity.builder()
                    .endpoint(endpoint)
                    .timestamp(LocalDateTime.now())
                    .success(true)
                    .statusCode(response.getStatusCodeValue())
                    .responseBody(response.getBody())
                    .executionTimeMs(duration)
                    .build();

            apiLogRepository.save(log);

        } catch (Exception e) {
            ApiLogEntity log = ApiLogEntity.builder()
                    .endpoint(endpoint)
                    .timestamp(LocalDateTime.now())
                    .success(false)
                    .responseBody(e.getMessage())
                    .build();

            apiLogRepository.save(log);
        }
    }

}

