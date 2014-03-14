package au.com.bevenlee.stocks.web.controller;

import au.com.bevenlee.stocks.model.Portfolio;
import au.com.bevenlee.stocks.service.PortfolioService;
import au.com.bevenlee.stocks.web.form.PortfolioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Beven on 13/03/14.
 */
@Controller
public class PortfolioController {

    private static final String COMMAND_NAME = "portfolio-form";
    private static final String MODEL_NAME = "portfolios";
    private static final String VIEW_NAME = "portfolios";

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value = "/portfolios")
    public ModelAndView listPortfolios() {
        List<Portfolio> portfolios = portfolioService.listPortfolios();
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put(MODEL_NAME, portfolios);
        model.put(COMMAND_NAME, new PortfolioForm());
        return new ModelAndView(VIEW_NAME, model);
    }

    @RequestMapping(value = "/addPortfolio", method = RequestMethod.POST)
    public String addPortfolio(@ModelAttribute(COMMAND_NAME) PortfolioForm portfolioForm, BindingResult result) {
        String portfolioName = portfolioForm.getName();
        Portfolio portfolio = new Portfolio(portfolioName);
        portfolioService.addPortfolio(portfolio);
        return "redirect:" + VIEW_NAME;
    }
}
