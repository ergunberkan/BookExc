package com.example.BookExc.repository;

import com.example.BookExc.domain.ExchangeBookDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookExchangeRepo extends JpaRepository<ExchangeBookDO,Long> {

}
