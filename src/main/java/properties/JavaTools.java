/*
Java eszközök nyilvántartása
Egy properties állományban tárold el a különböző Java eszközök leírásait a következő formátumban:
jdk.name = Java Development Kit
jdk.url = http://www.oracle.com/technetwork/java/javase/downloads/index-jsp-138363.html
maven.name = Apache Maven
maven.url = https://maven.apache.org/
junit.name = JUnit
junit.url = http://junit.org/junit4/
Írj egy properties.JavaTools osztályt, mely betölti ezen eszközöket a properties állományból.
Legyen egy Set<String> getToolKeys() metódusa, mely visszaadja az eszközök kulcsait (pl. jdk, maven).
Legyen egy Set<String> getTools() metódusa, mely visszaadja az eszközök neveit. Legyen egy String getName(String) metódusa,
mely kulcs alapján visszaadja annak nevét, és egy String getUrl(String) metódusa, mely kulcs alapján visszaadja annak címét.
 */
package properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class JavaTools {

    private Properties tools;

    public JavaTools() {
        try (InputStream is = DatabaseConfiguration.class.getResourceAsStream("javatools.properties")) {
            load(is);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file from classpath", ioe);
        }
    }

    private Properties load(InputStream inputStream) {
        tools = new Properties();
        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            tools.load(reader);
            return tools;
        } catch (IOException ioe) {
            throw new RuntimeException("Cannot read properties file from inputstream", ioe);
        }
    }

    public Set<String> getToolKeys() {
        Set<String> result = new HashSet<>();
        for (String key : tools.stringPropertyNames()) {
            if (key.contains("name")) {
                result.add(key.substring(0,key.indexOf('.')));
            }
        }
        return result;
    }

    public Set<String> getTools() {
        Set<String> result = new HashSet<>();
        for (String key : getToolKeys()) {
            result.add(getName(key));
        }
        return result;

    }

    public String getName(String key) {
        return tools.getProperty(key + ".name");
    }

    public String getUrl(String key) {
        return tools.getProperty(key + ".url");
    }
}
