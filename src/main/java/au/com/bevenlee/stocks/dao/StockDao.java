/**
 * Copyright (c) 2009-2010, ABC, Sydney. 
 */
package au.com.bevenlee.stocks.dao;

import au.com.bevenlee.stocks.model.Stock;

import java.util.List;

/**
 * Created by Beven on 20/03/14.
 */
public interface StockDao {

    List<Stock> getStocksByPortfolioId(int portfolioId);
}
