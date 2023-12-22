package com.switchblade.backend.service.conv;

import com.switchblade.backend.entity.conv.CurrencyConversion;
import com.switchblade.backend.repository.conv.CurrencyConversionRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class CurrencyConversionService {

    private static final String API_URL = "http://api.exchangeratesapi.io/v1/latest?access_key=409d070b6e72039b3b7a580f767b76cf&format=1";

    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    public CurrencyConversion convertCurrency(String sourceCurrency, String targetCurrency, BigDecimal amount) {
        BigDecimal conversionRate = getConversionRateFromAPI(sourceCurrency, targetCurrency);
        BigDecimal convertedValue = amount.multiply(conversionRate);

        CurrencyConversion currencyConversion = new CurrencyConversion(sourceCurrency, targetCurrency, amount, convertedValue, conversionRate, LocalDateTime.now());
        return currencyConversionRepository.save(currencyConversion);
    }

    private BigDecimal getConversionRateFromAPI(String sourceCurrency, String targetCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(API_URL, String.class);
        JSONObject json = new JSONObject(response);
        JSONObject rates = json.getJSONObject("rates");

        BigDecimal sourceRate = sourceCurrency.equals("EUR") ? BigDecimal.ONE : rates.getBigDecimal(sourceCurrency);
        BigDecimal targetRate = rates.getBigDecimal(targetCurrency);

        return targetRate.divide(sourceRate, 6, BigDecimal.ROUND_HALF_UP);
    }
}
