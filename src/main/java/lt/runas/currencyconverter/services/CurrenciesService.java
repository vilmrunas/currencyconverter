package lt.runas.currencyconverter.services;

import lt.runas.currencyconverter.models.RatesJoinName;
import lt.runas.currencyconverter.repositories.CcyAmtRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrenciesService {

    private CcyAmtRepository ccyAmtRepository;

    public CurrenciesService(CcyAmtRepository ccyAmtRepository) {
        this.ccyAmtRepository = ccyAmtRepository;
    }

    public List<RatesJoinName> getCurrencies() {
        return ccyAmtRepository.getRatesJoinedName();
    }

    public double getConversionRate(String currency){
        return ccyAmtRepository.findByCcy(currency).getAmt();
    }

    public double calculate(double amount, double conversionRate) {
        double amountConverted = amount * conversionRate;
        return amountConverted;
    }
}
