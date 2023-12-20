package com.switchblade.backend.controller;

import com.switchblade.backend.entity.PercentageCalculation;
import com.switchblade.backend.service.PercentageCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculation")
@CrossOrigin(origins = "http://localhost:3000")
public class PercentageCalculationController {

    private final PercentageCalculationService calculationService;

    @Autowired
    public PercentageCalculationController(PercentageCalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/what-is-the-percentage-of")
    public PercentageCalculation whatIsThePercentageOf(@RequestParam BigDecimal value1, @RequestParam BigDecimal value2) {
        return calculationService.whatIsThePercentageOf(value1, value2);
    }

    @PostMapping("/value-is-what-percentage-of")
    public PercentageCalculation valueIsWhatPercentageOf(@RequestParam BigDecimal value1, @RequestParam BigDecimal value2) {
        return calculationService.valueIsWhatPercentageOf(value1, value2);
    }

    @PostMapping("/percentage-increase")
    public PercentageCalculation percentageIncrease(@RequestParam BigDecimal oldValue, @RequestParam BigDecimal newValue) {
        return calculationService.percentageIncrease(oldValue, newValue);
    }

    @PostMapping("/percentage-decrease")
    public PercentageCalculation percentageDecrease(@RequestParam BigDecimal oldValue, @RequestParam BigDecimal newValue) {
        return calculationService.percentageDecrease(oldValue, newValue);
    }

    @PostMapping("/increase-by-percentage")
    public PercentageCalculation increaseByPercentage(@RequestParam BigDecimal value, @RequestParam BigDecimal percentage) {
        return calculationService.increaseByPercentage(value, percentage);
    }

    @PostMapping("/decrease-by-percentage")
    public PercentageCalculation decreaseByPercentage(@RequestParam BigDecimal value, @RequestParam BigDecimal percentage) {
        return calculationService.decreaseByPercentage(value, percentage);
    }

    @PostMapping("/initial-value-increased-by")
    public PercentageCalculation initialIncreasedByPercentage(@RequestParam BigDecimal finalValue, @RequestParam BigDecimal percentage) {
        return calculationService.initialIncreasedByPercentage(finalValue, percentage);
    }

    @PostMapping("/initial-value-decreased-by")
    public PercentageCalculation initialDecreasedByPercentage(@RequestParam BigDecimal finalValue, @RequestParam BigDecimal percentage) {
        return calculationService.initialDecreasedByPercentage(finalValue, percentage);
    }
}
