package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestDataReader {

    private static String pathFileWithKeysProperties = "src/test/resources/config.properties";
    private static ResourceBundle resourceBundle;

    static {
        try {
            resourceBundle = ResourceBundle.getBundle(getData("environment"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }

    public static String getData(String data) throws IOException {
        FileInputStream env = null;
        Properties property = new Properties();
        String dataTest = null;
        if (System.getProperty(data) == null) {
            env = new FileInputStream(pathFileWithKeysProperties);
            property.load(env);
            dataTest = property.getProperty(data);
        } else { dataTest = System.getProperty(data);
        }
        return dataTest;
    }
}