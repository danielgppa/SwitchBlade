package com.switchblade.backend.controller.conv;

import com.switchblade.backend.entity.conv.CurrencyConversion;
import com.switchblade.backend.service.conv.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/conv/currency")
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversion> convertCurrency(@RequestParam String sourceCurrency, @RequestParam String targetCurrency, @RequestParam BigDecimal amount) {
        CurrencyConversion conversion = currencyConversionService.convertCurrency(sourceCurrency, targetCurrency, amount);
        return ResponseEntity.ok(conversion);
    }
}
