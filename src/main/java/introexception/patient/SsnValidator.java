package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {
        if (ssn.length() != 9 || !isNumber(ssn)) {
            return false;
        } else {
            int sum = 0;
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    sum += ssn.charAt(i) * 3;
                } else {
                    sum += ssn.charAt(i) * 7;
                }
            }
            return (ssn.charAt(8) - '0' == (sum % 10));
        }
    }

    public boolean isNumber(String ssn) {
        for (int i = 0; i < ssn.length(); i++) {
            if (ssn.charAt(i) < '0' || ssn.charAt(i) > '9') {
                throw new IllegalArgumentException("Nem csak számokat tartalmaz");
            }
        }
        return true;
    }
}
