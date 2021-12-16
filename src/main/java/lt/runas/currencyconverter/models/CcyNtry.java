package lt.runas.currencyconverter.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "CcyNtry")
public class CcyNtry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ccy;
    private String ccyNm;
    private String ccyNbr;
    private String ccyMnrUnts;

    public CcyNtry() {
    }

    @XmlElement(name = "Ccy")
    public String getCcy() {
        return ccy;
    }
    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @XmlElement(name = "CcyNm")
    public String getCcyNm() {
        return ccyNm;
    }
    public void setCcyNm(String ccyNm) {
        this.ccyNm = ccyNm;
    }

    @XmlElement(name = "CcyNbr")
    public String getCcyNbr() {
        return ccyNbr;
    }
    public void setCcyNbr(String ccyNbr) {
        this.ccyNbr = ccyNbr;
    }

    @XmlElement(name = "CcyMnrUnts")
    public String getCcyMnrUnts() {
        return ccyMnrUnts;
    }
    public void setCcyMnrUnts(String ccyMnrUnts) {
        this.ccyMnrUnts = ccyMnrUnts;
    }
}
