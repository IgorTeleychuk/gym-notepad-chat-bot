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

            if (!startService.start(update).getText().equals("zero")) {
                executeMessage(startService.start(update));
            }
            if (!calendarService.calendar(update).getText().equals("zero")) {
                executeMessage(calendarService.calendar(update));
            }
            if (!simulatorService.simulator(update).getText().equals("zero")) {
                executeMessage(simulatorService.simulator(update));
            }
            if (!approachService.approach(update).getText().equals("zero")) {
                executeMessage(approachService.approach(update));
            }
            if (!repetitionService.repetition(update).getText().equals("zero")) {
                executeMessage(repetitionService.repetition(update));
            }
            if (!weightService.weight(update).getText().equals("zero")) {
                executeMessage(weightService.weight(update));
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
