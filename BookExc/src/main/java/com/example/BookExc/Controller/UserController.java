package com.example.BookExc.Controller;


import com.example.BookExc.domain.UsersDO;
import com.example.BookExc.dto.UserDTO;
import com.example.BookExc.service.IUserService;
import com.example.BookExc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bookexc/v1")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @PostMapping(path = "/addUser", consumes = "application/json",produces = "application/json")
    public ResponseEntity<UserDTO> createUser(@RequestBody UsersDO usersDO){
        UsersDO createdUser= iUserService.createUsers(usersDO);
        return new ResponseEntity(createdUser, HttpStatus.CREATED);

    }




}
