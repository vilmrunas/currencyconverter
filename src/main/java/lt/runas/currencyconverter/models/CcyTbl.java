package lt.runas.currencyconverter.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "CcyTbl")
@Entity
@Table(name = "CcyTbl")
public class CcyTbl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CcyNtry> ccyNtryList;

    public CcyTbl() {
    }

    @XmlElement(name = "CcyNtry")
    public List<CcyNtry> getCcyNtryList() {
        return ccyNtryList;
    }
    public void setCcyNtryList(List<CcyNtry> ccyNtryList) {
        this.ccyNtryList = ccyNtryList;
    }
}
