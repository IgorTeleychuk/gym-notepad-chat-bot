package com.teleychuk.gymnotepadchatbot.service;

import com.teleychuk.gymnotepadchatbot.model.User;
import com.teleychuk.gymnotepadchatbot.repository.UserRepository;
import com.vdurmont.emoji.EmojiParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.sql.Timestamp;

@Component
@Slf4j
public class StartService  {

    @Autowired
    private UserRepository userRepository;

    public SendMessage start(Update update) {

        long chatId = update.getMessage().getChatId();
        String messageText = update.getMessage().getText();

        SendMessage messageZero = new SendMessage();
        messageZero.setText("zero");

        registerUser(update.getMessage());

        if (messageText.equals("/start")) {
            return startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
        }
        if (messageText.equals("Добавить запись")) {
            String sendText = "Выбран раздел добавить запись. Какой день вас интересует?";
            return sendMessage(chatId, sendText, Keyboard.calendarKeyboard());
        }
        if (messageText.equals("Изменить запись")) {
            return sendMessage(chatId, "You have selected change", Keyboard.calendarKeyboard());
        }
        if (messageText.equals("Посмотреть запись")) {
            return sendMessage(chatId, "You have selected show", Keyboard.calendarKeyboard());
        }
        if (messageText.equals("Удалить запись")) {
            return sendMessage(chatId, "You have selected delete", Keyboard.calendarKeyboard());
        }
        return messageZero;
    }

    private SendMessage startCommandReceived(long chatId, String firstName) {
        String textToSend = EmojiParser.parseToUnicode("Привет, " + firstName + ", Приятно познакомиться!" + " :blush:");
        log.info("Replied to user: " + firstName);
        return sendMessage(chatId, textToSend, Keyboard.startKeyboard());
    }

    private SendMessage sendMessage(long chatId, String textToSend, ReplyKeyboardMarkup keyboardMarkup) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        message.setReplyMarkup(keyboardMarkup);

        return message;
    }

    private void registerUser(Message msg) {
        if (userRepository.findById(msg.getChatId()).isEmpty()) { // проверяем существует ли
            var chatId = msg.getChatId(); // достаем данные
            var chat = msg.getChat();

            User user = new User(); // создаем нового пользователя

            user.setChatId(chatId); // присваиваем значения
            user.setFirstName(chat.getFirstName());
            user.setLastName(chat.getLastName());
            user.setUserName(chat.getUserName());
            user.setRegisteredAt(new Timestamp(System.currentTimeMillis())); // точка времени создания нового пользователя

            userRepository.save(user);
            log.info("User saved: " + user);

        }
    }
}
