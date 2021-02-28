package com.example.BookExc.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exchangeBook")
public class ExchangeBookDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String SendingUsername;
    private String SendingName;
    private String SendingSurname;
    private String GettingUsername;
    private String GettingName;
    private String GettingSurname;
    private String SendingUserAddress;
    private String SendingUserCity;
    private String GettingUserAddress;
    private String GettingUserCity;
    private String SendingUserPhone;
    private String GettingUserPhone;
    private String SendingUserBook;
    private String GettingUserBook;
}
