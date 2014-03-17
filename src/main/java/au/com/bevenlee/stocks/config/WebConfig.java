package au.com.bevenlee.stocks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by Beven on 13/03/14.
 */
@Configuration
@ComponentScan({"au.com.bevenlee.stocks.config",
                "au.com.bevenlee.stocks.service",
                "au.com.bevenlee.stocks.dao",
                "au.com.bevenlee.stocks.web"})
@EnableWebMvc
@PropertySource("classpath:/messages.properties")
public class WebConfig {

    @Bean
    public UrlBasedViewResolver urlViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
