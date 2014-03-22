package au.com.bevenlee.stocks.model;

import javax.persistence.*;
import javax.sound.sampled.Port;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Beven on 21/03/14.
 */
@Entity
@Table(name = "stock")
public class Stock implements Serializable {

    public static final String PORTFOLIO_ID = "portfolioId";

    private int id;
    private String symbol;
    private Date entryDate;
    private Date exitDate;
    private float purchasePrice;
    private float exitPrice;
    private float commission;
    private Portfolio portfolio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "commission", unique = false, nullable = false)
    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "entryDate", unique = false, nullable = false)
    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "exitDate", unique = false, nullable = false)
    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    @Column(name = "exitPrice", unique = false, nullable = false)
    public float getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(float exitPrice) {
        this.exitPrice = exitPrice;
    }

    @Column(name = "purchasePrice", unique = false, nullable = false)
    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Column(name = "symbol", unique = false, nullable = false)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioId", nullable = false)
    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

}
