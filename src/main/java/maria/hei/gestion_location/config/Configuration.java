package maria.hei.gestion_location.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:application.properties")
public class Configuration {
    private String username;
    private String password;

    public Configuration(@Value("${DATABASE_USERNAME}") String username,
                         @Value("${DATABASE_PASSWORD}") String password
                         ){
        this.username = username;
        this.password = password;
    }

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/location",
                username,
                password
        );
    }
}
