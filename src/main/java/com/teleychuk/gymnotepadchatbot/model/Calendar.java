package com.teleychuk.gymnotepadchatbot.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "calendar")
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "calendarId")
    private Long calendarId;
    @Column(name = "data")
    private LocalDate data;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerId", referencedColumnName = "chatId")
    private User owner;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "simulatorId")
    private List<Simulator> simulators;

    public Calendar() {

    }

    @Override
    public String toString() {
        return "Calendar{" +
                "calendarId=" + calendarId +
                ", data=" + data +
                ", owner=" + owner +
                ", simulators=" + simulators +
                '}';
    }
}
