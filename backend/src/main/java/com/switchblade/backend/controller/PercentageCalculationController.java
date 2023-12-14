package com.switchblade.backend.controller;

import com.switchblade.backend.entity.PercentageCalculation;
import com.switchblade.backend.service.PercentageCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/calculation")
public class PercentageCalculationController {

    private final PercentageCalculationService calculationService;

    @Autowired
    public PercentageCalculationController(PercentageCalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/percentage-of")
    public PercentageCalculation calculatePercentageOf(@RequestParam BigDecimal value1, @RequestParam BigDecimal value2) {
        return calculationService.calculatePercentageOfValue(value1, value2);
    }

    @PostMapping("/increase-by-percentage")
    public PercentageCalculation calculateIncreaseBy(@RequestParam BigDecimal value1, @RequestParam BigDecimal value2) {
        return calculationService.calculateIncreaseByPercentage(value1, value2);
    }

    @PostMapping("/decrease-by-percentage")
    public PercentageCalculation calculateDecreaseBy(@RequestParam BigDecimal value1, @RequestParam BigDecimal value2) {
        return calculationService.calculateDecreaseByPercentage(value1, value2);
    }

    @PostMapping("/percentage-difference")
    public PercentageCalculation calculatePercentageDifference(@RequestParam BigDecimal value1, @RequestParam BigDecimal value2) {
        return calculationService.calculatePercentageDifference(value1, value2);
    }
}
