package app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig
{
    @Bean
    public OpenAPI openAPI()
    {
        Info info=new Info()
                .description("URL Shortener App")
                .title("URL Shortener")
                .version("v1");
        return new OpenAPI().info(info);
    }
}
