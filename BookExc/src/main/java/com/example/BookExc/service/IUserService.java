package com.example.BookExc.service;

import com.example.BookExc.domain.UsersDO;

import java.util.List;

public interface IUserService {
    public UsersDO createUsers(UsersDO users);
    public UsersDO updateUsers(UsersDO users);
    public void deleteUsers(Long userId);
    public UsersDO getUsers(Long userId);
    public List<UsersDO> getAllUsers();

}
