package au.com.bevenlee.stocks.web.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Beven on 14/03/14.
 */
public class PortfolioForm {

    @NotEmpty
    @Size(min=1, max=50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
