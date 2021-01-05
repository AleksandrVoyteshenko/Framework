package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class TestDataReader {

    private static String pathFileWithKeysProperties = "src/test/resources/config.properties";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(getData("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }

    public static String getData(String data) {
        FileInputStream env;
        Properties property = new Properties();
        String dataTest;
        if (System.getProperty(data) == null) {
            try {
                env = new FileInputStream(pathFileWithKeysProperties);
                property.load(env);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.getStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            dataTest = property.getProperty(data);
        } else {
            dataTest = System.getProperty(data);
        }
        return dataTest;
    }
}