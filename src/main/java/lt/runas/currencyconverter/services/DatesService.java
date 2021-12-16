package lt.runas.currencyconverter.services;

import lt.runas.currencyconverter.models.FxRates;
import lt.runas.currencyconverter.models.RatesByDate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DatesService {

    private XmlDataService xmlDataService;

    public DatesService(XmlDataService xmlDataService) {
        this.xmlDataService = xmlDataService;
    }


    public List<RatesByDate> getRatesByDate(String ccy, String dtFrom, String dtTo) {
        FxRates fxRates = xmlDataService.getXmlRates(ccy, dtFrom, dtTo);
        int n = fxRates.getFxRateList().size();

        List<RatesByDate> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new RatesByDate(
                    fxRates.getFxRateList().get(i).getDt(),
                    fxRates.getFxRateList().get(i).getCcyAmt().getAmt()));
        }
        return list;
    }

    public String returnDateFrom(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateFrom = formatter.format(calendar.getTime());

        return dateFrom;
    }

    public String returnDateTo(){
        java.util.Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateTo = formatter.format(date);

        return dateTo;
    }
}
