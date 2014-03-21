package au.com.bevenlee.stocks.service;

import au.com.bevenlee.stocks.model.Portfolio;

import java.util.List;

/**
 * Created by Beven on 13/03/14.
 */
public interface PortfolioService {

    List<Portfolio> listPortfolios();

    void addPortfolio(Portfolio portfolio);

    void updatePortfolio(Portfolio portfolio);

    Portfolio getPortfolioById(int id);
}
