package lt.runas.currencyconverter.repositories;

import lt.runas.currencyconverter.models.CcyTbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CcyTblRepository extends JpaRepository<CcyTbl, Long> {
}
