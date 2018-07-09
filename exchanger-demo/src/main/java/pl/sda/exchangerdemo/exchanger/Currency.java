package pl.sda.exchangerdemo.exchanger;

public enum Currency {
    EURO("EUR");

    private String code;

    Currency(String code){
        this.code=code;
    }

    public String getCode() {
        return code;
    }
}
