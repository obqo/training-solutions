package covid;

import java.time.LocalDateTime;

public class Person {

    private final String name;
    private final String zip;
    private final int age;
    private final String email;
    private final String ssn;
    private int nrOfVaccination;
    private LocalDateTime lastVaccination;
    private LocalDateTime receivedDateTime;

    public Person(String name, String zip, int age, String email, String ssn) {
            this.name = name;
            this.zip = zip;
            this.age = age;
            this.email = email;
            this.ssn = ssn;
            this.nrOfVaccination = 0;
    }

    public static boolean isNotValidPerson(Person person) {
        return isNotValidNameZip(person.getName()) ||
                isNotValidNameZip(person.getZip()) ||
                isNotValidAge(person.getAge()) ||
                isNotValidEmail(person.getEmail()) ||
                isNotValidSsn(person.getSsn());
    }

    public static boolean isNotValidNameZip(String name) {
        return name == null || name.isEmpty();
    }

    public static boolean isNotValidAge(int age) {
        return age <= 10 || age >= 150;
    }

    public static boolean isNotValidEmail(String email) {
        return email == null || email.length() < 3 || !email.contains("@");
    }

    public static boolean isNotValidSsn(String ssn) {
        if (ssn.length() == 9) {
            int sum = 0;
            for (int i = 0; i < 8; i++) {
                sum += Character.getNumericValue(ssn.charAt(i)) * (i % 2 == 0 ? 3 : 7);
            }
            return sum % 10 != Character.getNumericValue(ssn.charAt(8));
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getSsn() {
        return ssn;
    }

    public int getNrOfVaccination() {
        return nrOfVaccination;
    }

    public LocalDateTime getLastVaccination() {
        return lastVaccination;
    }

    public LocalDateTime getReceivedDateTime() {
        return receivedDateTime;
    }

    public void setNrOfVaccination(int nrOfVaccination) {
        this.nrOfVaccination = nrOfVaccination;
    }

    public void setLastVaccination(LocalDateTime lastVaccination) {
        this.lastVaccination = lastVaccination;
    }

    public void setReceivedDateTime(LocalDateTime receivedDateTime) {
        this.receivedDateTime = receivedDateTime;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "name='" + name + '\'' +
                ", zip='" + zip + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", ssn='" + ssn + '\'' +
                ", nrOfVaccination=" + nrOfVaccination +
                ", lastVaccination=" + lastVaccination +
                '}';
    }
}
