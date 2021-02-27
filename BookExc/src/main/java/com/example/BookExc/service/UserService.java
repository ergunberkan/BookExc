package com.example.BookExc.service;

import com.example.BookExc.domain.UsersDO;
import com.example.BookExc.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UsersRepo usersRepo;
    @Override
    public UsersDO createUsers(UsersDO users) {
        return usersRepo.save(users);
    }
}
