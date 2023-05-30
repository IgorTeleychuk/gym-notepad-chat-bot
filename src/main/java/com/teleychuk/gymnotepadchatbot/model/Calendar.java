package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity(name = "calendar")
public class Calendar {

    @Id
    private Long calendarId;

    private LocalDate data;

    @OneToMany
    private List<Simulator> simulators;

}
