package com.switchblade.backend.entity.conv;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "currency_conversion")
public class CurrencyConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_currency", nullable = false)
    private String sourceCurrency;

    @Column(name = "target_currency", nullable = false)
    private String targetCurrency;

    @Column(name = "input_value", nullable = false)
    private BigDecimal inputValue;

    @Column(name = "converted_value", nullable = false)
    private BigDecimal convertedValue;

    @Column(name = "conversion_rate", nullable = false)
    private BigDecimal conversionRate;

    @Column(name = "conversion_timestamp", nullable = false)
    private LocalDateTime conversionTimestamp;

    public CurrencyConversion() {
    }

    public CurrencyConversion(String sourceCurrency, String targetCurrency, BigDecimal inputValue, BigDecimal convertedValue, BigDecimal conversionRate, LocalDateTime conversionTimestamp) {
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.inputValue = inputValue;
        this.convertedValue = convertedValue;
        this.conversionRate = conversionRate;
        this.conversionTimestamp = conversionTimestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getInputValue() {
        return inputValue;
    }

    public void setInputValue(BigDecimal inputValue) {
        this.inputValue = inputValue;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public LocalDateTime getConversionTimestamp() {
        return conversionTimestamp;
    }

    public void setConversionTimestamp(LocalDateTime conversionTimestamp) {
        this.conversionTimestamp = conversionTimestamp;
    }
}
