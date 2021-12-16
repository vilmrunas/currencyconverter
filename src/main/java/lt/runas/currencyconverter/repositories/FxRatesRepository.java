package lt.runas.currencyconverter.repositories;

import lt.runas.currencyconverter.models.FxRates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FxRatesRepository extends JpaRepository<FxRates, Long> {
}
