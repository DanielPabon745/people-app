package com.example.test.people.app.cross;

public class Const {

    public final static String ACTIVITY_URL = "http://www.boredapi.com/api/activity";
    public final static String PEOPLE_URL = "https://randomuser.me/api";
    public final static String PARTICIPANTS_URL = ACTIVITY_URL + "?participants=%d";
    public final static String PEOPLE_PARAMS = PEOPLE_URL + "?results=%d&gender=%s&nat=%s";
}
