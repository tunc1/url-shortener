package app.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@ExtendWith(MockitoExtension.class)
class WebMvcConfigurerImplTest
{
    @Test
    void addCorsMappings()
    {
        WebMvcConfigurerImpl webMvcConfigurer=new WebMvcConfigurerImpl();
        CorsRegistry registry=Mockito.mock(CorsRegistry.class);
        CorsRegistration corsRegistration=Mockito.mock(CorsRegistration.class);
        Mockito.when(registry.addMapping(Mockito.anyString())).thenReturn(corsRegistration);
        webMvcConfigurer.addCorsMappings(registry);
        Mockito.verify(registry,Mockito.times(1)).addMapping("/api/**");
        Mockito.verify(corsRegistration,Mockito.times(1)).allowedOrigins("*");
    }
}