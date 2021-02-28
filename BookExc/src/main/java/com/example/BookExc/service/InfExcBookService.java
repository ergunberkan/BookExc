package com.example.BookExc.service;

import com.example.BookExc.domain.ExchangeBookDO;

import java.util.List;

public interface InfExcBookService {
    public ExchangeBookDO createExchange(ExchangeBookDO exchangeBookDO);
    public ExchangeBookDO updateExchange(ExchangeBookDO exchangeBookDO);
    public void deleteExchange(Long id);
    public ExchangeBookDO getExchange(Long id);
    public List<ExchangeBookDO> getAllExchange();
}
