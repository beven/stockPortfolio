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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
