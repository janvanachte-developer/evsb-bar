package be.cm.vsb.util.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@ComponentScan(basePackageClasses = {SpringDataRestExceptionHandler.class})
//@Import({SpringDataRestValidatorEventRegistration.class})
// springfox 2 data rest does not work with springboot 2 - see https://github.com/springfox/springfox/issues/2298
@Import({SpringDataRestValidatorEventRegistration.class, springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
@EnableSwagger2WebMvc
public class SpringDataRestConfiguration {
}
