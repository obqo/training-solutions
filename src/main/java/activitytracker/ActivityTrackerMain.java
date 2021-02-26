package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }

//        Activity activity = new Activity(LocalDateTime.of(2021, 02, 23, 10, 22), "Biking in Bakony", ActivityType.BIKING);
//        Activity activity2 = new Activity(LocalDateTime.of(2021, 02, 23, 10, 22), "Hiking in Bakony", ActivityType.HIKING);
//        Activity activity3 = new Activity(LocalDateTime.of(2021, 02, 23, 10, 22), "Running in Bakony", ActivityType.RUNNING);


        Flyway flyway = Flyway.configure().locations("/db/migration/activitytracker").dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

        ActivityDao activityDao = new ActivityDao(dataSource);
        System.out.println(activityDao.selectById(3));
        System.out.println(activityDao.selectAllActivities());
        System.out.println(activityDao.selectAllActivitiesByType(ActivityType.BIKING));
    }
}
