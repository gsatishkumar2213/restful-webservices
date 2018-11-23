package com.example.restful_webservices.user.exception;

import java.util.Date;

/**
 * Created by gsati on 8/23/2018.
 */
public class ResponseResource {
    private Date date;
    private String message;
    private  String description;

    public ResponseResource(Date date, String message, String description) {
        this.date = date;
        this.message = message;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
