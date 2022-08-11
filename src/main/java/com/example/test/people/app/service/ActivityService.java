package com.example.test.people.app.service;

import com.example.test.people.app.cross.Const;
import com.example.test.people.app.model.api.activity.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final RestTemplate restTemplate;

    public Activity getActivityByParticipants(int participants) {
        return this.restTemplate.getForObject(String.format(Const.PARTICIPANTS_URL, participants), Activity.class);
    }

    public Activity getRandomActivity() {
        return this.restTemplate.getForObject(Const.ACTIVITY_URL, Activity.class);
    }

}
