package au.com.bevenlee.stocks.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Beven on 20/03/14.
 */
@Controller
public class StockController {

    private static final String VIEW_NAME = "stocks";

    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public String getStocks() {
        return VIEW_NAME;
    }
}
