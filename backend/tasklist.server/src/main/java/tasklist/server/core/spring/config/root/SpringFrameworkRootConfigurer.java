package tasklist.server.core.spring.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Implementação de de configuração do spring, substitui beans.xml
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Configuration
@ComponentScan(basePackages = "tasklist.server")
public class SpringFrameworkRootConfigurer {
}