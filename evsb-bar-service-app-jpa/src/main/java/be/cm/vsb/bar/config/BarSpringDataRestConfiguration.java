package be.cm.vsb.bar.config;

import be.cm.vsb.bar.Bar;
import be.cm.vsb.util.rest.config.SpringDataRestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
@Import({SpringDataRestConfiguration.class})
public class BarSpringDataRestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getExposureConfiguration().forDomainType(Bar.class).disablePutForCreation();
    }
}
