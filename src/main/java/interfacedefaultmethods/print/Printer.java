package interfacedefaultmethods.print;

import java.util.List;

public class Printer {

    public String print(Printable printable) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < printable.getLength(); i++) {
            if (!Printable.BLACK.equals(printable.getColor(i))) {
                result.append("[").append(printable.getColor(i)).append("]");
            }
            result.append(printable.getPage(i)).append("\n");
        }
        return result.toString();
    }
}
