package sample;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws IOException {
        String input;
        Properties config = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        loadConfigFile(config);
        while (true) {
            System.out.print("Enter City Name or Code. (q to Quit): ");
            input = bufferedReader.readLine();
            if (input.equals("q"))
                break;
            String capitalCity = CommonAPI.getValueFromAPI(config.getProperty("baseURL") + config.getProperty("getCapitalPath") + input, "capital");
            System.out.println(capitalCity);
        }
    }

    private static void loadConfigFile(Properties config) {
        try (InputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
            // load a properties file
            config.load(fs);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
