package com.example.test.people.app.service;

import com.example.test.people.app.cross.ActivityMapper;
import com.example.test.people.app.cross.Gender;
import com.example.test.people.app.cross.Nationality;
import com.example.test.people.app.model.ActivityResponse;
import com.example.test.people.app.model.PeopleResponse;
import com.example.test.people.app.model.api.activity.Activity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagementService {
    private final ActivityService activityService;
    private final PeopleService peopleService;

    private List<ActivityResponse> getActivities(int quantity) {
        ArrayList<Activity> activities = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            activities.add(activityService.getRandomActivity());
        }

        return activities.stream()
                .map(ActivityMapper::convertActivityToActivityResponse)
                .collect(Collectors.toList());
    }

    public List<PeopleResponse> getRandomData(Gender gender, String nationality, short peopleNumber, short activities) {
        return this.peopleService.getPeople(gender.label, nationality, peopleNumber).getResults().stream()
                .map(person -> PeopleResponse
                        .builder()
                        .name(person.getName().getFirst().concat(" ").concat(person.getName().getLast()))
                        .nationality(person.getNat())
                        .country(person.getLocation().getCountry())
                        .city(person.getLocation().getState().concat(" - ").concat(person.getLocation().getCity()))
                        .address(String.valueOf(person.getLocation().getStreet().getNumber()).concat(" - ").concat(person.getLocation().getStreet().getName()))
                        .activities((ArrayList<ActivityResponse>) getActivities(activities))
                        .build())
                .collect(Collectors.toList());
    }

    public List<PeopleResponse> getPeopleAndActivitiesByNationality(Gender gender, String nationality, short peopleNumber) {
        return this.peopleService.getPeople(gender.label, nationality, peopleNumber).getResults().stream()
                .map(person -> PeopleResponse
                        .builder()
                        .name(person.getName().getFirst().concat(" ").concat(person.getName().getLast()))
                        .nationality(person.getNat())
                        .country(person.getLocation().getCountry())
                        .city(person.getLocation().getState().concat(" - ").concat(person.getLocation().getCity()))
                        .address(String.valueOf(person.getLocation().getStreet().getNumber())
                                .concat(" - ").concat(person.getLocation().getStreet().getName()))
                        .activities(new ArrayList<>(Collections.singletonList(
                                ActivityMapper.convertActivityToActivityResponse(this.activityService.getActivityByParticipants(1)))))
                        .build())
                .collect(Collectors.groupingBy(PeopleResponse::getNationality))
                .values().stream()
                .map(peopleResponses -> peopleResponses
                        .stream()
                        .map(people -> {
                            people.getActivities()
                                    .add(ActivityMapper.convertActivityToActivityResponse(peopleResponses.size() > 1 ?
                                            this.activityService.getActivityByParticipants(peopleResponses.size()) :
                                            this.activityService.getRandomActivity()));
                            return people;
                        }).collect(Collectors.toList())
                ).flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}