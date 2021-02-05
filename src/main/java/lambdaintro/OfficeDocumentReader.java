/*
Írj egy OfficeDocumentReader osztályt, abba egy List<File> listOfficeDocuments(File path) metódust,
mely visszaadja a paraméterként átadott könyvtárban található összes docx, pptx és xlsx kiterjesztésű fájlt,
név szerint sorbarendezve.
Implementációs javaslat
Kizárólag lambda kifejezéseket vagy method reference-eket használj.
 */
package lambdaintro;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OfficeDocumentReader {

    private static final String REGEX = ".*\\.(docx|xlsx|pptx)$";

    public List<File> listOfficeDocuments(File path) {
        List<File> files = Arrays.asList(path.listFiles(f -> f.isFile() && f.getName().toLowerCase().matches(REGEX)));
        files.sort(Comparator.comparing(File::getName));
        return files;
    }
}
