package pl.sda.exchangerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.sda.exchangerdemo.exchanger.Currency;
import pl.sda.exchangerdemo.exchanger.NbpExchangerRateDownloader;
import pl.sda.exchangerdemo.model.ExchangeResult;
import pl.sda.exchangerdemo.model.NbpExchangeRateResult;
import pl.sda.exchangerdemo.model.Status;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class CurrencyExchangeService {

    private NbpExchangerRateDownloader nbpExchangerRateDownloader;

    @Autowired
    public CurrencyExchangeService(NbpExchangerRateDownloader nbpExchangerRateDownloader) {
        this.nbpExchangerRateDownloader = nbpExchangerRateDownloader;
    }

    public ExchangeResult calculate(BigDecimal value, LocalDate exchangeDate) {
        NbpExchangeRateResult rateResult = nbpExchangerRateDownloader.download(exchangeDate, Currency.EURO);
        ExchangeResult exchangeResult=new ExchangeResult();
        if(rateResult.getStatus()== Status.SUCCESS) {
            BigDecimal calculatedVal = value.divide(rateResult.getBigDecimal(), RoundingMode.HALF_UP);
            exchangeResult.setCalculatedAmount(calculatedVal);
            exchangeResult.setHttpStatus(HttpStatus.OK);
            return exchangeResult;
        }
        exchangeResult.setHttpStatus(HttpStatus.BAD_REQUEST);
        exchangeResult.setErrorMessage(rateResult.getErrorMessage());
        return exchangeResult;
    }
}
