package au.com.bevenlee.stocks.web.controller;

import au.com.bevenlee.stocks.model.Portfolio;
import au.com.bevenlee.stocks.service.PortfolioService;
import au.com.bevenlee.stocks.web.form.PortfolioForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    private static final String PORTFOLIO_LIST_VIEW_NAME = "portfolios";
    private static final String PORTFOLIO_EDIT_VIEW_NAME = "editPortfolio";

    @Autowired
    private PortfolioService portfolioService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioController.class);

    @RequestMapping(value = "/portfolios", method = RequestMethod.GET)
    public ModelAndView listPortfolios() {
        LOGGER.debug("Entering PortfolioController portfolios page");
        ModelAndView modelAndView = getModelAndView(PORTFOLIO_LIST_VIEW_NAME);
        modelAndView.addObject(COMMAND_NAME, new PortfolioForm());
        return modelAndView;
    }

    @RequestMapping(value = "/portfolios-edit", method = RequestMethod.GET)
    public ModelAndView editPortfolio(@RequestParam("id") int portfolioId) {
        // TODO: check validity of ID
        Portfolio portfolio = portfolioService.getPortfolioById(portfolioId);
        ModelAndView modelAndView = new ModelAndView(PORTFOLIO_EDIT_VIEW_NAME);
        PortfolioForm portfolioForm = new PortfolioForm(portfolio.getId(), portfolio.getName());
        modelAndView.addObject(COMMAND_NAME, portfolioForm);
        return modelAndView;
    }

    @RequestMapping(value = "/portfolios-edit", method = RequestMethod.POST)
    public ModelAndView updatePortfolio(@ModelAttribute(COMMAND_NAME) @Valid PortfolioForm portfolioForm, BindingResult result) {
        if(!result.hasErrors()) {
            int id = portfolioForm.getId();
            String name = portfolioForm.getName();
            portfolioService.updatePortfolio(new Portfolio(id, name));
            return new ModelAndView("redirect:" + PORTFOLIO_LIST_VIEW_NAME);
        }
        return getModelAndView(PORTFOLIO_EDIT_VIEW_NAME);
    }

    @RequestMapping(value = "/portfolios-add", method = RequestMethod.POST)
    public ModelAndView addPortfolio(@ModelAttribute(COMMAND_NAME) @Valid PortfolioForm portfolioForm, BindingResult result) {
        if(!result.hasErrors()) {
            String portfolioName = portfolioForm.getName();
            Portfolio portfolio = new Portfolio(portfolioName);
            portfolioService.addPortfolio(portfolio);
            return new ModelAndView("redirect:" + PORTFOLIO_LIST_VIEW_NAME);
        }
        return getModelAndView(PORTFOLIO_LIST_VIEW_NAME);
    }

    private ModelAndView getModelAndView(String viewName) {
        List<Portfolio> portfolios = portfolioService.listPortfolios();
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(MODEL_NAME, portfolios);
        return modelAndView;
    }
}
