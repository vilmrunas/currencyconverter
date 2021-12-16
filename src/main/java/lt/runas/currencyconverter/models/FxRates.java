package lt.runas.currencyconverter.models;;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "FxRates")
@Entity
@Table(name = "FxRates")
public class FxRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FxRate> fxRateList;

    public FxRates() {
    }

    @XmlElement(name = "FxRate")
    public List<FxRate> getFxRateList() {
        return fxRateList;
    }
    public void setFxRateList(List<FxRate> fxRateList) {
        this.fxRateList = fxRateList;
    }
}