package meetingrooms;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {

        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");

        for (String language : languages){
            if (language.length() > 5){
                System.out.println(language);
            }
        }
    }
}
