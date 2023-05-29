package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "weight")
public class Weight {

    @Id
    private Long weightId;

    private Long weight;

    private Long repetitionId;
}
