package com.example.BookExc.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    @JsonIgnore
    private String username;
    private String name;
    private String surname;
    private String email;
    @JsonIgnore
    private String address;
    @JsonIgnore
    private String city;
    private String number;

    @JsonIgnore
    private String password;
}
