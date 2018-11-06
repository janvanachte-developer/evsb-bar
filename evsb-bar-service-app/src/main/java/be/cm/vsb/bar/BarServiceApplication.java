package be.cm.vsb.bar;

import be.cm.vsb.util.rest.config.SpringDataRestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
//@Import({SpringDataRestConfiguration.class}) // Import configurations outside domain package
public class BarServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BarServiceApplication.class);

    }


}
