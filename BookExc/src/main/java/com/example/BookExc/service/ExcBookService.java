package com.example.BookExc.service;

import com.example.BookExc.domain.ExchangeBookDO;
import com.example.BookExc.domain.UsersDO;
import com.example.BookExc.repository.BookExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExcBookService implements InfExcBookService{
    @Autowired
    private BookExchangeRepo bookExchangeRepo;

    @Override
    public ExchangeBookDO createExchange(ExchangeBookDO createExchange) {
        return bookExchangeRepo.save(createExchange);
    }

    @Override
    public ExchangeBookDO updateExchange(ExchangeBookDO exchangeBookDO) {
        long ExcId=exchangeBookDO.getId();
        Optional<ExchangeBookDO> current=bookExchangeRepo.findById(ExcId);
        if (current.isPresent())
        {
         current.get().setSendingUserBook(exchangeBookDO.getSendingUserBook());
         current.get().setGettingUserBook(exchangeBookDO.getGettingUserBook());
         current.get().setGettingUserAddress(exchangeBookDO.getGettingUserAddress());
         current.get().setGettingUserAddress(exchangeBookDO.getGettingUserAddress());
         current.get().setSendingUserCity(exchangeBookDO.getSendingUserCity());
         bookExchangeRepo.save(current.get());
         return current.get();
        }
        return null;
    }

    @Override
    public void deleteExchange(Long exchangeNo) {
        Optional<ExchangeBookDO> current= bookExchangeRepo.findById(exchangeNo);
        if (current.isPresent())
        {
            bookExchangeRepo.deleteById(exchangeNo);
        }
    }

    @Override
    public ExchangeBookDO getExchange(Long id) {
        Optional<ExchangeBookDO> current = bookExchangeRepo.findById(id);
        if (current.isPresent()) {
            return current.get();
        }
        return null;
    }

    @Override
    public List<ExchangeBookDO> getAllExchange() {
        return bookExchangeRepo.findAll();
    }
}
