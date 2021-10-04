package hw9.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    protected static Properties PROPERTIES;

    public static String getProperty(String key) {

        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/test.properties")) {
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty(key);
    }
}
