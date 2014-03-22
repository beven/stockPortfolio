package au.com.bevenlee.stocks.service;

import au.com.bevenlee.stocks.dao.StockDao;
import au.com.bevenlee.stocks.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Beven on 22/03/14.
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;


    @Override
    @Transactional
    public void addStock(Stock stock) {
        stockDao.addStock(stock);
    }
}
