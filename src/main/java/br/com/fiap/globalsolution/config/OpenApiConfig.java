package br.com.fiap.globalsolution.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Plataforma de Upskilling/Reskilling 2030+")
                        .description("API RESTful para apoiar o futuro do trabalho - Global Solution FIAP 2025")
                        .version("1.0.0"));
    }
}
