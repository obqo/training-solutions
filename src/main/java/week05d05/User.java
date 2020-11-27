//Készíts egy osztályt week05d05.User néven, melynek van egy firstName (String), egy lastName (String) és egy email (String) mezője.
// Legyen ellenőrzés az User konstruktorában, mely hibát jelez, ha nincs @ és . (pont) az e-mail cimben!
// Készíts egy metódust is getFullName névvel, mely visszaadja a firstName és a lastName változókat összefűzve. Legyen közöttük egy whitespace (" ").
package week05d05;

public class User {

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        if (!(haveAt(email) && haveDot(email))) {
            throw new IllegalArgumentException("Email havent '.' and/or '@': " + email);
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Incorrect email: " + email);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFullName () {
        return firstName + " " + lastName;
    }

    public boolean haveDot(String string) {
        return string.indexOf(".") >= 0;
    }

    public boolean haveAt(String string) {
        return string.indexOf("@") >= 0;
    }

    public boolean isValidEmail(String email){
        return email.indexOf(".") < email.length() - 1 && email.indexOf("@") < (email.indexOf(".", email.indexOf("@") + 1) - 1);
    }
}
