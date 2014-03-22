package au.com.bevenlee.stocks.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by Beven on 22/03/14.
 */
public class StockForm {

    @NotEmpty()
    private String symbol;
    private Date entryDate;
    private Date exitDate;
    private float purchasePrice;
    private float exitPrice;
    private float commission;
    @NotEmpty()
    private int portfolioId;

    public StockForm() {
    }

    public StockForm(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getExitPrice() {
        return exitPrice;
    }

    public void setExitPrice(float exitPrice) {
        this.exitPrice = exitPrice;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }
}
