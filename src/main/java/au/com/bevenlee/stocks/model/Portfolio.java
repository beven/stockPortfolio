package au.com.bevenlee.stocks.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Beven on 13/03/14.
 */
@Entity
@Table(name = "portfolio")
public class Portfolio implements Serializable {

    private int id;
    private String name;
    private List<Stock> stocks;

    public Portfolio() {
    }

    public Portfolio(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Portfolio(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", unique = false, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "portfolio")
    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}
