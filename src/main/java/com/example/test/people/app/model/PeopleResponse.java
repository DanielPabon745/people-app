package com.example.test.people.app.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class PeopleResponse {

    private String name;
    private String nationality;
    private String country;
    private String city;
    private String address;
    private ArrayList<ActivityResponse> activities;

}
