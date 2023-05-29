package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "calendar")
public class Calendar {

    @Id
    private Long calendarId;

    private LocalDate data;

    private Long chatId;

}
