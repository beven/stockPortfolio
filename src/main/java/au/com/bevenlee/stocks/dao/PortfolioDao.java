package au.com.bevenlee.stocks.dao;

import au.com.bevenlee.stocks.model.Portfolio;

import java.util.List;

/**
 * Created by Beven on 13/03/14.
 */
public interface PortfolioDao {

    Integer addPortfolio(Portfolio portfolio);

    void updatePortfolio(Portfolio portfolio);

    List<Portfolio> listPortfolios();
}
