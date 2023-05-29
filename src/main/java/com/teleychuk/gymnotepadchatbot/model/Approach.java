package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity(name = "approachs")
public class Approach {

    @Id
    private Long approachId;

    private Long quantityA;

    private Long simulatorId;

}
