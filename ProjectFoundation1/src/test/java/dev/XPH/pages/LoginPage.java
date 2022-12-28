package dev.XPH.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    public WebElement userNameInputBar;

    @FindBy(name = "pass")
    public WebElement passwordInputBar;

    @FindBy(xpath = "/html/body/div/fieldset/button")
    public WebElement loginButton;

    public void acceptAlert() {

        driver.switchTo().alert().accept();
    }


//    public Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
//            withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(140))
//            .ignoring(ElementNotInteractableException.class).until(ExpectedConditions.visibilityOf(loginButton));

//    public WebElement wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//            .pollingEvery(Duration.ofMillis(240)).ignoring(ElementNotInteractableException.class)
//            .until(ExpectedConditions.visibilityOf(loginButton));



}
