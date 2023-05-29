package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "simulators")
public class Simulator {

    @Id
    private Long simulatorId;

    private String name;

    private Long calendarId;
}
