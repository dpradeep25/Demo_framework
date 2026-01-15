package Config;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyReader {

    private static final Map<String, Properties> propertiesMap = new HashMap<>();

    private PropertyReader() {
    }

    public static String get(String fileName, String key) {

        Properties properties = propertiesMap.get(fileName);

        if (properties == null) {
            properties = loadProperties(fileName);
            propertiesMap.put(fileName, properties);
        }

        return properties.getProperty(key);
    }

    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream is = PropertyReader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (is == null) {
                throw new RuntimeException("File not found: " + fileName);
            }
            properties.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load file: " + fileName);
        }
        return properties;
    }
}
