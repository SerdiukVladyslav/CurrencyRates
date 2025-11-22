package com.example.currencyrates;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Parser {

    public static HashMap<String, Double> parseRates(String xml) {
        HashMap<String, Double> result = new HashMap<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

            NodeList list = doc.getElementsByTagName("item");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String currency = element.getElementsByTagName("targetCurrency")
                            .item(0).getTextContent();

                    String rateStr = element.getElementsByTagName("exchangeRate")
                            .item(0).getTextContent();

                    double rate = Double.parseDouble(rateStr);

                    result.put(currency, rate);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
