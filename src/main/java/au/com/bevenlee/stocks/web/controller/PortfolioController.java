package au.com.bevenlee.stocks.web.controller;

import au.com.bevenlee.stocks.model.Portfolio;
import au.com.bevenlee.stocks.service.PortfolioService;
import au.com.bevenlee.stocks.web.form.PortfolioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Beven on 13/03/14.
 */
@Controller
public class PortfolioController {

    private static final String COMMAND_NAME = "portfolioForm";
    private static final String MODEL_NAME = "portfolios";
    private static final String VIEW_NAME = "portfolios";

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value = "/portfolios", method = RequestMethod.GET)
    public ModelAndView listPortfolios() {
        ModelAndView modelAndView = getModelAndView(VIEW_NAME);
        modelAndView.addObject(COMMAND_NAME, new PortfolioForm());
        return modelAndView;
    }

    private ModelAndView getModelAndView(String viewName) {
        List<Portfolio> portfolios = portfolioService.listPortfolios();
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(MODEL_NAME, portfolios);
        return modelAndView;
    }

    @RequestMapping(value = "/portfolios", method = RequestMethod.POST)
    public ModelAndView addPortfolio(@ModelAttribute(COMMAND_NAME) @Valid PortfolioForm portfolioForm, BindingResult result) {
        if(!result.hasErrors()) {
            String portfolioName = portfolioForm.getName();
            Portfolio portfolio = new Portfolio(portfolioName);
            portfolioService.addPortfolio(portfolio);
            return new ModelAndView("redirect:" + VIEW_NAME);
        }
        return getModelAndView(VIEW_NAME);
    }
}
