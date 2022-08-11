package com.example.test.people.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivityResponse {

    private String activityName;
    private String activityType;
    private String participants;

}
