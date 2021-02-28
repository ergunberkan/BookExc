package com.example.BookExc.dto;


import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
public class ExchangeBookDTO implements Serializable {
    private String SendingUsername;
    private String GettingUsername;
    private String SendingUserAddress;
    private String SendingUserCity;
    private String GettingUserAddress;
    private String GettingUserCity;
    private String SendingUserPhone;
    private String GettingUserPhone;
    private String SendingUserBook;
    private String GettingUserBook;

}
