package by.itacademy.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"by.itacademy.repository", "by.itacademy.entity"})
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

//    @Value("${jdbc.driver}")
//    private String driverName;
//
//    @Value("${jdbc.url}")
//    private String url;
//
//    @Value("${jdbc.username}")
//    private String username;
//
//    @Value("${jdbc.password}")
//    private String password;
//
//    @Value("${hibernate.dialect}")
//    private String hibernateDialect;
//
//    @Value("${hibernate.show_sql}")
//    private String showSql;
//
//    @Value("${hibernate.format_sql}")
//    private String formatSql;
//
//    @Value("${hibernate.creation_policy}")
//    private String creationPolicy;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driverName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource());
//        sessionFactoryBean.setPackagesToScan("by.itacademy.entity", "by.itacademy.repository");
//        sessionFactoryBean.setHibernateProperties(hibernateProperties());
//        return sessionFactoryBean;
//    }
//
//    @Bean
//    public Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", hibernateDialect);
//        properties.setProperty("hibernate.show_sql", showSql);
//        properties.setProperty("hibernate.format_sql", formatSql);
//        properties.setProperty("hibernate.hbm2ddl.auto", creationPolicy);
//        return properties;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory);
//        return transactionManager;
//    }
}
