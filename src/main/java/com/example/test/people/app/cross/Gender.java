package com.example.test.people.app.cross;

public enum Gender {
    M("male"), F("female");

    public final String label;

    private Gender(String label) {
        this.label = label;
    }
}
