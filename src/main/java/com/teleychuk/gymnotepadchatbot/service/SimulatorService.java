package com.teleychuk.gymnotepadchatbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
@Slf4j
public class SimulatorService {

    public SendMessage simulator(Update update) {

        long chatId = update.getMessage().getChatId();
        String messageText = update.getMessage().getText();

        SendMessage messageZero = new SendMessage();
        messageZero.setText("zero");

        if (messageText.equals("Вывести список")) {
            return sendMessage(chatId, "Output a list", Keyboard.approachKeyboard());
        }
        if (messageText.equals("Добавить новый")) {
            return sendMessage(chatId, "Add a new one", Keyboard.approachKeyboard());
        }
        if (messageText.equals("Удалить.")) {
            return sendMessage(chatId, "Delete", Keyboard.approachKeyboard());
        }
        if (messageText.equals("назад...")) {
            return sendMessage(chatId, "Возврат в предыдущее меню...", Keyboard.calendarKeyboard());
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
