package pl.sda.exchangerdemo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

public class ExchangeResult {

    private BigDecimal calculatedAmount;
    private String errorMessage;
    private HttpStatus httpStatus;

    public BigDecimal getCalculatedAmount() {
        return calculatedAmount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setCalculatedAmount(BigDecimal calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
