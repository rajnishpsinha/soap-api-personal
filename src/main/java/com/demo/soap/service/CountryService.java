package com.demo.soap.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CountryService {

    private static final Map<String, String[]> COUNTRIES = Map.of(
        "IN", new String[]{"India", "New Delhi"},
        "US", new String[]{"United States", "Washington D.C."},
        "GB", new String[]{"United Kingdom", "London"},
        "FR", new String[]{"France", "Paris"},
        "DE", new String[]{"Germany", "Berlin"},
        "JP", new String[]{"Japan", "Tokyo"},
        "CN", new String[]{"China", "Beijing"},
        "BR", new String[]{"Brazil", "Brasília"},
        "CA", new String[]{"Canada", "Ottawa"},
        "AU", new String[]{"Australia", "Canberra"}
    );

    public String[] getCountryData(String countryCode) {
        return COUNTRIES.getOrDefault(
            countryCode != null ? countryCode.toUpperCase() : "",
            new String[]{"Unknown", "Unknown"}
        );
    }
}
