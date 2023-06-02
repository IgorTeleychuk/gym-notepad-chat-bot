package com.teleychuk.gymnotepadchatbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
@Slf4j
public class ApproachService {

    public SendMessage approach(Update update) {

        long chatId = update.getMessage().getChatId();
        String messageText = update.getMessage().getText();

        SendMessage messageZero = new SendMessage();
        messageZero.setText("zero");

        if (messageText.equals("Три")) {
            return sendMessage(chatId, "Three", Keyboard.repetitionKeyboard());
        }
        if (messageText.equals("Пять")) {
            return sendMessage(chatId, "Four", Keyboard.repetitionKeyboard());
        }
        if (messageText.equals("Шесть")) {
            return sendMessage(chatId, "Five", Keyboard.repetitionKeyboard());
        }
        if (messageText.equals("назад..")) {
            return sendMessage(chatId, "Возврат в предыдущее меню...", Keyboard.simulatorKeyboard());
        }
        return messageZero;

    }

    private SendMessage sendMessage(long chatId, String textToSend, ReplyKeyboardMarkup keyboardMarkup) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        message.setReplyMarkup(keyboardMarkup);

        return message;
    }
}
