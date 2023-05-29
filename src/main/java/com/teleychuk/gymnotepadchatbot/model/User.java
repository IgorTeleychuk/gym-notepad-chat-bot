package com.teleychuk.gymnotepadchatbot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity(name = "users")
public class User {

    @Id
    private Long chatId;

    private String firstName;

    private String lastName;

    private String userName;

    private Timestamp registeredAt;
}
