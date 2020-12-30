package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestDataReader {

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
        FileInputStream env;
        Properties property = new Properties();
        env = new FileInputStream("src/test/resources/config.properties");
        property.load(env);
        String dataTest = property.getProperty(data);
        return dataTest;
    }
}