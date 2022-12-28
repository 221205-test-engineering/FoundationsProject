package dev.XPH.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestCasesPage {


    public WebDriver driver;



    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/form/fieldset[1]/textarea[1]")
    public WebElement inputDescription;
///html/body/div/fieldset[1]/textarea[1]

//    /html/body/div/fieldset[1]/textarea[2]
    @FindBy(xpath = "/html/body/div[1]/form/fieldset[1]/textarea[2]")
    public WebElement inputSteps;


    @FindBy(xpath = "/html/body/div[1]/form/fieldset/button")
    public WebElement submitTestCase;


    @FindBy(xpath = "/html/body/div[1]/table/tbody//tr[last()]/td[3]")
    public WebElement lastResultStatus;


    @FindBy(xpath = "/html/body/div[1]/table/tbody/tr[last()]/td[4]/button")
    public WebElement detailsButton;


    @FindBy(xpath = "/html/body/div[3]/div/div/h3")
    public WebElement modalTitle;



    @FindBy(xpath = "/html/body/div[3]/div/div/p[6]")
    public WebElement performedBy;


//    /html/body/div[3]/div/div/button[1]

    @FindBy(xpath = "/html/body/div[3]/div/div/button[1]")
    public WebElement closeModal;


    @FindBy(xpath = "/html/body/div[3]/div/div/button[2]/a")
    public WebElement editModal;


    @FindBy(xpath = "/html/body/div/button[contains(text(),'Edit')]")
    public WebElement edit2;


    @FindBy(xpath = "/html/body/div/fieldset[1]/textarea[1]")
    public WebElement textInput5;


    @FindBy(xpath = "/html/body/div/fieldset[1]/textarea[2]")
    public WebElement textInput77;



    @FindBy(xpath = "/html/body/div/fieldset[1]/input")
    public WebElement checkBox23;


    @FindBy(xpath = "/html/body/div/fieldset[1]/select")
    public WebElement selectedList;


    public void selectDropDown(String string) {
        Select newSelect = new Select(selectedList);
        newSelect.selectByValue(string);
    }


    @FindBy(xpath = "/html/body/div/fieldset[2]/select")
    public WebElement selectedList2;


    public void selectDropDown2(String string) {
        Select newSelect = new Select(selectedList2);
        newSelect.selectByValue(string);
    }


    @FindBy(xpath = "/html/body/div/fieldset[2]/textarea")
    public WebElement textInput909;


    @FindBy(xpath = "/html/body/div/button[2]")
    public WebElement submitEdit3;


    @FindBy(xpath = " /html/body/div/button[contains(text(),'Reset')]")
    public WebElement resetButton;


}
