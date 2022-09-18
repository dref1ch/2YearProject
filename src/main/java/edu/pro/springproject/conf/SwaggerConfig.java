package edu.pro.springproject.conf;/*
    @author Denys
    @project SpringProject
    @class SwaggerConfig
    @version 1.0.0
    @since 27.03.2022 - 12 - 54
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static org.springframework.web.servlet.function.RequestPredicates.path;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "API for FootStore",
                "API for creating goods for FootStore company",
                "1.0.O",
                "",
                new Contact("Antonyuk Denys - owner", "https://instagram.com/dref1ch", "chrom2626@gmail.com"),
                "MIT License",
                "https://opensource.org/licenses/mit-license.php",
                Collections.emptyList());
    }
}