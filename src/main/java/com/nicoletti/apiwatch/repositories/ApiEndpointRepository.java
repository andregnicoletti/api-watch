package com.nicoletti.apiwatch.repositories;

import com.nicoletti.apiwatch.model.entities.ApiEndpointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiEndpointRepository extends JpaRepository<ApiEndpointEntity, Long> {
}
