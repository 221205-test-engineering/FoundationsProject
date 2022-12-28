package dev.XPH.steps.nav;

import dev.XPH.pages.LoginPage;
import dev.XPH.pages.ManagerPage;
import dev.XPH.runners.FirstPageRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class One_impl {
    public static WebDriver driver = FirstPageRunner.driver;

    LoginPage loginPage = new LoginPage(driver);
    ManagerPage managerPage = new ManagerPage(driver);

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        String role = managerPage.getManagerStatus();
//        assertEquals(role, "Manager Home");
//        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/managerhome");

        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=26");
        loginPage.userNameInputBar.sendKeys("g8tor");
        loginPage.passwordInputBar.sendKeys("chomp!");
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();

        Thread.sleep(2000);

    }


    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String pageTitle = driver.getTitle();
        assertEquals("Manager Home", pageTitle);
    }

    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        managerPage.linkIsDisplayed();
    }

    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        managerPage.matricesLink.click();
    }

    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String title = driver.getTitle();
        assertEquals(title, "Matrix Page");
    }

    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        driver.navigate().back();
    }

    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String title = driver.getTitle();
        assertEquals("Home", title);
    }

    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
            managerPage.testCasesLink.click();
    }

    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        driver.findElement(By.linkText(string)).click();
    }

    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String title = driver.getTitle();
        assertEquals(string, title);
    }



}
