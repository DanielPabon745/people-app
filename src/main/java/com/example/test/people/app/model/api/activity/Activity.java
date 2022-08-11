package com.example.test.people.app.model.api.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    String activity;
    String type;
    int participants;
    double price;
    String link;
    String key;
    double accessibility;
}
