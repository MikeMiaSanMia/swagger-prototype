package pl.sii.eu.swaggerprototype.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(paths())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(metaInfo())
                .useDefaultResponseMessages(false);
    }
//                //My experiments with configuration
//                .apis(RequestHandlerSelectors.basePackage("pl.sii.eu.swaggerprototype"))
//                .apis(not(RequestHandlerSelectors.withClassAnnotation(ApiIgnore.class)))
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .paths(not(PathSelectors.regex("(?!/error.*).*")))

    private Predicate<String> paths() {
        return regex("/rest.*");
    }

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot Swagger2 example API")
                .description("Swagger2 API documentation prototype app")
                .version("1.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses")
                .contact(new Contact("Sii", "https://sii.pl", "sii@pl.sii.eu"))
                .build();
    }
//                //My experiments with ApiInfo object
//        return new ApiInfo(
//                "Spring Boot Swagger2 example API",
//                "Swagger2 API documentation prototype app",
//                "1.0",
//                "Terms of service",
//                new Contact("Sii", "https://sii.pl", "sii@pl.sii.eu"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licenses");


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
