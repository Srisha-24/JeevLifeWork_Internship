package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
    private static final Properties props = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("config/db.properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}