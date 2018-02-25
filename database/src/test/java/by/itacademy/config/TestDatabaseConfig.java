package by.itacademy.config;

import by.itacademy.util.EntityTestDataImporter;
import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DatabaseConfig.class)
public class TestDatabaseConfig {

//    @Value("${jdbc.url}")
//    private String url;
//
//    @Value("${jdbc.username}")
//    private String username;
//
//    @Value("${jdbc.password}")
//    private String password;
//
//    @Bean
//    public JdbcDataSource dataSource() {
//        JdbcDataSource dataSource = new JdbcDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUser(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }

//    @Bean
//    public EntityTestDataImporter entityTestDataImporter() {
//        EntityTestDataImporter importer = EntityTestDataImporter.getInstance();
//        //importer.importTestData(sessionFactory);
//        return  importer;
//    }
}
