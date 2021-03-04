package covid;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static covid.Person.isNotValidPerson;

public class CovidDao {

    public MariaDbDataSource getDataSource() {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
        return dataSource;
    }

    public void initFlyway() {
        Flyway flyway = Flyway.configure().locations("/db/migration/covid").dataSource(getDataSource()).load();
        flyway.clean();
        flyway.migrate();
    }

    public List<Person> selectAllCitizens() {
        try (Connection conn = getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement("select * from citizens")) {
            return selectPersonByPS(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private List<Person> selectPersonByPS(PreparedStatement stmt) {
        List<Person> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Person person = new Person(
                        rs.getString("citizen_name"),
                        rs.getString("zip"),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("ssn"));
                result.add(person);
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot execute!", se);
        }
    }

    public int selectAllVaccinations() {
        try (Connection conn = getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement("select count(*) as count from vaccinations")) {
            return selectAllVaccinationsbyPS(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private int selectAllVaccinationsbyPS(PreparedStatement stmt) {
        int result = 0;
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                result = rs.getInt("count");
            }
            return result;
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot execute!", se);
        }
    }

    //1. Regisztráció
    public void insertRegisteredCitizens(List<Person> people) {
        try (Connection conn = getDataSource().getConnection()) {
            insertRegisteredByPS(conn, people);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private void insertRegisteredByPS(Connection conn, List<Person> people) throws SQLException {
        conn.setAutoCommit(false);
        try (PreparedStatement stmt = conn.prepareStatement(
                "insert into citizens(citizen_name, zip, age, email, ssn, number_of_vaccination) values (?, ?, ?, ?, ?, ?)")) {
            for (Person person : people) {
                stmt.setString(1, person.getName());
                stmt.setString(2, person.getZip());
                stmt.setInt(3, person.getAge());
                stmt.setString(4, person.getEmail());
                stmt.setString(5, person.getSsn());
                stmt.setInt(6, person.getNrOfVaccination());
                stmt.executeUpdate();
            }
            conn.commit();
        } catch (IllegalArgumentException iae) {
            conn.rollback();
        }
    }

    public String getCityByZip(String zip) {
        try (Connection conn = getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("select * from cities where zip = ?")) {
            ps.setString(1, zip);
            return selectCityNameByPS(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private String selectCityNameByPS(PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("city");
            } else {
                return "Not found!";
                //throw new IllegalArgumentException("Not found");
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    //2. Tömeges regisztráció
    public List<Person> getRegisteredPersonsFromFile(String filename) {
        List<Person> result = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(filename))) {
            lineProcessingForRegistration(result, reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
        return result;
    }

    private void lineProcessingForRegistration(List<Person> result, BufferedReader reader) throws IOException {
        String line;
        reader.readLine();
        int lineNr = 1;
        while ((line = reader.readLine()) != null) {
            lineNr++;
            String[] lineSplit = line.split(";");
            Person person = new Person(lineSplit[0], lineSplit[1], Integer.parseInt(lineSplit[2]), lineSplit[3], lineSplit[4]);
            if (isNotValidPerson(person)) {
                System.out.println("Hibás adatok a(z) " + lineNr + ". sorban!");
            } else {
                result.add(person);
            }
        }
    }

    //3. Generálás
    public void savePeopleWaitingToBeVaccinatedByZip(String zip) {
        LocalDate dateTomorrow = LocalDate.now().plusDays(1);
        String filename = zip + "_" + dateTomorrow.toString() + ".csv";
        Path path = Path.of("src/main/java/covid/" + filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            lineProcessingForGenerateFileByZip(zip, dateTomorrow, writer);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
        System.out.println("Fájl generálása kész " + filename + " néven");
    }

    private void lineProcessingForGenerateFileByZip(String zip, LocalDate dateTomorrow, BufferedWriter writer) throws IOException {
        writer.write("DateTime;Name;Zip;Age;Email;SSN\n");
        for (Person person : selectPeopleForVaccinationByZip(zip, dateTomorrow)) {
            String line = person.getReceivedDateTime() + ";" + person.getName() + ";" +
                    zip + ";" + person.getAge() + ";" + person.getEmail() + ";" +
                    person.getSsn() + "\n";
            writer.write(line);
        }
    }

    private List<Person> selectPeopleForVaccinationByZip(String zip, LocalDate dateOfVaccination) {
        List<Person> result = new ArrayList<>();
        try (Connection conn = getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("select * from citizens where zip = ? order by zip, age desc, citizen_name")) {
            ps.setString(1, zip);
            result.addAll(selectPeopleForVaccinationByPS(ps, dateOfVaccination));
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
        return result;
    }

    private List<Person> selectPeopleForVaccinationByPS(PreparedStatement ps, LocalDate dateOfVaccination) {
        List<Person> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            LocalDateTime receivedDateTime = LocalDateTime.of(2021, 3, 1, 8, 0);
            getSelectedPeopleForVaccination(dateOfVaccination, result, rs, receivedDateTime);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
        return result;
    }

    private void getSelectedPeopleForVaccination(LocalDate dateOfVaccination, List<Person> result, ResultSet rs, LocalDateTime receivedDateTime) throws SQLException {
        int count = 0;
        while (rs.next() && count < 16) {
            Person personal = new Person(
                    rs.getString("citizen_name"),
                    rs.getString("zip"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getString("ssn"));
            if (isNotVaccinatedOrCanComeSecondVaccination(dateOfVaccination, personal)) {
                count++;
                personal.setReceivedDateTime(receivedDateTime);
                result.add(personal);
                receivedDateTime = receivedDateTime.plusMinutes(30);
            }
        }
    }

    private boolean isNotVaccinatedOrCanComeSecondVaccination(LocalDate dateOfVaccination, Person personal) {
        return (personal.getNrOfVaccination() == 0) ||
                ((personal.getNrOfVaccination() == 1) &&
                        (personal.getLastVaccination().isAfter(dateOfVaccination.atStartOfDay().plusDays(15))));
    }

    //4. Oltás
    public void vaccinationBySsn(String ssn) {
        try (Connection conn = getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("select * from citizens where ssn = ?")) {
            ps.setString(1, ssn);
            updateDataAfterVaccination(conn, ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private void updateDataAfterVaccination(Connection conn, PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int citizen_id = rs.getInt("citizen_id");
                int number_of_vaccination = rs.getInt("number_of_vaccination");
                String note = null;
                switch (number_of_vaccination) {
                    case 0 -> updateDataFirstVaccination(conn, citizen_id, number_of_vaccination, note);
                    case 1 -> updateDataAfterFirstVaccination(conn, rs, citizen_id, number_of_vaccination, note);
                    case 2 -> System.out.println("Már van két oltása!");
                }
            } else {
                System.out.println("Nincs ilyen TAJ számmal regisztrált személy!");
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    private void updateDataFirstVaccination(Connection conn, int citizen_id, int number_of_vaccination, String note) {
        LocalDateTime dateTimeOfVaccination;
        String typeOfVaccination;
        String status;
        dateTimeOfVaccination = getDateTimeFromConsole();
        typeOfVaccination = getTypeOfVaccinationFromConsole();
        status = "első";
        insertVaccinationData(conn, citizen_id, dateTimeOfVaccination, status, note, typeOfVaccination);
        updateCitizenDataAfterVaccination(conn, citizen_id, number_of_vaccination, dateTimeOfVaccination);
    }

    private void updateDataAfterFirstVaccination(Connection conn, ResultSet rs, int citizen_id, int number_of_vaccination, String note) throws SQLException {
        String typeOfVaccination;
        LocalDateTime dateTimeOfVaccination;
        String status;
        LocalDateTime lastDateTimeOfVaccination = rs.getTimestamp("last_vaccination").toLocalDateTime();
        System.out.println("Az első oltás időpontja: " + lastDateTimeOfVaccination);
        typeOfVaccination = getVaccinationTypeByCitizenId(conn, citizen_id);
        System.out.println("Az első oltás típusa: " + typeOfVaccination);
        dateTimeOfVaccination = getDateTimeFromConsole();
        status = "second";
        if (dateTimeOfVaccination.isBefore(lastDateTimeOfVaccination.plusDays(15))) {
            System.out.println("Még nem telt el 15 nap!");
            status = "meghiúsult";
            note = "Az első oltás óta még nem telt el 15 nap";
            typeOfVaccination = null;
        }
        else {
            updateCitizenDataAfterVaccination(conn, citizen_id, number_of_vaccination, dateTimeOfVaccination);
        }
        insertVaccinationData(conn, citizen_id, dateTimeOfVaccination, status, note, typeOfVaccination);
    }

    private LocalDateTime getDateTimeFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Oltás dátuma (eeee-hh-nn):");
        String date = scanner.nextLine();
        System.out.println("Oltás időpontja (óó:pp):");
        String time = scanner.nextLine();
        return LocalDate.parse(date).atTime(LocalTime.parse(time));
    }

    private String getTypeOfVaccinationFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Oltás típusa:");
        return scanner.nextLine();
    }

    private String getVaccinationTypeByCitizenId(Connection conn, int citizen_id) {
        String result;
        try (PreparedStatement ps = conn.prepareStatement("select * from vaccinations where citizen_id = ?")) {
            ps.setInt(1, citizen_id);
            result = getVaccinationTypeByPS(ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
        return result;
    }

    private String getVaccinationTypeByPS(PreparedStatement ps) {
        String result = null;
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                result = rs.getString("vaccination_type");
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
        return result;
    }

    private void updateCitizenDataAfterVaccination(Connection conn, int citizen_id, int number_of_vaccination, LocalDateTime dateTimeOfVaccination) {
        try (PreparedStatement ps = conn.prepareStatement(
                "update citizens set number_of_vaccination = ?, last_vaccination= ? where citizen_id = ?")) {
            ps.setInt(1, number_of_vaccination + 1);
            ps.setTimestamp(2, Timestamp.valueOf(dateTimeOfVaccination));
            ps.setInt(3, citizen_id);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private void insertVaccinationData(Connection conn, int citizen_id, LocalDateTime dateTimeOfVaccination, String status, String note, String typeOfVaccination) {
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into vaccinations(citizen_id, vaccination_date, status, note, vaccination_type) values (?, ?, ?, ?, ?)")) {
            ps.setInt(1, citizen_id);
            ps.setTimestamp(2, Timestamp.valueOf(dateTimeOfVaccination));
            ps.setString(3, status);
            ps.setString(4, note);
            ps.setString(5, typeOfVaccination);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    //5. Oltás meghiúsulás
    public void failedVaccination(String ssn) {
        try (Connection conn = getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("select * from citizens where ssn = ?")) {
            ps.setString(1, ssn);
            failedVaccinationByRS(conn, ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private void failedVaccinationByRS(Connection conn, PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int citizen_id = rs.getInt("citizen_id");
                int number_of_vaccination = rs.getInt("number_of_vaccination");
                if (number_of_vaccination == 2) {
                    throw new IllegalStateException("Have two vaccinations!");
                }
                failedVaccinationByPS(conn, citizen_id);
            } else throw new IllegalArgumentException("Not found ssn, not registered");
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    private void failedVaccinationByPS(Connection conn, int citizen_id) {
        LocalDateTime dateTimeOfVaccination = getDateTimeFromConsole();
        String status = "meghiúsult";
        String note = getNoteFromConsole();
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into vaccinations(citizen_id, vaccination_date, status, note) values (?, ?, ?, ?)")) {
            ps.setInt(1, citizen_id);
            ps.setTimestamp(2, Timestamp.valueOf(dateTimeOfVaccination));
            ps.setString(3, status);
            ps.setString(4, note);
            ps.executeUpdate();
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
    }

    private String getNoteFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Az oltás meghiúsulásának oka:");
        return scanner.nextLine();
    }

    //6. Riport
    public void saveReport() {
        String filename = "vaccination_report_" + LocalDate.now().toString() + ".csv";
        Path path = Path.of("src/main/java/covid/" + filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            lineProcessing(writer);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
        System.out.println("Fájl generálása kész " + filename + " néven");
    }

    private void lineProcessing(BufferedWriter writer) throws IOException {
        writer.write("Zip;Number_of_vaccinations;Count_of_vaccinated\n");
        for (String key : getReport().keySet()) {
            String zip = key.split("_")[0];
            String numberOfVaccinations = key.split("_")[1];
            int countOfVaccinated = getReport().get(key);
            writer.write(zip + ";" + numberOfVaccinations + ";" + countOfVaccinated + "\n");
        }
    }
    private Map<String, Integer> getReport() {
        Map<String, Integer> result = new TreeMap<>();
        try (Connection conn = getDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement("select zip, number_of_vaccination from citizens")) {
            getReportByRS(result, ps);
        } catch (SQLException se) {
            throw new IllegalStateException("Connection failed!", se);
        }
        return result;
    }

    private void getReportByRS(Map<String, Integer> result, PreparedStatement ps) {
        try (ResultSet rs = ps.executeQuery()) {
            iterationReportByRS(result, rs);
        } catch (SQLException se) {
            throw new IllegalStateException("Cannot query", se);
        }
    }

    private void iterationReportByRS(Map<String, Integer> result, ResultSet rs) throws SQLException {
        while (rs.next()) {
            String zip = rs.getString("zip");
            String number_of_vaccination = rs.getString("number_of_vaccination");
            String key = zip + "_" + number_of_vaccination;
            if (!result.containsKey(key)) {
                result.put(key, 0);
            }
            result.put(key, result.get(key) + 1);
        }
    }

    public static void main(String[] args) {
        //Personal personal = new Personal(null, "1", 1, "a", "2");
        //Personal personal = new Personal("", "1", 1, "a", "2");

        //Personal personal = new Personal("abc", null , 1, "a", "2");

        //Personal personal = new Personal("abc", "8130" , 1, "a", "2");
        //Personal personal = new Personal("abc", "8130" , 155, "a", "2");

        //Personal personal = new Personal("abc", "8130" , 35, null, "2");
        //Personal personal = new Personal("abc", "8130" , 35, "a", "2");
        //Personal personal = new Personal("abc", "8130" , 35, "a@", "2");
        //Personal personal = new Personal("abc", "8130" , 35, "abc", "2");

        //Personal personal = new Personal("abc", "8130" , 35, "a@a", "2");
        //Personal personal = new Personal("abc", "8130" , 35, "a@a", "111222333");

        CovidDao reg = new CovidDao();
//        Personal personal = new Personal("abc", "8130", 35, "a@a", "121251408");
//        reg.insertRegisteredCitizens(List.of(personal));
//        reg.insertRegisteredCitizens(reg.getRegisteredPersonsFromFile("registered_persons.csv"));
//        System.out.println(reg.getCityByZip(8000));
//        System.out.println(personal);
//        reg.savePersonsWaitingToBeVaccinated("6100");
        reg.vaccinationBySsn("123456788");
//       reg.failedVaccination();
//        System.out.println(reg.getReport());
//        reg.listReport();
        reg.saveReport();
    }
}
