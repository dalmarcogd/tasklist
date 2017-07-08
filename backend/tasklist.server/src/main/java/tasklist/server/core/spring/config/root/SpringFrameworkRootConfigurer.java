package tasklist.server.core.spring.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Implementa��o de de configura��o do spring, substitui beans.xml
 *
 * @author Guilherme Dalmarco (dalmarco.gd@gmail.com)
 */
@Configuration
@ComponentScan(basePackages = "tasklist.server")
public class SpringFrameworkRootConfigurer {
}