package introexception.patient;

public class SsnValidator {

    public boolean isValidSsn(String ssn) {
        if (ssn.length() != 9) {
            return false;
        }
        try {
            int sum = 0;
            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    sum += getNumber(ssn.charAt(i)) * 3;
                } else {
                    sum += getNumber(ssn.charAt(i)) * 7;
                }
            }
            return (getNumber(ssn.charAt(8))  == (sum % 10));
        } catch (IllegalArgumentException iae) {
            return false;
        }
    }

    public int getNumber(char ch) {
        if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException("Nem csak számokat tartalmaz");
            }
        return ch - '0';
    }
}
