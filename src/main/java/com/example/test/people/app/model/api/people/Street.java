package com.example.test.people.app.model.api.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Street implements Serializable {
    private int number;
    private String name;
}