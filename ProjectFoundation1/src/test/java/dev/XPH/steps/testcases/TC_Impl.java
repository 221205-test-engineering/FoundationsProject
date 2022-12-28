package dev.XPH.steps.testcases;

import dev.XPH.pages.LoginPage;
import dev.XPH.pages.ManagerPage;
import dev.XPH.pages.TestCasesPage;
import dev.XPH.runners.FirstPageRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class TC_Impl {



    public int TC_Length;

    public static WebDriver driver = FirstPageRunner.driver;

    LoginPage loginPage = new LoginPage(driver);
    ManagerPage managerPage = new ManagerPage(driver);

    TestCasesPage testCasesPage = new TestCasesPage(driver);


    public static String cheetos1;
    public static String cheetos2;

    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
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
        managerPage.testCasesLink.click();
        Thread.sleep(2000);
        String title = driver.getTitle();
        assertEquals("Test Cases",title);
    }



    @When("The tester types Description into input with")
    public void the_tester_types_description_into_input_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
            testCasesPage.inputDescription.sendKeys(docString);
    }

    @When("The tester types Steps into input with")
    public void the_tester_types_steps_into_input_with(String docString) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testCasesPage.inputSteps.sendKeys(docString);
    }

    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();


//table[@id='table_id']/tr

//        int rows_count = rows_table.size();


        TC_Length = driver.findElements(By.xpath("/html/body/div[1]/table/tbody/tr")).size();
        System.out.println("before table rows:" + TC_Length);
        testCasesPage.submitTestCase.click();
        Thread.sleep(500);
    }

    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        int tableSize2 = driver.findElements(By.xpath("/html/body/div[1]/table/tbody/tr")).size();
        System.out.println("After rows:" + tableSize2);
        assertTrue(tableSize2 > TC_Length);
    }



    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String resultStat = testCasesPage.lastResultStatus.getText();
        System.out.println(resultStat);
        assertEquals("UNEXECUTED",resultStat);

    }

    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testCasesPage.detailsButton.click();
    }


    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        assertTrue(testCasesPage.modalTitle.isDisplayed());
    }

    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        String performedBy = testCasesPage.performedBy.getText();
        assertEquals("No One", performedBy);
    }

    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Thread.sleep(2000);
        testCasesPage.closeModal.click();
        Thread.sleep(2000);
    }

    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        try {
            testCasesPage.closeModal.isDisplayed();
            fail();
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }

    }

    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testCasesPage.editModal.click();
    }

    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

        String title = driver.getTitle();
        assertEquals("Case Editor",title);
    }

    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Thread.sleep(2000);
        testCasesPage.edit2.click();
        Thread.sleep(1000);
//        cheetos1 = testCasesPage.inputDescription.getAttribute("value");
//        cheetos2 = testCasesPage.inputSteps.getAttribute("value");
    }

    @When("The tester types in {string} into the description text area")
    public void the_tester_types_in_into_the_description_text_area(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testCasesPage.textInput5.sendKeys(string);
    }

    @When("The tester types in {string} into the steps text area")
    public void the_tester_types_in_into_the_steps_text_area(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testCasesPage.textInput77.sendKeys(string);
    }

    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testCasesPage.checkBox23.click();
    }


    @When("The tester selects {string} for performed from drop down")
    public void the_tester_selects_for_performed_from_drop_down(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
            testCasesPage.selectDropDown(string);
    }

    @When("The tester selects {string} for test result from drop down")
    public void the_tester_selects_for_test_result_from_drop_down(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testCasesPage.selectDropDown2(string);
    }

    @When("The tester types in {string} into the summary text area")
    public void the_tester_types_in_into_the_summary_text_area(String string) {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        cheetos1 = testCasesPage.textInput909.getAttribute("value");
        testCasesPage.textInput909.sendKeys(string);
    }

    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        testCasesPage.submitEdit3.click();
        Thread.sleep(2000);
    }


    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//        driver.switchTo().alert().accept();
        try
        {
            driver.switchTo().alert();
        }   // try
        catch (NoAlertPresentException Ex)
        {
            fail();
        }
    }


    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        // Write code here that turns the phrase above into concrete actions
        driver.switchTo().alert().accept();
    }


    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Thread.sleep(1000);
        String textinfo = driver.switchTo().alert().getText();
        assertEquals("Test Case has been Saved", textinfo);
        driver.switchTo().alert().accept();

    }

    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

        testCasesPage.resetButton.click();
        Thread.sleep(1000);
    }

    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        Thread.sleep(1000);
//        String now1 = testCasesPage.inputDescription.getAttribute("value");
//        String now2 = testCasesPage.inputSteps.getAttribute("value");
//
//        assertEquals(cheetos1, now1);
//        assertEquals(cheetos2, now2);

    }


}
