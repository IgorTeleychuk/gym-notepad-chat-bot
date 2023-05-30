package com.teleychuk.gymnotepadchatbot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {

    public static ReplyKeyboardMarkup calendarKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Сегодня");
        row.add("Вчера");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Позавчера");
        row.add("назад...");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup startKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Добавить");
        row.add("Изменить");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Посмотреть");
        row.add("Удалить");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup approachKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Три");
        row.add("Четыре");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Пять");
        row.add("Шесть");
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
        row.add("Двадцать");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }

    public static ReplyKeyboardMarkup weightKeyboard() {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup(); // создаем виртуальную клавиатуру

        List<KeyboardRow> keyboardRows = new ArrayList<>(); // создаем список рядов кнопок
        KeyboardRow row = new KeyboardRow(); // создаем ряд кнопок
        row.add("Пять");
        row.add("Десять");

        keyboardRows.add(row); // порядок добавления имеет значение

        row = new KeyboardRow();
        row.add("Пятнадцать");
        row.add("Двадцать");
        keyboardRows.add(row);

        keyboardMarkup.setKeyboard(keyboardRows); // сетим ряды

        return keyboardMarkup;
    }
}
