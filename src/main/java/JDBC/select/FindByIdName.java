package JDBC.select;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FindByIdName {

    public void selectNameByPreparedStatment(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String name = rs.getString("emp_name");
                System.out.println(name);
            }
            else throw new IllegalArgumentException("Not found");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    public void selectNameById(DataSource ds, long id) {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement("select emp_name from employees where id = ?")) {
            ps.setLong(1, id);
            selectNameByPreparedStatment(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot select employees", se);
        }
    }

    public static void main(String[] args) throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUncicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        new FindByIdName().selectNameById(dataSource, 2);
    }
}
