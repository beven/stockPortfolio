package au.com.bevenlee.stocks.service;

import au.com.bevenlee.stocks.dao.PortfolioDao;
import au.com.bevenlee.stocks.model.Portfolio;
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
}
