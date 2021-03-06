package com.example.BookExc.Controller;

import com.example.BookExc.domain.ExchangeBookDO;
import com.example.BookExc.dto.ExchangeBookDTO;
import com.example.BookExc.service.IUserService;
import com.example.BookExc.service.InfExcBookService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("New add Book Exchange")
    @PostMapping(value = "/AddExchange")
    public ResponseEntity<ExchangeBookDTO> addExchange(@RequestBody ExchangeBookDO exchangeBookDO)
    {
        ExchangeBookDO addExc= bookService.createExchange(exchangeBookDO);
        return new ResponseEntity(addExc, HttpStatus.CREATED);
    }
    @ApiOperation("Update Book Exchange Information")
    @PutMapping(value = "/UpdateExchange",consumes = "application/json",produces = "application/json")
    public ResponseEntity<ExchangeBookDTO> updateExchange(@RequestBody ExchangeBookDO exchangeBookDO)
    {
        ExchangeBookDO updateExc= bookService.updateExchange(exchangeBookDO);
        return new ResponseEntity(updateExc,HttpStatus.CREATED);
    }
    @ApiOperation("Get Book Exchange Information by Book Exchange Id")
    @GetMapping("/Exchanges/{ExchangeNo}")
    public ResponseEntity<ExchangeBookDTO> getByIdExc(@PathVariable(value = "ExchangeNo") Long ExchangeNo)
    {
        ExchangeBookDO exchangeBookDO= bookService.getExchange(ExchangeNo);
        return new ResponseEntity(exchangeBookDO,HttpStatus.OK);
    }
    @ApiOperation("Get All Book Exchange Information")
    @GetMapping(value = "Exchanges")
    public ResponseEntity<List<ExchangeBookDTO>> getAllExchanges()
    {
       List<ExchangeBookDO> AllExchanges= bookService.getAllExchange();
        return new ResponseEntity(AllExchanges,HttpStatus.OK);
    }
    @ApiOperation("Delete Book Exchange Information by Book Exchanges ID")
    @DeleteMapping("/Exchanges/{ExchangeNo}")
    public ResponseEntity<ExchangeBookDTO> deleteByExchangeNo(@PathVariable(value = "ExchangeNo") Long ExchangeNo)
    {
       bookService.deleteExchange(ExchangeNo);
        return new ResponseEntity("Exchange with ExchangeNo :" + ExchangeNo +"deleted.",HttpStatus.OK);
    }

}
