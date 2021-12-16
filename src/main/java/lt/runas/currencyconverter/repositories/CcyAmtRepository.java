package lt.runas.currencyconverter.repositories;

import lt.runas.currencyconverter.models.CcyAmt;
import lt.runas.currencyconverter.models.RatesJoinName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CcyAmtRepository extends JpaRepository<CcyAmt, Long> {

    CcyAmt findByCcy(String value);

    @Query("Select new lt.runas.currencyconverter.models.RatesJoinName(b.ccyNm, a.ccy, a.amt) From CcyAmt a Join CcyNtry b On a.ccy = b.ccy")
    List<RatesJoinName> getRatesJoinedName();
}
