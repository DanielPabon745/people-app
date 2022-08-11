package com.example.test.people.app.controller;

import com.example.test.people.app.cross.Gender;
import com.example.test.people.app.cross.Nationality;
import com.example.test.people.app.model.PeopleResponse;
import com.example.test.people.app.service.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/app")
@RequiredArgsConstructor
public class AppController {

    private final ManagementService managementService;

    @GetMapping(value = "/people")
    public ResponseEntity<List<PeopleResponse>> getRandomPeopleAndActivities(
            @RequestParam(value = "gender") @Valid Gender gender,
            @RequestParam(value = "nationality")
            @NotBlank(message = "Must have at least one of these values AU, BR, CA, CH, DE, " +
                    "DK, ES, FI, FR, GB, IE, IN, IR, MX, NL, NO, NZ, RS, TR, UA, US")
                    String nationality,
            @RequestParam(value = "people")
            @Min(value = 1, message = "People number between 1 and 10")
            @Max(value = 10, message = "People number between 1 and 10")
                    Short peopleNumber,
            @RequestParam(value = "activities")
            @Min(value = 1, message = "People number between 1 and 3")
            @Max(value = 3, message = "People number between 1 and 3")
                    Short activities
    ) {
        return ResponseEntity.ok(this.managementService.getRandomData(gender, nationality, peopleNumber, activities));
    }

    @GetMapping(value = "/people-nationality")
    public ResponseEntity<List<PeopleResponse>> getPeopleAndActivitiesByNationality(
            @RequestParam(value = "gender") @Valid Gender gender,
            @RequestParam(value = "nationality")
            @NotBlank(message = "Must have at least one of these values AU, BR, CA, CH, DE, " +
                    "DK, ES, FI, FR, GB, IE, IN, IR, MX, NL, NO, NZ, RS, TR, UA, US")
                    String nationality,
            @Min(value = 1, message = "People number between 1 and 10")
            @Max(value = 10, message = "People number between 1 and 10")
            @RequestParam(value = "people") short peopleNumber
    ) {
        return ResponseEntity.ok(this.managementService.getPeopleAndActivitiesByNationality(gender, nationality, peopleNumber));
    }


}
