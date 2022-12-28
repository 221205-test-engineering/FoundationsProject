package dev.XPH.runners;

import dev.XPH.pages.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//@CucumberOptions(features = "src/test/java/dev/XPH/features/login", glue = "dev.XPH.steps.login")
@CucumberOptions(features = "src/test/java/dev/XPH/features", glue = "dev.XPH.steps")
@RunWith(Cucumber.class)
public class FirstPageRunner{

    public static WebDriver driver;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void teardown() {
//        driver.quit();
    }



}
