package com.example.telegrambotconverter.service;

import com.example.telegrambotconverter.exeption.ServiceException;

import java.io.IOException;

public interface ExchangeRateService {

    String getUSDExchangeRate() throws ServiceException, IOException;
    String getEUREExchangeRate() throws ServiceException, IOException;
}
