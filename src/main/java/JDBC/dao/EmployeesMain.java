package JDBC.dao;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

public class EmployeesMain {

    public static void main(String[] args) throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUncicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        EmployeesDao employeesDao = new EmployeesDao(dataSource);
        employeesDao.createEmployee("Jane Doe");

        List<String> names = employeesDao.listEmployeeName();
        System.out.println(names);

        String name = employeesDao.findEmployeeNameById(10L);
        System.out.println(name);
    }
}
