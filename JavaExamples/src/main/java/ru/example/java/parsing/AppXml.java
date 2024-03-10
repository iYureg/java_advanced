package ru.example.java.parsing;

import ru.example.java.parsing.client.JsonHttpClient;
import ru.example.java.parsing.xml.parser.CurrencyXmlParser;

public class AppXml {
    public static void main(String[] args) {
        var client = new JsonHttpClient("https://www.cbr-xml-daily.ru/daily_utf8.xml");
        var xml = client.getCurrencies();

//        System.out.println(xml);

        var parser = new CurrencyXmlParser();
        var currencies = parser.toObject(xml);
//        System.out.println(currencies.toString());

        var currenciesXml = parser.toXml(currencies);
        System.out.println(currenciesXml);
    }
}
