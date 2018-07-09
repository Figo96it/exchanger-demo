package pl.sda.exchangerdemo.exchanger;

import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class InitApp {

    public static void main(String[] args) {
        NbpExchangerRateDownloader nbpExchangerRateDownloader=new NbpExchangerRateDownloader(new RestTemplate());
        nbpExchangerRateDownloader.download(LocalDate.parse("2016-07-06"), pl.sda.exchangerdemo.exchanger.Currency.EURO);
    }
}
