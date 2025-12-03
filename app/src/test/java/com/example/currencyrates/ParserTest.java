package com.example.currencyrates;

import org.junit.Test;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testParseRates() {
        String sampleXml =
                "<channel>" +
                        "<item>" +
                        "<targetCurrency>EUR</targetCurrency>" +
                        "<exchangeRate>0.91</exchangeRate>" +
                        "</item>" +
                        "<item>" +
                        "<targetCurrency>JPY</targetCurrency>" +
                        "<exchangeRate>150.5</exchangeRate>" +
                        "</item>" +
                        "</channel>";

        HashMap<String, Double> map = Parser.parseRates(sampleXml);

        assertEquals(2, map.size());
        assertEquals(0.91, map.get("EUR"), 0.0001);
        assertEquals(150.5, map.get("JPY"), 0.0001);
    }
}
