package pl.sda.exchangerdemo.model;

import java.math.BigDecimal;

public class NbpExchangeRateResult {

    private BigDecimal bigDecimal;
    private Status status;
    private String errorMessage;

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public Status getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }


}
