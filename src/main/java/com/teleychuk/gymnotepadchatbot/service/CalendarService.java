package com.teleychuk.gymnotepadchatbot.service;

import com.teleychuk.gymnotepadchatbot.model.Calendar;
import com.teleychuk.gymnotepadchatbot.model.User;
import com.teleychuk.gymnotepadchatbot.repository.UserRepository;
import com.teleychuk.gymnotepadchatbot.util.CommonUtilities;
import com.teleychuk.gymnotepadchatbot.util.Day;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class CalendarService {

    @Autowired
    private UserRepository userRepository;

    public SendMessage calendar(Update update) {

        long chatId = update.getMessage().getChatId();
        String messageText = update.getMessage().getText();
        String sendText;

        SendMessage messageZero = new SendMessage();
        messageZero.setText("zero");

        if (messageText.equals("Сегодня")) {
            createCalendar(update, Day.TODAY);
            sendText = "Вы выбрали сегодня. Запись на " + CommonUtilities.dayOnKeyboardForAnswer(Day.TODAY) + " открыта. Выберите тренажер: ";
            return sendMessage(chatId, sendText, Keyboard.simulatorKeyboard());
        }
        if (messageText.equals("Вчера")) {
            createCalendar(update, Day.YESTERDAY);
            sendText = "Вы выбрали сегодня. Запись на " + CommonUtilities.dayOnKeyboardForAnswer(Day.YESTERDAY) + " открыта. Выберите тренажер: ";
            return sendMessage(chatId, sendText, Keyboard.simulatorKeyboard());
        }
        if (messageText.equals("Позавчера")) {
            createCalendar(update, Day.DAY_BEFORE_YESTERDAY);
            sendText = "Вы выбрали позавчера. Запись на " + CommonUtilities.dayOnKeyboardForAnswer(Day.DAY_BEFORE_YESTERDAY) + " открыта. Выберите тренажер: ";
            return sendMessage(chatId, sendText, Keyboard.simulatorKeyboard());
        }
        if (messageText.equals("назад....")) {
            return sendMessage(chatId, "Возврат в предыдущее меню...", Keyboard.startKeyboard());
        }
        return messageZero;

    }

    private void createCalendar(Update update, Day day) {
        if (userRepository.findById(update.getMessage().getChatId()).isPresent()) {
            Calendar calendar = new Calendar();
            calendar.setData(CommonUtilities.dayOnKeyboardForSystem(day));
            Optional<User> user = userRepository.findById(update.getMessage().getChatId());
            List<Calendar> calendarList = user.get().getCalendar();
            user.get().setCalendar(calendarList);
        }
    }

    private SendMessage sendMessage(long chatId, String textToSend, ReplyKeyboardMarkup keyboardMarkup) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        message.setReplyMarkup(keyboardMarkup);

        return message;
    }
}
