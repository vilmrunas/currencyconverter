package lt.runas.currencyconverter.models;

public class RatesByDate {

    private String date;
    private double rateValue;

    public RatesByDate(String date, double rateValue) {
        this.date = date;
        this.rateValue = rateValue;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public double getRateValue() {
        return rateValue;
    }
    public void setRateValue(double rateValue) {
        this.rateValue = rateValue;
    }
}
