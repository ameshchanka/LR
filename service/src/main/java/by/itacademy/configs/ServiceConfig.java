package by.itacademy.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"by.itacademy.service"})
@Import(CacheConfig.class)
public class ServiceConfig {
}
