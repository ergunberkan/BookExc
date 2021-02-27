package com.example.BookExc.repository;

import com.example.BookExc.domain.UsersDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<UsersDO,Long> {

}
