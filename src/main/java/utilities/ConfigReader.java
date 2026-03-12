package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;
    
    static  {
        FileReader reader = null;
        try {
            reader = new FileReader("config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
        prop = new Properties();
        try {
            prop.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
