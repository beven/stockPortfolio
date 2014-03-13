package au.com.bevenlee.stocks.web.controller;

import au.com.bevenlee.stocks.model.Portfolio;
import au.com.bevenlee.stocks.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Beven on 13/03/14.
 */
@Controller
public class ListPortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @RequestMapping(value = "/portfolios")
    public ModelAndView listPortfolios() {
        List<Portfolio> portfolios = portfolioService.listPortfolios();
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("portfolios", portfolios);
        return new ModelAndView("portfolios", model);
    }
}
