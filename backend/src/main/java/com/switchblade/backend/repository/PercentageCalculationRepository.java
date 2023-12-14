package com.switchblade.backend.repository;

import com.switchblade.backend.entity.PercentageCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PercentageCalculationRepository extends JpaRepository<PercentageCalculation, Long> {
}
