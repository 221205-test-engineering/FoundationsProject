package dev.XPH.steps.login;

import dev.XPH.pages.LoginPage;
import dev.XPH.pages.ManagerPage;
import dev.XPH.runners.FirstPageRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class neg_pos_login_Impl {

//    public static WebDriver driver;
    public static WebDriver driver = FirstPageRunner.driver;

//    WebDriverManager.chromedriver().setup();

    LoginPage loginPage = new LoginPage(driver);
    ManagerPage managerPage = new ManagerPage(driver);

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=26");
    }

    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        Thread.sleep(2000);
        loginPage.userNameInputBar.sendKeys("g8tor");
    }

    @When("The employee types in chomp!! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        loginPage.passwordInputBar.sendKeys("chomp!!");
    }

    //WAIT
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

//        loginPage.wait.click();

//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30L))
//                .pollingEvery(Duration.ofSeconds(5L))
//                .ignoring(NoSuchElementException.class).
//                until(ExpectedConditions.visibilityOf(loginPage.loginButton));

        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();

        Thread.sleep(2000);


    }


    // WAIT
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String alertMessageString = driver.switchTo().alert().getText();
        loginPage.acceptAlert();
//        return alertMessageString.equals("no user with that username found");
        assertEquals(alertMessageString,"no user with that username found");
    }


// test case scenario 2

    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        loginPage.userNameInputBar.sendKeys("sic em dawgs");
    }

    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        loginPage.passwordInputBar.sendKeys("natchamps");
    }

//    @When("The employee clicks on the login button")
//    public void the_employee_clicks_on_the_login_button() {
//        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
//        loginPage.loginButton.click();
//    }

    // WAIT
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String alertMessageString = driver.switchTo().alert().getText();
        loginPage.acceptAlert();
        assertEquals(alertMessageString,"Username not found");
//        alertMessageString.equals("Username not found");
    }


    // Positive login feature

    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        loginPage.userNameInputBar.sendKeys(string);
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        loginPage.passwordInputBar.sendKeys(string);
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String title = driver.getTitle();
        assertEquals(string + " Home",title);
    }
    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String paraS = managerPage.getPString();
        String[] arrOfStr = paraS.split(" ");

        String firstName = arrOfStr[1];
        String lastName = arrOfStr[2];

        assertEquals(string, firstName);
        assertEquals(string2, lastName);

    }



}
