package JDBC.metadata;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MetaDataDaoTest {

    private MetaDataDao metaDataDao;

    @Before
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUncicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        metaDataDao = new MetaDataDao(dataSource);
    }

    @Test
    public void testTableNames() {
        List<String> names = metaDataDao.getTableNames();
        System.out.println(names);
        assertTrue("Contains employees table", names.contains("employees"));
    }
}
