package com.example.test.people.app.service;

import com.example.test.people.app.cross.Const;
import com.example.test.people.app.model.api.people.People;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PeopleService {

    private final RestTemplate restTemplate;

    public People getPeople(String gender, String nationality, int people) {
        return this.restTemplate.getForObject(String.format(Const.PEOPLE_PARAMS, people, gender, nationality),
                People.class);
    }
}
