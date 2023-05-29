package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "repetitions")
public class Repetition {

    @Id
    private Long repetitionId;

    private Long quantityR;

    private Long approachId;
}
