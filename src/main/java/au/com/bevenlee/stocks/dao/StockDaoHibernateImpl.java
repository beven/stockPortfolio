package au.com.bevenlee.stocks.dao;

import au.com.bevenlee.stocks.model.Stock;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Beven on 21/03/14.
 */
@Repository
public class StockDaoHibernateImpl implements StockDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Stock> getStocksByPortfolioId(int portfolioId) {
        Criteria criteria = getCurrentSession().createCriteria(Stock.class);
        criteria.add(Restrictions.eq(Stock.PORTFOLIO_ID, portfolioId));
        return (List<Stock>) criteria.list();
    }

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
