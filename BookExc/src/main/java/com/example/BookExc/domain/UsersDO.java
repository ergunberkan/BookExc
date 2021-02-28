package com.example.BookExc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Users")
public class UsersDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String user_name;
    private String name;
    private String sur_name;
    private String email;
    private String address;
    private String city;
    private String number;
    private String password;


}
