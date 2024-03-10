package ru.example.java.parsing;

import com.google.gson.GsonBuilder;
import ru.example.java.parsing.client.JsonHttpClient;
import ru.example.java.parsing.gson.CurrencyGson;
import ru.example.java.parsing.gson.adapters.ZonedDateTimeAdapter;

import java.time.ZonedDateTime;

public class AppGson {
    public static void main(String[] args) {
        var client = new JsonHttpClient("https://www.cbr-xml-daily.ru/daily_json.js");
        var json = client.getCurrencies();
//        System.out.println(json);

        var gson = new GsonBuilder()
                .registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
                .create();

        var gsonCurrencies = gson.fromJson(json, CurrencyGson.class);
        System.out.println(gsonCurrencies);
        System.out.println();

        System.out.println(gsonCurrencies.findByCode("BYN"));
        System.out.println(gsonCurrencies.findByCode("USD"));
        System.out.println(gsonCurrencies.findByCode("EUR"));
        System.out.println();

        var jsonFromGsonCurrencies = gson.toJson(gsonCurrencies);
        System.out.println(jsonFromGsonCurrencies);
        System.out.println();

    }
}
