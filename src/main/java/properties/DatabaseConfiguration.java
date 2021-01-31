/*
Adatbázis konfiguráció beolvasása
Írj egy properties.DatabaseConfiguration osztályt, mely properties állományból betölti az adatbázis beállításokat,
majd le lehet ezeket kérdezni. Létre lehet hozni paraméter nélküli konstruktorral, ekkor a classpath-ról tölti be a
properties állományt. Van egy File paramétert váró konstruktora is, melyet megadva a beállításokat a paraméterként
megadott fájlból tölti be.
Megvalósítási javaslatok
Figyelj a karakterkódolásra. IDEA-ban, hogy a properties fájlt UTF-8 kódolással hozza létre, át kell állítani,
File / Settings / Editor / File Encodings ablakon a "Default encoding for properties files" értékét kell UTF-8-ra állítani.
A karakterkódolás konstans értékként legyen megadva.
A betöltés a konstruktorban történjen. Érdemes felvenni egy Properties típusú attribútumot. A getHost(), getPort() és
getSchema() metódusok ezt hívják.
 */
package properties;

import java.io.*;
import java.util.Properties;

public class DatabaseConfiguration {

    private final static String ENCODING_UTF8 = "UTF-8";
    private Properties config;

    public DatabaseConfiguration() {
        try (InputStream is = DatabaseConfiguration.class.getResourceAsStream("db.properties")) {
            load(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file from classpath", ioe);
        }
    }

    public DatabaseConfiguration(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            load(fis);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    private Properties load(InputStream inputStream) {
        config = new Properties();
        try (InputStreamReader reader = new InputStreamReader(inputStream, ENCODING_UTF8)) {
            config.load(reader);
            return config;
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot read properties file from inputstream", ioe);
        }
    }

    public String getHost() {
        return config.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(config.getProperty("db.port"));
    }

    public String getSchema() {
        return config.getProperty("db.schema");
    }
}
