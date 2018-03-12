package by.itacademy.configs;

import by.itacademy.aspects.MyLogger;
import by.itacademy.aspects.RedirectErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class WebAspectConfig {

    @Bean
    public RedirectErrorPage redirectErrorPageAspect() {
        return new RedirectErrorPage();
    }

    @Bean
    public MyLogger myLoggerAspect() {
        return new MyLogger();
    }
}
