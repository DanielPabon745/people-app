package com.example.test.people.app.model.api.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {
    private Street street;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private Coordinate coordinates;
    private Timezone timezone;
}


