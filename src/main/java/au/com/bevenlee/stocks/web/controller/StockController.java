package au.com.bevenlee.stocks.web.controller;

import au.com.bevenlee.stocks.model.Portfolio;
import au.com.bevenlee.stocks.model.Stock;
import au.com.bevenlee.stocks.service.PortfolioService;
import au.com.bevenlee.stocks.service.StockService;
import au.com.bevenlee.stocks.web.form.StockForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Beven on 20/03/14.
 */
@Controller
public class StockController {

    private static final String VIEW_NAME = "stocks";
    private static final String MODEL_NAME = "portfolio";
    private static final String COMMAND_NAME = "stockForm";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private StockService stockService;
    @Autowired
    private PortfolioService portfolioService;

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(DATE_FORMAT, true);
        binder.registerCustomEditor(Date.class, editor);
    }

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public ModelAndView getStocks(@RequestParam(value = "portfolioId") int portfolioId) {
        ModelAndView modelAndView = getModelAndView(portfolioId);
        modelAndView.addObject(COMMAND_NAME, new StockForm(portfolioId));
        return modelAndView;
    }

    @RequestMapping(value = "/stocks", method = RequestMethod.POST)
    public ModelAndView getStocks(@ModelAttribute(COMMAND_NAME) @Valid StockForm stockForm, BindingResult result) {
        int portfolioId = stockForm.getPortfolioId();
        if(!result.hasErrors()) {
            Portfolio portfolioToUpdate = portfolioService.getPortfolioById(portfolioId);
            Stock stockToAdd = new Stock();
            stockToAdd.setCommission(stockForm.getCommission());
            stockToAdd.setEntryDate(stockForm.getEntryDate());
            stockToAdd.setExitDate(stockForm.getExitDate());
            stockToAdd.setSymbol(stockForm.getSymbol());
            stockToAdd.setPurchasePrice(stockForm.getPurchasePrice());
            stockToAdd.setPurchasePrice(stockForm.getPurchasePrice());
            stockToAdd.setPortfolio(portfolioToUpdate);
            stockService.addStock(stockToAdd);
            ModelAndView modelAndView = new ModelAndView("redirect:" + VIEW_NAME);
            modelAndView.addObject("portfolioId", portfolioId);
            return modelAndView;
        }
        return getModelAndView(portfolioId);
    }


    private ModelAndView getModelAndView(int portfolioId) {
        Portfolio portfolio = portfolioService.getPortfolioWithStocksById(portfolioId);
        ModelAndView modelAndView = new ModelAndView(VIEW_NAME);
        modelAndView.addObject(MODEL_NAME, portfolio);
        return modelAndView;
    }
}
