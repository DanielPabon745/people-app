package com.example.test.people.app.model.api.people;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    String seed;
    int results;
    int page;
    String version;
}
