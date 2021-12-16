package lt.runas.currencyconverter.controllers;

import lt.runas.currencyconverter.services.CurrenciesService;
import lt.runas.currencyconverter.services.DatesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HistoryController {

    private CurrenciesService currenciesService;
    private DatesService datesService;

    public HistoryController(CurrenciesService currenciesService, DatesService datesService) {
        this.currenciesService = currenciesService;
        this.datesService = datesService;
    }

    @GetMapping("history")
    public String listRatesByDate(Model model) {
        model.addAttribute("currencies", currenciesService.getCurrencies());
        return "currency_history_table";
    }

    @RequestMapping(value = "historydata", method = {RequestMethod.GET, RequestMethod.POST})
    public String listRatesByDate(@RequestParam String ccy, @RequestParam String dtFrom, @RequestParam String dtTo, Model model) {
        model.addAttribute("rates", datesService.getRatesByDate(ccy, dtFrom, dtTo));
        model.addAttribute("currencies", currenciesService.getCurrencies());
        model.addAttribute("ccy", ccy);
        model.addAttribute("dtFrom", dtFrom);
        model.addAttribute("dtTo", dtTo);
        return "currency_history_table";
    }
}
