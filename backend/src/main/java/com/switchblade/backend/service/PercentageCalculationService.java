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

    public PercentageCalculation whatIsThePercentageOf(BigDecimal value1, BigDecimal value2) {
        BigDecimal result = value1.multiply(value2).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return saveCalculation(value1, value2, result, "What is the % of");
    }

    public PercentageCalculation valueIsWhatPercentageOf(BigDecimal value1, BigDecimal value2) {
        BigDecimal result = value1.multiply(BigDecimal.valueOf(100)).divide(value2, 2, RoundingMode.HALF_UP);
        return saveCalculation(value1, value2, result, "Value is what % of");
    }

    public PercentageCalculation percentageIncrease(BigDecimal oldValue, BigDecimal newValue) {
        BigDecimal result = newValue.subtract(oldValue).multiply(BigDecimal.valueOf(100)).divide(oldValue, 2, RoundingMode.HALF_UP);
        return saveCalculation(oldValue, newValue, result, "Percentage Increase");
    }

    public PercentageCalculation percentageDecrease(BigDecimal oldValue, BigDecimal newValue) {
        BigDecimal result = oldValue.subtract(newValue).multiply(BigDecimal.valueOf(100)).divide(oldValue, 2, RoundingMode.HALF_UP);
        return saveCalculation(oldValue, newValue, result, "Percentage Decrease");
    }

    public PercentageCalculation increaseByPercentage(BigDecimal value, BigDecimal percentage) {
        BigDecimal result = value.add(value.multiply(percentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
        return saveCalculation(value, percentage, result, "Increase by %");
    }

    public PercentageCalculation decreaseByPercentage(BigDecimal value, BigDecimal percentage) {
        BigDecimal result = value.subtract(value.multiply(percentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP));
        return saveCalculation(value, percentage, result, "Decrease by %");
    }

    public PercentageCalculation initialIncreasedByPercentage(BigDecimal finalValue, BigDecimal percentage) {
        BigDecimal result = finalValue.multiply(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(100).add(percentage), 2, RoundingMode.HALF_UP);
        return saveCalculation(finalValue, percentage, result, "Initial value increased by %");
    }

    public PercentageCalculation initialDecreasedByPercentage(BigDecimal finalValue, BigDecimal percentage) {
        BigDecimal result = finalValue.multiply(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(100).subtract(percentage), 2, RoundingMode.HALF_UP);
        return saveCalculation(finalValue, percentage, result, "Initial value decreased by %");
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
