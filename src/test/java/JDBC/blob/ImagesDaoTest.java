package JDBC.blob;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class ImagesDaoTest {

    private ImagesDao imagesDao;

    @Before
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUncicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        imagesDao = new ImagesDao(dataSource);
    }

    @Test
    public void saveImage() throws IOException {
        imagesDao.saveImage("java.gif", ImagesDaoTest.class.getResourceAsStream("/java.gif"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (InputStream is = imagesDao.getImageByName("java.gif")) {
            is.transferTo(baos);
        }

        assertTrue("File size", baos.size() > 2000);
    }
}