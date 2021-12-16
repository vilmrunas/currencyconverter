package lt.runas.currencyconverter.services;

import lt.runas.currencyconverter.models.CcyTbl;
import lt.runas.currencyconverter.models.FxRates;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class XmlDataService {

    public FxRates getXmlRates(String ccy, String dtFrom, String dtTo) {

        String tp = "lt";

        String url = "http://www.lb.lt//webservices/FxRates/FxRates.asmx/getFxRatesForCurrency" +
                     "?tp=" + tp + "&ccy=" + ccy + "&dtFrom=" + dtFrom + "&dtTo=" + dtTo;

        RestTemplate restTemplate = new RestTemplate();
        FxRates fxRates = restTemplate.getForObject(url, FxRates.class);

        return fxRates;
    }

    public CcyTbl getXmlNames() {

        String url = "http://www.lb.lt//webservices/FxRates/FxRates.asmx/getCurrencyList?";

        RestTemplate restTemplate = new RestTemplate();
        CcyTbl ccyTbl = restTemplate.getForObject(url, CcyTbl.class);

        return ccyTbl;
    }
}
