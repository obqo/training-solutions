package JDBC.spring;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class Config {

    @Bean
    public Flyway flyway() throws SQLException{
        Flyway flyway = Flyway.configure().dataSource(dataSource()).load();
        return flyway;
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUncicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");
        return dataSource;
    }

    @Bean
    public EmployeeDao employeeDao() throws SQLException {
        return new EmployeeDao(dataSource());
    }
}
