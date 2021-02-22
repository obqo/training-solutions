package JDBC.dao;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesDaoTest {

    private EmployeesDao employeesDao;

    @Before
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUncicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        employeesDao = new EmployeesDao(dataSource);
    }

    @Test
    public void testInsert() {
        employeesDao.createEmployee("John Doe");
        assertEquals(Arrays.asList("John Doe"), employeesDao.listEmployeeNames());
    }

    @Test
    public void testById() {
        long id = employeesDao.createEmployee("Jack Doe");
        id = employeesDao.createEmployee("Jane Doe");
        String name = employeesDao.findEmployeeNameById(id);
        assertEquals("Jane Doe", name);
    }

    //Tranzakciókezelés - transaction
    @Test
    public void testCreateEmployees() {
        employeesDao.createEmployees(Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe"));
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe"), names);
    }

    //Tranzakciókezelés - transaction
    @Test
    public void testCreateEmployeesRollback() {
        employeesDao.createEmployees(Arrays.asList("Jack Doe", "Jane Doe", "xJoe Doe"));
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Collections.emptyList(), names);

    }

    //Haladó ResultSet - AdvancedRS
    @Test
    public void testOddNames() {
        employeesDao.createEmployees(Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe"));
        List<String> names = employeesDao.listOddEmployeeNames();
        assertEquals(Arrays.asList("Jack Doe", "Joe Doe"), names);
    }

    //Haladó ResultSet - AdvancedRS
    @Test
    public void testUpdateNames() {
        employeesDao.createEmployees(Arrays.asList("Jack Doe", "Jane Doe", "Joe Doe"));
        employeesDao.updateNames();
        List<String> names = employeesDao.listEmployeeNames();
        assertEquals(Arrays.asList("Mr. Jack Doe", "Jane Doe", "Mr. Joe Doe"), names);
    }
}