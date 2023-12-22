package com.switchblade.backend.entity.calc;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "percentage_calculation")
public class PercentageCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value1", nullable = false)
    private BigDecimal value1;

    @Column(name = "value2", nullable = false)
    private BigDecimal value2;

    @Column(name = "result", nullable = false)
    private BigDecimal result;

    @Column(name = "calculation_type", nullable = false)
    private String calculationType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue1() {
        return value1;
    }

    public void setValue1(BigDecimal value1) {
        this.value1 = value1;
    }

    public BigDecimal getValue2() {
        return value2;
    }

    public void setValue2(BigDecimal value2) {
        this.value2 = value2;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }
}
