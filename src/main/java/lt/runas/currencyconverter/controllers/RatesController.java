package lt.runas.currencyconverter.controllers;

import lt.runas.currencyconverter.services.CurrenciesService;
import lt.runas.currencyconverter.services.DatabaseService;
import lt.runas.currencyconverter.services.DatesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RatesController {

    private CurrenciesService currenciesService;
    private DatesService datesService;
    private DatabaseService databaseService;

    public RatesController(CurrenciesService currenciesService, DatesService datesService, DatabaseService databaseService) {
        this.currenciesService = currenciesService;
        this.datesService = datesService;
        this.databaseService = databaseService;
    }

    @GetMapping("rates")
    public String listRates(Model model) {
        model.addAttribute("rates", currenciesService.getCurrencies());
        String dtFrom = datesService.returnDateFrom();
        String dtTo = datesService.returnDateTo();
        model.addAttribute("dtFrom", dtFrom);
        model.addAttribute("dtTo", dtTo);
        model.addAttribute("updateTime", databaseService.updateTime());
        return "currency_table";
    }

    @GetMapping()
    public String redirect()
    {
        return "redirect:/rates";
    }
}
