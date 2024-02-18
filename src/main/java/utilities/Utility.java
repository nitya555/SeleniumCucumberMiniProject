package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility {

    private static WebDriver driver;
    public static String url(String url_type) throws IOException {
        final String propertyFilePath= "src/test/resources/application.proprties";
        Properties prop = new Properties();
        FileReader reader = new FileReader(propertyFilePath);
        prop.load(reader);
        try {
            if (url_type == "Register") {
                return prop.getProperty("REGISTER_URL");
            }
            else if(url_type == "Login"){
                return prop.getProperty("LOGIN_URL");
            }
            else{
                throw new NullPointerException();
            }
        }catch(Exception e){
            System.out.println("Please provide the URL type properly");
        }
        return "";
    }

    public WebDriver setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

}
