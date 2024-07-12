package com.example.telegrambotconverter.impl;

import com.example.telegrambotconverter.client.CbrClient;
import com.example.telegrambotconverter.exeption.ServiceException;
import com.example.telegrambotconverter.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import javax.swing.*;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private static final String USD_XPATH = "/ValCurs//Valute[@ID='R01235']/Value";
    private static final String EUR_XPATH = "/ValCurs//Valute[@ID='R01239']/Value";
    @Autowired
    private CbrClient client;

    @Override
    public String getUSDExchangeRate() throws ServiceException, IOException {
        var fullXml = client.getCurrencyRateXML();
        return extractCurrencyValueXML(fullXml, USD_XPATH);
    }

    @Override
    public String getEUREExchangeRate() throws ServiceException, IOException {
        var fullXml = client.getCurrencyRateXML();
        return extractCurrencyValueXML(fullXml, EUR_XPATH);
    }

    private static String extractCurrencyValueXML(String xml, String xpathExpression) throws ServiceException {
        var source = new InputSource(new StringReader(xml));
        try {
            var xpath = XPathFactory.newInstance().newXPath();
            var document = xpath.evaluate("/", source, XPathConstants.NODE);

            return xpath.evaluate(xpathExpression, document);
        } catch (XPathExpressionException e) {
            throw new ServiceException("Не удалось распарсить XML", e);
        }
    }
}
