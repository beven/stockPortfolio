package au.com.bevenlee.stocks.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Beven on 13/03/14.
 */
@Entity
@Table(name = "portfolio")
public class Portfolio implements Serializable {

    private int id;
    private String name;

    public Portfolio() {
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
}
