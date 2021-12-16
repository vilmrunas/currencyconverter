package lt.runas.currencyconverter.controllers;

import lt.runas.currencyconverter.services.CurrenciesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private CurrenciesService currenciesService;

    public CalculatorController(CurrenciesService currenciesService) {
        this.currenciesService = currenciesService;
    }

    @RequestMapping(value = "calculator", method = {RequestMethod.GET, RequestMethod.POST})
    public String calculator(@RequestParam String ccy, Model model) {
        model.addAttribute("currencies", currenciesService.getCurrencies());
        model.addAttribute("ccy", ccy);
        return "currency_calculator";
    }


    @RequestMapping(value = "calculated", method = {RequestMethod.GET, RequestMethod.POST})
    public String calculated(@RequestParam double amount, @RequestParam String ccy, Model model) {
        double conversionRate = currenciesService.getConversionRate(ccy);
        model.addAttribute("currencies", currenciesService.getCurrencies());
        model.addAttribute("amountConverted", currenciesService.calculate(amount, conversionRate));
        model.addAttribute("conversionRate", conversionRate);
        model.addAttribute("ccy", ccy);
        model.addAttribute("amount", amount);
        return "currency_calculator";
    }
}
