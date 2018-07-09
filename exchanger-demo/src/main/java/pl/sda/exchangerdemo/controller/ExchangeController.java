package pl.sda.exchangerdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.exchangerdemo.model.ExchangeResult;
import pl.sda.exchangerdemo.service.CurrencyExchangeService;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class ExchangeController {

    private CurrencyExchangeService currencyExchangeService;

    @Autowired
    public ExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }


    @GetMapping("exchange/{value}/{date}")
    public ResponseEntity<ExchangeResult> getValueAndLocalDate(@PathVariable BigDecimal value,@PathVariable(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exchangeDate) {
        try {
            return ResponseEntity.ok(currencyExchangeService.calculate(value, exchangeDate));
        }catch(IndexOutOfBoundsException e){
            return ResponseEntity.notFound().build();
        }
    }
}
