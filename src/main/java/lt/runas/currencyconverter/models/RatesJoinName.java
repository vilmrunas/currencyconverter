package lt.runas.currencyconverter.models;

public class RatesJoinName {

    private String ccyNm;
    private String ccy;
    private double amt;

    public RatesJoinName() {
    }

    public RatesJoinName(String ccyNm, String ccy, double amt) {
        this.ccyNm = ccyNm;
        this.ccy = ccy;
        this.amt = amt;
    }

    public String getCcyNm() {
        return ccyNm;
    }
    public void setCcyNm(String ccyNm) {
        this.ccyNm = ccyNm;
    }

    public String getCcy() {
        return ccy;
    }
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public double getAmt() {
        return amt;
    }
    public void setAmt(double amt) {
        this.amt = amt;
    }
}
