package com.example.test.people.app.model.api.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timezone {
    private String offset;
    private String description;
}
