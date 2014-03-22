package au.com.bevenlee.stocks.service;

import au.com.bevenlee.stocks.dao.PortfolioDao;
import au.com.bevenlee.stocks.model.Portfolio;
import au.com.bevenlee.stocks.model.Stock;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Beven on 13/03/14.
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioDao portfolioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Portfolio> listPortfolios() {
        return portfolioDao.listPortfolios();
    }

    @Override
    @Transactional
    public void addPortfolio(Portfolio portfolio) {
        portfolioDao.addPortfolio(portfolio);
    }

    @Override
    @Transactional
    public void updatePortfolio(Portfolio portfolio) {
        portfolioDao.updatePortfolio(portfolio);
    }

    @Override
    @Transactional(readOnly = true)
    public Portfolio getPortfolioById(int id) {
        return portfolioDao.getPortfolioById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Portfolio getPortfolioWithStocksById(int id) {
        Portfolio portfolio = portfolioDao.getPortfolioById(id);
        eagerLoadStocks(portfolio);
        return portfolio;
    }

    private void eagerLoadStocks(Portfolio portfolio) {
        List<Stock> stocks = portfolio.getStocks();
        if(stocks != null) {
            Hibernate.initialize(stocks);
        }
    }
}
