package com.teleychuk.gymnotepadchatbot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class Keyboard {

    public static ReplyKeyboardMarkup startKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Добавить запись");
        row.add("Изменить запись");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Посмотреть запись");
        row.add("Удалить запись");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup calendarKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Сегодня");
        row.add("Вчера");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Позавчера");
        row.add("назад....");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup simulatorKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Вывести список");
        row.add("Добавить новый");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Удалить.");
        row.add("назад...");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup approachKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Три");
        row.add("Пять");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Шесть");
        row.add("назад..");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup repetitionKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Десять");
        row.add("Двенадцать");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Пятнадцать");
        row.add("назад.");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup weightKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Пять кг");
        row.add("Десять кг");
        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Пятнадцать кг");
        row.add("Двадцать кг");
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add("Сохранить");
        row.add("Отмена");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }
}
