package au.com.bevenlee.stocks.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Beven on 14/03/14.
 */
public class PortfolioForm {

    @NotEmpty()
    @Size(min=3, max=30)
    private String name;
    private int id;

    public PortfolioForm() {
    }

    public PortfolioForm(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
