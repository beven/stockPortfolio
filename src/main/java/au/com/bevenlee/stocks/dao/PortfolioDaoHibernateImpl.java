package au.com.bevenlee.stocks.dao;

import au.com.bevenlee.stocks.model.Portfolio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Beven on 13/03/14.
 */
@Repository
public class PortfolioDaoHibernateImpl implements PortfolioDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Integer addPortfolio(Portfolio portfolio) {
        Integer portfolioId = (Integer) getCurrentSession().save(portfolio);
        return portfolioId;
    }

    @Override
    public void updatePortfolio(Portfolio portfolio) {
        getCurrentSession().update(portfolio);
    }

    @Override
    public List<Portfolio> listPortfolios() {
        List<Portfolio> portfolios = getCurrentSession().createQuery("FROM Portfolio").list();
        return portfolios;
    }

    @Override
    public Portfolio getPortfolioById(int id) {
        return (Portfolio) getCurrentSession().get(Portfolio.class, id);
    }
}
