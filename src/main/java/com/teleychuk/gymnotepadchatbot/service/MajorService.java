package com.teleychuk.gymnotepadchatbot.service;

import com.teleychuk.gymnotepadchatbot.config.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class MajorService extends TelegramLongPollingBot {
    final BotConfig config;

    @Autowired
    private StartService startService;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private SimulatorService simulatorService;

    @Autowired
    private ApproachService approachService;

    @Autowired
    private  RepetitionService repetitionService;

    @Autowired
    private  WeightService weightService;


    public MajorService(BotConfig config) {
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")
                    || messageText.equals("Добавить запись")
                    || messageText.equals("Изменить запись")
                    || messageText.equals("Посмотреть запись")
                    || messageText.equals("Удалить запись")) {
                executeMessage(startService.start(update));
            } else if (messageText.equals("Сегодня")
                    || messageText.equals("Вчера")
                    || messageText.equals("Позавчера")
                    || messageText.equals("назад....")) {
                executeMessage(calendarService.calendar(update));
            } else if (messageText.equals("Вывести список")
                    || messageText.equals("Добавить новый")
                    || messageText.equals("Удалить.")
                    || messageText.equals("назад...")) {
                executeMessage(simulatorService.simulator(update));
            } else if (messageText.equals("Три")
                    || messageText.equals("Пять")
                    || messageText.equals("Шесть")
                    || messageText.equals("назад..")) {
                executeMessage(approachService.approach(update));
            } else if (messageText.equals("Десять")
                    || messageText.equals("Двенадцать")
                    || messageText.equals("Пятнадцать.")
                    || messageText.equals("назад.")) {
                executeMessage(repetitionService.repetition(update));
            } else if (messageText.equals("Пять кг")
                    || messageText.equals("Десять кг")
                    || messageText.equals("Пятнадцать кг")
                    || messageText.equals("Двадцать кг")
                    || messageText.equals("Сохранить")
                    || messageText.equals("Отмена")) {
                executeMessage(weightService.weight(update));
            } else {
                prepareAndSendMessage(chatId, "Данной команды не существует! Пожалуйста, придерживайтесь кнопок меню!");
            }
        }
    }

    private void prepareAndSendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId)); // странно, но получаем long, а присваиваем для отправки string
        message.setText(textToSend);
        executeMessage(message);
    }

    private void executeMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error("Error occured: " + e.getMessage());
        }
    }


}
