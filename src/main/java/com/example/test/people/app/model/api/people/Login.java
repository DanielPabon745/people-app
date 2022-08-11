package com.example.test.people.app.model.api.people;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Login {
    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;
}
