package com.example.BookExc.Controller;

import com.example.BookExc.domain.ExchangeBookDO;
import com.example.BookExc.dto.ExchangeBookDTO;
import com.example.BookExc.service.IUserService;
import com.example.BookExc.service.InfExcBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookexc/exc")
public class ExchangeBookController {
    /**
     *
     */
    @Autowired
    private InfExcBookService bookService;

    @PostMapping(value = "/AddExchange")
    public ResponseEntity<ExchangeBookDTO> addExchange(@RequestBody ExchangeBookDO exchangeBookDO)
    {
        ExchangeBookDO addExc= bookService.createExchange(exchangeBookDO);
        return new ResponseEntity(addExc, HttpStatus.CREATED);
    }
    @PutMapping(value = "/UpdateExchange",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ExchangeBookDTO> updateExchange(@RequestBody ExchangeBookDO exchangeBookDO)
    {
        ExchangeBookDO updateExc= bookService.updateExchange(exchangeBookDO);
        return new ResponseEntity(updateExc,HttpStatus.CREATED);
    }
    @GetMapping("/Exchanges/{ExchangeNo}")
    public ResponseEntity<ExchangeBookDTO> getByIdExc(@PathVariable(value = "ExchangeNo") Long ExchangeNo)
    {
        ExchangeBookDO exchangeBookDO= bookService.getExchange(ExchangeNo);
        return new ResponseEntity(exchangeBookDO,HttpStatus.OK);
    }
    @GetMapping(value = "Exchanges",consumes = "application/json",produces = "application/json")
    public ResponseEntity<List<ExchangeBookDTO>> getAllExchanges()
    {
       List<ExchangeBookDO> AllExchanges= bookService.getAllExchange();
        return new ResponseEntity(AllExchanges,HttpStatus.OK);
    }
    @DeleteMapping("/Exchanges/{ExchangeNo}")
    public ResponseEntity<ExchangeBookDTO> deleteByExchangeNo(@PathVariable(value = "ExchangeNo") Long ExchangeNo)
    {
       bookService.deleteExchange(ExchangeNo);
        return new ResponseEntity("Exchange with ExchangeNo :" + ExchangeNo +"deleted.",HttpStatus.OK);
    }

}
