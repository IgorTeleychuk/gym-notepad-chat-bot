package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity(name = "repetitions")
public class Repetition {

    @Id
    private Long repetitionId;

    private Long quantityR;

    @OneToMany
    private List<Weight> weightList;
}
