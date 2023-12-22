package com.switchblade.backend.repository.calc;

import com.switchblade.backend.entity.calc.PercentageCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PercentageCalculationRepository extends JpaRepository<PercentageCalculation, Long> {
}
