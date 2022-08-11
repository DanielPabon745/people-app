package com.example.test.people.app.model.api.people;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private DateInfo dob;
    private DateInfo registered;
    private String phone;
    private String cell;
    private Id id;
    private Picture picture;
    private String nat;
}
