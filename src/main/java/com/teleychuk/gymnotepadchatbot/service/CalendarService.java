package com.teleychuk.gymnotepadchatbot.service;

import com.teleychuk.gymnotepadchatbot.model.Calendar;
import com.teleychuk.gymnotepadchatbot.model.User;
import com.teleychuk.gymnotepadchatbot.repository.CalendarRepository;
import com.teleychuk.gymnotepadchatbot.repository.UserRepository;
import com.teleychuk.gymnotepadchatbot.util.CommonUtilities;
import com.teleychuk.gymnotepadchatbot.util.Day;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class CalendarService {

    private UserRepository userRepository;
    private CalendarRepository calendarRepository;

    public SendMessage calendar(Update update) {

        long chatId = update.getMessage().getChatId();
        String messageText = update.getMessage().getText();
        String sendText;

        SendMessage messageZero = new SendMessage();
        messageZero.setText("zero");

        if (messageText.equals("Сегодня")) {

            createCalendar(Day.TODAY, chatId);
            sendText = "Вы выбрали сегодня. Запись на " + CommonUtilities.dayOnKeyboardForAnswer(Day.TODAY) + " создана. Выберите тренажер: ";
            return sendMessage(chatId, sendText, Keyboard.simulatorKeyboard());

        } else if (messageText.equals("Вчера")) {

            createCalendar(Day.YESTERDAY, chatId);
            sendText = "Вы выбрали вчера. Запись на " + CommonUtilities.dayOnKeyboardForAnswer(Day.YESTERDAY) + " создана. Выберите тренажер: ";
            return sendMessage(chatId, sendText, Keyboard.simulatorKeyboard());

        } else if (messageText.equals("Позавчера")) {

            createCalendar(Day.DAY_BEFORE_YESTERDAY, chatId);
            sendText = "Вы выбрали позавчера. Запись на " + CommonUtilities.dayOnKeyboardForAnswer(Day.DAY_BEFORE_YESTERDAY) + " создана. Выберите тренажер: ";
            return sendMessage(chatId, sendText, Keyboard.simulatorKeyboard());

        } else if (messageText.equals("назад....")) {

            return sendMessage(chatId, "Возврат в предыдущее меню...", Keyboard.startKeyboard());

        }
        return messageZero;

    }

    public void createCalendar(Day day, Long chatId) {
        log.info("Create new Calendar for User with Id " + chatId);
        Optional<User> user = userRepository.findById(chatId);
        if (user.isPresent()) {
            Calendar calendar = new Calendar();
            calendar.setData(CommonUtilities.dayOnKeyboardForSystem(day));
            calendar.setOwner(user.get());

            calendarRepository.save(calendar);
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
