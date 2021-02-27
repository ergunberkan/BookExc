package com.example.BookExc.Controller;


import com.example.BookExc.domain.UsersDO;
import com.example.BookExc.dto.UserDTO;
import com.example.BookExc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PutMapping(path = "/update", consumes = "application/json",produces = "application/json")
    public ResponseEntity<UsersDO> updateUser(@RequestBody UsersDO usersDO)
    {
        UsersDO updatedUsers=iUserService.updateUsers(usersDO);
        return new ResponseEntity<>(updatedUsers,HttpStatus.CREATED);
    }

    @GetMapping(path = "/users/{userId}")
    public ResponseEntity<UsersDO> getUsers(@PathVariable(value = "userId") Long userId) {
        UsersDO user = iUserService.getUsers(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<List<UsersDO>> getAllUsers()
    {
        List<UsersDO> allUsers=iUserService.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
    @DeleteMapping(path = "/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") Long userId) {
        iUserService.deleteUsers(userId);
        return new ResponseEntity<>("Customer with id: " + userId + " is deleted.", HttpStatus.OK);
    }
    }

