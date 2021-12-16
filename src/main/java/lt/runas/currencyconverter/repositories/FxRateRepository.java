package lt.runas.currencyconverter.repositories;

import lt.runas.currencyconverter.models.FxRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FxRateRepository extends JpaRepository<FxRate, Long> {
}
