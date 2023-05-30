package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity(name = "approaches")
public class Approach {

    @Id
    private Long approachId;

    private Long quantityA;

    @OneToMany
    private List<Repetition> repetitions;

}
