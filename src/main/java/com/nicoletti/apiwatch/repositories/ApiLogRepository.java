package com.nicoletti.apiwatch.repositories;

import com.nicoletti.apiwatch.model.entities.ApiLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiLogRepository extends JpaRepository<ApiLogEntity, Long> {
}
