package com.example.telegrambotconverter.bot;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class ExchangeRatesBot extends TelegramLongPollingBot {

    public static final Logger LOD = LoggerFactory.getLogger(ExchangeRatesBot.class);

    private static final String START = "/start";
    private static final String USD = "/usd";
    private static final String EUR = "/eur";
    private static final String HELP = "/help";

    public ExchangeRatesBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        var message = update.getMessage().getText();
        var chatId = update.getMessage().getChatId();

        switch (message) {
            case START -> {

            }
            case USD -> {

            }
        }
    }

    @Override
    public String getBotUsername() {
        return "telegram-bot-converter";
    }

    ++++++++
    private void startCommand(Long chatId, String userName) {
        var text = """
                """
    }

    public String sendMessage(Long chatId, String text) {
        var chatIdSrt = String.valueOf(chatId);
        var sendMessage = new SendMessage(chatIdSrt, text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException ex) {
            LOD.error("Ошибка отправления сообщения", ex);
        }
    }
}
++++-+





+------------------------------------------------------------------------------------------------------------------------------









































-----