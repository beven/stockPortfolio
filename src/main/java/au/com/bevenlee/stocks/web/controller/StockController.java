package au.com.bevenlee.stocks.web.controller;

import au.com.bevenlee.stocks.dao.StockDao;
import au.com.bevenlee.stocks.model.Stock;
import au.com.bevenlee.stocks.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Beven on 20/03/14.
 */
@Controller
public class StockController {

    private static final String VIEW_NAME = "stocks";
    private static final String MODEL_NAME = "stocks";

    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public ModelAndView getStocks(@RequestParam(value = "portfolioId") int portfolioId) {
        List<Stock> stocks = stockService.getStocksByPortfolioId(portfolioId);
        ModelAndView modelAndView = new ModelAndView(VIEW_NAME);
        modelAndView.addObject(MODEL_NAME, stocks);
        return modelAndView;
    }
}
