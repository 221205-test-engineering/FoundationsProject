package dev.XPH.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ManagerPage {

    public WebDriver driver;

    public ManagerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/button")
    public WebElement saveMatrixButton;

    @FindBy(xpath = "/html/body/div/fieldset/table/tbody/tr/td[1]/input")
    public WebElement inputUserStoryRule;

    @FindBy(xpath = "/html/body/div/fieldset")
    public WebElement addRequirementButton;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/table/tbody/tr[1]/td[6]/button")
    public WebElement firstDefect;

    @FindBy(xpath = "/html/body/div/table/tbody/tr")
    public List<WebElement> defectListTableRows;



    @FindBy(xpath ="/html/body/div/fieldset/table/tbody/tr/td[2]/select")
    public WebElement DropDown55;


    public void selectDropDown(String numberString) {
        Select newSelect = new Select(DropDown55);
        newSelect.selectByValue(numberString);
    }

    @FindBy(xpath = "/html/body/div/fieldset/table/tbody/tr/td[3]/input")
    public WebElement inputNote;



    //    @FindBy(name = "title")
    @FindBy(xpath = "/html/body/div/input")
    public WebElement inputNewMatrixName;


    @FindBy(xpath = "/html/body/div/button")
    public WebElement newMatrixButton;

    @FindBy(xpath = "/html/body/div/nav/a")
    public List<WebElement> LinksList;

    public void linkIsDisplayed() {
        for (WebElement link : LinksList) {
            link.isDisplayed();
        }
    }

    @FindBy(linkText = "Matrices")
    public WebElement matricesLink;

    @FindBy(linkText = "Test Cases")
    public WebElement testCasesLink;

    @FindBy(xpath = "/html/body/div[1]/nav/a[3]")
    public WebElement ReportDefectLink;

    @FindBy(linkText = "Defect Overview")
    public WebElement DefectOverviewLink;


    @FindBy(xpath = "/html/body/div/h1")
    public static WebElement roleStatus;

    public static String getManagerStatus() {
        return roleStatus.getText();
    }

    @FindBy(tagName = "p")
    public static WebElement paragraphElement;

    public static String getPString() {
        return paragraphElement.getText();
    }


    @FindBy(xpath = "/html/body/div[1]/nav/p/text()[2]")
    public static WebElement firstName;

    @FindBy(xpath = "/html/body/div[1]/nav/p/text()[3]")
    public static WebElement lastName;

    @FindBy(xpath = "/html/body/div/table/tbody/tr/td[3]/button")
    public WebElement selectDefect;

    @FindBy(xpath = "/html/body/div/div/input")
    public static WebElement selectedList;


    @FindBy(xpath = "/html/body/div/div/input")
    public WebElement inputAssigned;


    public void selectDropDown() {
        Select newSelect = new Select(selectedList);
        newSelect.selectByValue("ryeGuy");
    }


    @FindBy(xpath = "/html/body/div/div/button")
    public WebElement assignButton;


    @FindBy(xpath = "/html/body/div/table")
    public WebElement defectTable;



    @FindBy(xpath ="/html/body/div[1]/ul/li")
    public static List<WebElement> defectList123;

    public static void expandList() throws InterruptedException {
        for (WebElement we : defectList123) {
            we.click();
            if(!we.getAttribute("innerText").contains("ryeGuy")){
                Assert.fail();
            } else {
                assertTrue(true);
            }
        Thread.sleep(500);
        }

    }

    @FindBy(xpath = "/html/body/div[1]/ul/li[5]/div/div/div/p[5]")
    public WebElement assignedInfo;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/span/button")
    public WebElement changeStatusButton;



    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/span/p/b[2]")
    public WebElement value55;

    @FindBy(xpath = "/html/body/div[1]/ul/li[1]/div/div/div/div[1]/div/div/button[1]")
    public WebElement AcceptStatusButton;

    public static String getFirstName() {
        String firstNameS = firstName.getText();
        System.out.println(firstNameS);
        return firstNameS;
    }

    public static String getLastName() {
        String lastNameS = lastName.getText();
        System.out.println(lastNameS);
        return lastNameS;
    }


}
