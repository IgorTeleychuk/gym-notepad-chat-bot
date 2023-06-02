package com.teleychuk.gymnotepadchatbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
@Slf4j
public class WeightService {

    public SendMessage weight(Update update) {

        long chatId = update.getMessage().getChatId();
        String messageText = update.getMessage().getText();

        SendMessage messageZero = new SendMessage();
        messageZero.setText("zero");

        if (messageText.equals("Пять кг")) {
            return sendMessage(chatId, "Five kilo", Keyboard.weightKeyboard());
        }
        if (messageText.equals("Десять кг")) {
            return sendMessage(chatId, "Ten kilo", Keyboard.weightKeyboard());
        }
        if (messageText.equals("Пятнадцать кг")) {
            return sendMessage(chatId, "Fifteen kilo", Keyboard.weightKeyboard());
        }
        if (messageText.equals("Двадцать кг")) {
            return sendMessage(chatId, "Twenty kilo", Keyboard.weightKeyboard());
        }
        if (messageText.equals("Сохранить")) {
            return sendMessage(chatId, "Twenty kilo", Keyboard.weightKeyboard());
        }
        if (messageText.equals("Отмена")) {
            return sendMessage(chatId, "Запись отменена, вышли без сохранения...", Keyboard.startKeyboard());
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
