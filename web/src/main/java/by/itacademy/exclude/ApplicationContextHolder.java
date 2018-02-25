package by.itacademy.exclude;

import by.itacademy.config.DatabaseConfig;
import by.itacademy.config.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextHolder {

    private static AnnotationConfigApplicationContext applicationContext;

    public static void init() {
        System.out.println("applicationContext");
        applicationContext = new AnnotationConfigApplicationContext(
                DatabaseConfig.class,
                ServiceConfig.class
        );
    }

    public static <T> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    public static void destroy() {
        applicationContext.close();
    }
}
