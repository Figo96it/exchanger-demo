package pl.sda.exchangerdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CurrencyTable {

    @JsonProperty
    private String table;
    @JsonProperty
    private String currency;
    @JsonProperty
    private String code;
    @JsonProperty
    private List<Rates> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rates> getRates() {
        return rates;
    }

    public void setRates(List<Rates> rates) {
        this.rates = rates;
    }
}
