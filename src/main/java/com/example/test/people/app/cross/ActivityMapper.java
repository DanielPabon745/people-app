package com.example.test.people.app.cross;

import com.example.test.people.app.model.ActivityResponse;
import com.example.test.people.app.model.api.activity.Activity;

public class ActivityMapper {

    public static ActivityResponse convertActivityToActivityResponse(Activity activity) {
        return ActivityResponse.builder()
                .activityType(activity.getType())
                .activityName(activity.getActivity())
                .participants(String.valueOf(activity.getParticipants()))
                .build();
    }
}
