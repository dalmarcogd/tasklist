package tasklist.server.core.spring.config.mvc;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Implementação de de configuração do spring, substitui beans.xml
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Configuration
public class SpringWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        converters.add(gsonHttpMessageConverter);

        super.configureMessageConverters(converters);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(ManagerInstance.get(ControllerHandlerInterceptorAdapter.class));
    }

    /**
     * {@inheritDoc}
     * <br />- <b>Data:</b> 7 de jun de 2017
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
   		registry.addResourceHandler("/**").addResourceLocations("/").setCachePeriod(31556926);
    }
}
