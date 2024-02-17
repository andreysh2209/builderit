package com.example.builderit.exceptions;


import lombok.Data;

import java.util.Date;

@Data
public class NotValidCredentials {
    public NotValidCredentials(Integer status, String messages) {
        this.status = status;
        this.messages = messages;
        this.date=new Date();
    }

    private Integer status;

    private  String messages;

    private Date date;


}
