package common;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertiesFilePath =
            "src" + File.separator +
            "main" + File.separator +
            "resources" + File.separator +
            "configs" + File.separator +
            "config.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertiesFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at "+propertiesFilePath);
        }
    }

    public String getEnvironment() {
        String envPath = properties.getProperty("environment.name");
        if (envPath != null) {
            return envPath;
        } else {
            throw new RuntimeException("environment.name is not specified in the config.properties file");
        }
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        if (url != null) {
            return url;
        } else {
            throw new RuntimeException("url is not specified in the config.properties file");
        }
    }

    public String getName() {
        String name = properties.getProperty("author.name");
        if (name != null) {
            return name;
        } else {
            throw new RuntimeException("author.name is not specified in the config.properties file");
        }
    }

    public String getSurname() {
        String surname = properties.getProperty("author.surname");
        if (surname != null) {
            return surname;
        } else {
            throw new RuntimeException("author.surname is not specified in the config.properties file");
        }
    }
}
