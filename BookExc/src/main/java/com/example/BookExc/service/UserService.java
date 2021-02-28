package com.example.BookExc.service;

import com.example.BookExc.domain.UsersDO;
import com.example.BookExc.dto.UserDTO;
import com.example.BookExc.repository.UsersRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UsersRepo usersRepo;
    @Override
    public UsersDO createUsers(UsersDO users) {
        return usersRepo.save(users);
    }

    @Override
    public UsersDO updateUsers(UsersDO users) {
        long Usersid=users.getId();
        Optional<UsersDO> currentUser=usersRepo.findById(Usersid);
        if(currentUser.isPresent())
        {
            currentUser.get().setUser_name(users.getUser_name());
            currentUser.get().setName(users.getName());
            currentUser.get().setSur_name(users.getSur_name());
            currentUser.get().setAddress(users.getAddress());
            currentUser.get().setCity(users.getCity());
            currentUser.get().setNumber(users.getNumber());
            currentUser.get().setPassword(users.getPassword());
            currentUser.get().setEmail(users.getEmail());
            usersRepo.save(currentUser.get());
            return currentUser.get();
        }
        return null;
    }

    @Override
    public void deleteUsers(Long userId) {
        Optional<UsersDO> currentUser = usersRepo.findById(userId);
        if (currentUser.isPresent()) {
            usersRepo.deleteById(userId);
        }

    }

    @Override
    public UsersDO getUsers(Long userId) {
        Optional<UsersDO> currentCustomer = usersRepo.findById(userId);
        if (currentCustomer.isPresent()) {
            return currentCustomer.get();
        }
        return null;
    }

    @Override
    public List<UsersDO> getAllUsers() {
        return usersRepo.findAll();
    }
}
