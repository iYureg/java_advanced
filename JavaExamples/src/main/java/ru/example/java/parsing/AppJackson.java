package ru.example.java.parsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.example.java.parsing.client.JsonHttpClient;
import ru.example.java.parsing.jackson.CurrencyJackson;

public class AppJackson {
    public static void main(String[] args) {
        var client = new JsonHttpClient("https://www.cbr-xml-daily.ru/daily_json.js");
        var json = client.getCurrencies();

        var jacksonMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule());

        CurrencyJackson jacksonCurrencies;
        try {
            jacksonCurrencies = jacksonMapper.readValue(json, CurrencyJackson.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jacksonCurrencies);
        System.out.println();

        String stringJson;
        try {
            stringJson = jacksonMapper.writeValueAsString(jacksonCurrencies);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(stringJson);

    }
}
