package by.itacademy;

import by.itacademy.config.DatabaseConfig;
import by.itacademy.config.ServiceConfig;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextHolder {

    private static AnnotationConfigApplicationContext APPLICATION_CONTEXT;

    public static void init() {
        System.out.println("APPLICATION_CONTEXT");
        APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(
                DatabaseConfig.class,
                ServiceConfig.class
        );
    }

    public static <T> T getBean(Class<T> beanClass) {
        return APPLICATION_CONTEXT.getBean(beanClass);
    }

    public static void destroy() {
        APPLICATION_CONTEXT.close();
    }
}
