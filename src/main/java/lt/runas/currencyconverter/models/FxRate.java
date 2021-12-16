package lt.runas.currencyconverter.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "FxRate")
public class FxRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tp;
    private String dt;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private CcyAmt ccyAmt;

    public FxRate() {
    }

    @XmlElement(name = "Tp")
    public String getTp() {
        return tp;
    }
    public void setTp(String tp) {
        this.tp = tp;
    }

    @XmlElement(name = "Dt")
    public String getDt() {
        return dt;
    }
    public void setDt(String dt) {
        this.dt = dt;
    }

    @XmlElement(name = "CcyAmt")
    public CcyAmt getCcyAmt() {
        return ccyAmt;
    }
    public void setCcyAmt(CcyAmt ccyAmt) {
        this.ccyAmt = ccyAmt;
    }
}