package com.example.test.people.app.model.api.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class People implements Serializable {
    ArrayList<Person> results;
    Info info;
}
