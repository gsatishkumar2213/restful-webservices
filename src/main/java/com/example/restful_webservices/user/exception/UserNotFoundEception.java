package com.example.restful_webservices.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by gsati on 8/23/2018.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundEception extends RuntimeException {
    public UserNotFoundEception(String s) {
        super(s);
    }
}
