package com.example.BookExc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = { "password" })
public class UserDTO implements Serializable {

    private String username;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String city;
    private String number;
    private String password;
}
