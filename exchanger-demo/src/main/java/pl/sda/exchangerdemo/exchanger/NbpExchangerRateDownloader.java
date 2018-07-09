package pl.sda.exchangerdemo.exchanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.sda.exchangerdemo.model.CurrencyTable;
import pl.sda.exchangerdemo.model.NbpExchangeRateResult;
import pl.sda.exchangerdemo.model.Status;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class NbpExchangerRateDownloader {

    private RestTemplate restTemplate;
    private static final String NBP_API_URL="http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{date}/";

    @Autowired
    public NbpExchangerRateDownloader(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }


    public NbpExchangeRateResult download(LocalDate date,Currency currency){
        Map<String,String> params=new HashMap<>();
        params.put("table","A");
        params.put("code",currency.getCode());
        params.put("date",date.toString());

        NbpExchangeRateResult nbpExchangeRateResult = new NbpExchangeRateResult();
        try {
            CurrencyTable currencyTable = restTemplate.getForObject(NBP_API_URL, CurrencyTable.class, params);
            nbpExchangeRateResult.setBigDecimal(currencyTable.getRates().stream().findFirst().get().getMid());
            nbpExchangeRateResult.setStatus(Status.SUCCESS);
            return nbpExchangeRateResult;
        }catch(HttpClientErrorException e){
            if(e.getStatusCode()== HttpStatus.BAD_REQUEST && e.getStatusText().equals("B³êdny zakres dat / Invalid date range")){
                nbpExchangeRateResult.setStatus(Status.FAILURE);
                nbpExchangeRateResult.setErrorMessage("Upss! Coś poszło nie tak!");
            }
        }
        return nbpExchangeRateResult;
    }




}
