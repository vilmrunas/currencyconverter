package lt.runas.currencyconverter.services;

import lt.runas.currencyconverter.models.CcyAmt;
import lt.runas.currencyconverter.models.FxRates;
import lt.runas.currencyconverter.repositories.CcyAmtRepository;
import lt.runas.currencyconverter.repositories.CcyTblRepository;
import lt.runas.currencyconverter.repositories.FxRatesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class DatabaseService implements CommandLineRunner {

    private static final String CRON_EXPRESSION = "0 0 12 * * *";

    LocalDateTime currentDateTime = LocalDateTime.now();

    private XmlDataService xmlDataService;
    private FxRatesRepository fxRatesRepository;
    private CcyAmtRepository ccyAmtRepository;
    private CcyTblRepository ccyTblRepository;

    public DatabaseService(XmlDataService xmlDataService, FxRatesRepository fxRatesRepository, CcyAmtRepository ccyAmtRepository, CcyTblRepository ccyTblRepository) {
        this.xmlDataService = xmlDataService;
        this.fxRatesRepository = fxRatesRepository;
        this.ccyAmtRepository = ccyAmtRepository;
        this.ccyTblRepository = ccyTblRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        fxRatesRepository.save(xmlDataService.getXmlRates("","",""));
        ccyTblRepository.save(xmlDataService.getXmlNames());

    }

    @Scheduled(cron = CRON_EXPRESSION)
    void databaseUpdate() {
        FxRates fxRates = xmlDataService.getXmlRates("","", "");
        int n = fxRates.getFxRateList().size();

        String ccy;
        double amt;

        for(int i = 0; i < n; i++){
            ccy = fxRates.getFxRateList().get(i).getCcyAmt().getCcy();
            amt = fxRates.getFxRateList().get(i).getCcyAmt().getAmt();

            CcyAmt ccyAmt = ccyAmtRepository.findByCcy(ccy);
            ccyAmt.setAmt(amt);
            ccyAmtRepository.save(ccyAmt);
        }
        currentDateTime = LocalDateTime.now();
        System.out.println("Database updated: " + new Date());
    }

    public String updateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;
    }
}