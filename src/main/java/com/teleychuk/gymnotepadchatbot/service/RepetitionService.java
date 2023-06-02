package com.teleychuk.gymnotepadchatbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
@Slf4j
public class RepetitionService {

    public SendMessage repetition(Update update) {

        long chatId = update.getMessage().getChatId();
        String messageText = update.getMessage().getText();

        SendMessage messageZero = new SendMessage();
        messageZero.setText("zero");

        if (messageText.equals("Десять")) {
            return sendMessage(chatId, "Ten", Keyboard.weightKeyboard());
        }
        if (messageText.equals("Двенадцать")) {
            return sendMessage(chatId, "Twelve", Keyboard.weightKeyboard());
        }
        if (messageText.equals("Пятнадцать.")) {
            return sendMessage(chatId, "Fifteen", Keyboard.weightKeyboard());
        }
        if (messageText.equals("назад.")) {
            return sendMessage(chatId, "Возврат в предыдущее меню...", Keyboard.weightKeyboard());
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
