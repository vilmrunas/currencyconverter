package lt.runas.currencyconverter.repositories;

import lt.runas.currencyconverter.models.CcyNtry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CcyNtryRepository extends JpaRepository<CcyNtry, Long> {
}
