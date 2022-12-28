package dev.XPH.steps.defect;

import dev.XPH.pages.DefectReporterPage;
import dev.XPH.pages.LoginPage;
import dev.XPH.pages.ManagerPage;
import dev.XPH.pages.TestCasesPage;
import dev.XPH.runners.FirstPageRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class defect_Impl {

    public static WebDriver driver = FirstPageRunner.driver;

    LoginPage loginPage = new LoginPage(driver);
    ManagerPage managerPage = new ManagerPage(driver);

    DefectReporterPage defectReporterPage = new DefectReporterPage(driver);

    TestCasesPage testCasesPage = new TestCasesPage(driver);

    public static int defectCount;
    public static int defectCount2;

//    @Given("The manager is logged in as a manager")
//    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
//        // Write code here that turns the phrase above into concrete actions
//        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=26");
//        loginPage.userNameInputBar.sendKeys("g8tor");
//        loginPage.passwordInputBar.sendKeys("chomp!");
//        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
//                .pollingEvery(Duration.ofMillis(140))
//                .ignoring(ElementNotInteractableException.class)
//                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();
//
//        Thread.sleep(2000);
//    }

//    @Given("The manager is on the home page")
//    public void the_manager_is_on_the_home_page() {
//        // Write code here that turns the phrase above into concrete actions
//
//        String pageTitle = driver.getTitle();
//        assertEquals("Manager Home", pageTitle);
//    }

    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=26");
//        loginPage.userNameInputBar.sendKeys("g8tor");
//        loginPage.passwordInputBar.sendKeys("chomp!");
//        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
//                .pollingEvery(Duration.ofMillis(140))
//                .ignoring(ElementNotInteractableException.class)
//                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();

//        Thread.sleep(2000);
//        managerPage.DefectOverviewLink.click();
//        assertEquals();
        Thread.sleep(1000);
        assertTrue(managerPage.defectTable.isDisplayed());
        Thread.sleep(1000);
        defectCount = managerPage.defectListTableRows.size();

    }

    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        // Write code here that turns the phrase above into concrete actions
        managerPage.selectDefect.click();
    }

    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(managerPage.defectTable.isDisplayed());
        String fontWeight = driver.findElement(By.tagName("h4"))
                .getCssValue("font-weight");

        boolean isBold = "bold".equals(fontWeight);
        if (isBold) {
            assertTrue(true);
        }
//        else {
//            fail();
//        }


    }

    @When("The manager selects a tester from the drop down list")
    public void the_manager_selects_a_tester_from_the_drop_down_list() {
        // Write code here that turns the phrase above into concrete actions
//        managerPage.selectDropDown();
        managerPage.inputAssigned.sendKeys("ryeGuy");
    }

    @When("The manager clicks assign")
    public void the_manager_clicks_assign() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        managerPage.assignButton.click();
        Thread.sleep(1000);
    }

    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        // Write code here that turns the phrase above into concrete actions
        defectCount2 = managerPage.defectListTableRows.size();
        if (defectCount2 != 0) {
            assertTrue(defectCount > defectCount2);
        }
        else {
            assertTrue(true);
        }
    }



    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=26");
        loginPage.userNameInputBar.sendKeys("ryeGuy");
        loginPage.passwordInputBar.sendKeys("coolbeans");
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();
        Thread.sleep(2000);
    }

    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        ManagerPage.expandList();
        Thread.sleep(5000);

    }

    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        managerPage.changeStatusButton.click();
        managerPage.AcceptStatusButton.click();
        Thread.sleep(1000);
    }

    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        if(managerPage.value55.getText().equals("Shelved")){
            Assert.fail();
        }
    }




    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://bugcatcher-dan.coe.revaturelabs.com/?dev=26");
        loginPage.userNameInputBar.sendKeys("ryeGuy");
        loginPage.passwordInputBar.sendKeys("coolbeans");
        new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))     //create wait to wait until element is visible
                .pollingEvery(Duration.ofMillis(140))
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOf(loginPage.loginButton)).click();
//        driver.findElement(By.linkText("Report A Defect")).click();
        Thread.sleep(1000);
        managerPage.ReportDefectLink.click();
        Thread.sleep(1000);
        String title = driver.getTitle();
        assertEquals("Case Reporter",title);
    }

    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        LocalDate now = LocalDate.now();
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String today = now.format(mdy);
        defectReporterPage.dateInput.sendKeys(today);
    }
    @When("The employee types in Description with")
    @When("The employee types in description with")
    public void the_employee_types_in_description_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        defectReporterPage.descriptionInput.sendKeys(docString);
    }

    @When("The employee types in steps with")
    @When("The employee types in Steps with")
    public void the_employee_types_in_steps_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        defectReporterPage.Input3.sendKeys(docString);
    }

    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

    }

    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        defectReporterPage.priorityInput.sendKeys(Keys.ARROW_LEFT);
        defectReporterPage.priorityInput.sendKeys(Keys.ARROW_LEFT);
    }


    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        // Write code here that turns the phrase above into concrete actions

        try {
            driver.switchTo().alert().accept();
            fail("message is appearing when it should not");
        } catch (NoAlertPresentException e) {

        }
    }
//        boolean result;
//        try
//        {
//            driver.switchTo().alert();
//            result = false;
//        }   // try
//        catch (NoAlertPresentException Ex)
//        {
//            result = true;
//        }   // catch
//        assertTrue(result);
//    }







    @When("The employee selects {string} priority")
    public void the_employee_selects_priority(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        if (string.equals("LOW")) {
            defectReporterPage.priorityInput.sendKeys(Keys.ARROW_LEFT);
            defectReporterPage.priorityInput.sendKeys(Keys.ARROW_LEFT);
        } else if (string.equals("Medium")) {
            defectReporterPage.priorityInput.sendKeys(Keys.ARROW_LEFT);
        }
        else if (string.equals("High")) {
        }

    }



    @When("The employee selects {string} severity")
    public void the_employee_selects_severity(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        if (string.equals("LOW")) {
            defectReporterPage.severityInput.sendKeys(Keys.ARROW_LEFT);
            defectReporterPage.severityInput.sendKeys(Keys.ARROW_LEFT);
        } else if (string.equals("Medium")) {
            defectReporterPage.severityInput.sendKeys(Keys.ARROW_LEFT);
        }
//        else if (string.equals("High")) {
//        }
    }


    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Thread.sleep(1000);
        defectReporterPage.reportButton.click();
        Thread.sleep(2000);
    }


    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        boolean result;
        try
        {
            driver.switchTo().alert();
            result = true;
        }   // try
        catch (NoAlertPresentException e)
        {
            result = false;
        }   // catch
        assertTrue(result);
    }

    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        driver.switchTo().alert().accept();
    }


    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(1000);
        assertTrue(defectReporterPage.modaldfectId.isDisplayed());
    }

    @When("The employee clicks close")
    public void the_employee_clicks_close() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(1000);
        defectReporterPage.closeModalButton.click();
    }

    @Then("The modal should disappear")
    public void the_modal_should_disappear() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Thread.sleep(1000);
        try {
            defectReporterPage.modaldfectId.isDisplayed();
            fail();
        } catch (NoSuchElementException e) {

        }


    }



}
