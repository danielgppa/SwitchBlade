package com.switchblade.backend.service;

import com.switchblade.backend.entity.PercentageCalculation;
import com.switchblade.backend.repository.PercentageCalculationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PercentageCalculationService {

    @Autowired
    private PercentageCalculationRepository repository;

    public PercentageCalculation calculatePercentageOfValue(BigDecimal value1, BigDecimal value2) {
        BigDecimal result = value2.divide(value1, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        return saveCalculation(value1, value2, result, "Percentage Of");
    }

    public PercentageCalculation calculateIncreaseByPercentage(BigDecimal value1, BigDecimal value2) {
        BigDecimal result = value1.add(value1.multiply(value2).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
        return saveCalculation(value1, value2, result, "Increase");
    }

    public PercentageCalculation calculateDecreaseByPercentage(BigDecimal value1, BigDecimal value2) {
        BigDecimal result = value1.subtract(value1.multiply(value2).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
        return saveCalculation(value1, value2, result, "Decrease");
    }

    public PercentageCalculation calculatePercentageDifference(BigDecimal value1, BigDecimal value2) {
        BigDecimal difference = value2.subtract(value1).abs();
        BigDecimal result = difference.divide(value1, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
        return saveCalculation(value1, value2, result, "Difference");
    }

    private PercentageCalculation saveCalculation(BigDecimal value1, BigDecimal value2, BigDecimal result, String calculationType) {
        PercentageCalculation calculation = new PercentageCalculation();
        calculation.setValue1(value1);
        calculation.setValue2(value2);
        calculation.setResult(result);
        calculation.setCalculationType(calculationType);
        return repository.save(calculation);
    }
}
