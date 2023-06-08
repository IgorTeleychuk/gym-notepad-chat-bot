package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "simulators")
public class Simulator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long simulatorId;
    @Column(name = "name")
    private String name;

//    @OneToMany
//    private List<Approach> approaches;
}
