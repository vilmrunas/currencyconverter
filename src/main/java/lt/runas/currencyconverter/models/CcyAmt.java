package lt.runas.currencyconverter.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "CcyAmt")
public class CcyAmt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ccy;
    private double amt;

    public CcyAmt() {
    }

    @XmlElement(name = "Ccy")
    public String getCcy() {
        return ccy;
    }
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @XmlElement(name = "Amt")
    public double getAmt() {
        return amt;
    }
    public void setAmt(double amt) {
        this.amt = amt;
    }
}