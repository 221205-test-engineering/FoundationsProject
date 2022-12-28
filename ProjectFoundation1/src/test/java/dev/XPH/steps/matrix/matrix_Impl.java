package dev.XPH.steps.matrix;

import dev.XPH.pages.LoginPage;
import dev.XPH.pages.ManagerPage;
import dev.XPH.pages.MatricesPage;
import dev.XPH.runners.FirstPageRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class matrix_Impl {


    public static WebDriver driver = FirstPageRunner.driver;

    LoginPage loginPage = new LoginPage(driver);
    ManagerPage managerPage = new ManagerPage(driver);
    MatricesPage matricesPage = new MatricesPage((driver));

//    @Given("The manager is logged in as a manager")
//    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
////        String title = driver.getTitle();
////        if (title.equals(""))
//        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=26");
//        loginPage.userNameInputBar.sendKeys("g8tor");
//        loginPage.passwordInputBar.sendKeys("chomp!");
//        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
//                .pollingEvery(Duration.ofMillis(140))
//                .ignoring(ElementNotInteractableException.class)
//                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();
//
//        Thread.sleep(2000);
//
//    }

//


//    @Given("The manager is on the home page")
//    public void the_manager_is_on_the_home_page() {
//        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
//        String title = driver.getTitle();
//        assertEquals("Manager Home", title);
//    }

    @When("The manager chooses to create a new matrix")
    public void the_manager_chooses_to_create_a_new_matrix() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(managerPage.newMatrixButton)).click();
        Thread.sleep(2000);
    }

    @When("The manager creates a title for the matrix")
    public void the_manager_creates_a_title_for_the_matrix() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(managerPage.inputNewMatrixName)).sendKeys("TEST TITLE (MATRIX)");

    }

    @When("The manager adds requirements to the matrix")
    public void the_manager_adds_requirements_to_the_matrix() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        managerPage.inputUserStoryRule.sendKeys("TEST USER STORY");
        managerPage.selectDropDown("Medium");
        managerPage.inputNote.sendKeys("Test Note");
        managerPage.addRequirementButton.click();
    }

    @When("The manager saves the matrix")
    public void the_manager_saves_the_matrix() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        managerPage.saveMatrixButton.click();
        Thread.sleep(2000);
    }

    @Then("An alert with a success message should appear")
    public void an_alert_with_a_success_message_should_appear() {
//        Alert alert = driver.switchTo().alert();
//        // Write code here that turns the phrase above into concrete actions
//        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
//                .pollingEvery(Duration.ofMillis(140))
//                .ignoring(ElementNotInteractableException.class)
//                .until(ExpectedConditions.visibilityOf((WebElement) driver.switchTo().alert().accept());
        driver.switchTo().alert().accept();
    }


    @Given("The manager is on the matrix homepage")
    public void the_manager_is_on_the_matrix_homepage() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        managerPage.matricesLink.click();
        String title = driver.getTitle();
        assertEquals("Matrix Dashboard", title);
    }

    @Given("The manager has selected the matrix")
    public void the_manager_has_selected_the_matrix() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Thread.sleep(2000);
        matricesPage.showMX_One.click();
        Thread.sleep(1000);
        matricesPage.editFirst.click();
        Thread.sleep(1000);

    }

    @When("The manager adds a defect")
    public void the_manager_adds_a_defect() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        managerPage.firstDefect.click();

        Thread.sleep(1000);

        matricesPage.DefectAddInput.sendKeys("901");
        Thread.sleep(1500);
        matricesPage.addDefectButton.click();

    }

    @When("The manager confirms their changes")
    public void the_manager_confirms_their_changes() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        matricesPage.SaveRequirementButton.click();
        Thread.sleep(1000);
    }

    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("Matrix Saved",alertMessage);
        driver.switchTo().alert().accept();
    }

    @When("The manager adds a Test Cases")
    public void the_manager_adds_a_test_cases() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        matricesPage.testCaseInput.sendKeys("801");
        Thread.sleep(1000);
        matricesPage.lastListSubmitButton.click();
        Thread.sleep(1000);
    }



}
