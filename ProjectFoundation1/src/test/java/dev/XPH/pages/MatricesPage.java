package dev.XPH.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MatricesPage {

    public WebDriver driver;

    public MatricesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


//    /html/body/div/ul/li[2]/div/span
    @FindBy(xpath = "/html/body/div/ul/li[1]/div/span/button")
    public WebElement showMX_One;


//    /html/body/div/ul/li[1]/div/div/div/ul[1]/li[4]/button

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li[last()]/button")
    public WebElement lastListSubmitButton;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li[last()]")
    public WebElement  dropDownDefectMenu;

    public void selectDropDown(String optionString) {
        Select newSelect = new Select(dropDownDefectMenu);
        newSelect.selectByValue(optionString);
    }

//    /html/body/div/ul/li[1]/div/div/div/ul[2]/li[2]/button
    @FindBy(xpath ="  /html/body/div/ul/li[1]/div/div/div/ul[1]/li[last()]/button")
    public WebElement addDefectButton;


    @FindBy(xpath ="/html/body/div/ul/li[1]/div/div/div/ul[2]/li[last()]/input")
    public WebElement DefectAddInput;


//    /html/body/div/ul/li[1]/div/div/div/ul[1]/li[4]/input
    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/ul[1]/li[last()]/input")
    public WebElement testCaseInput;


//    public WebElement


//    /html/body/div/ul/li[11]/div/div/div/button

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/table/tbody/tr[1]/td[6]/button")
    public WebElement editFirst;

    @FindBy(xpath = "/html/body/div/ul/li[1]/div/div/div/button")
    public WebElement SaveRequirementButton;

///html/body/div/ul/li[1]/div/div/div/button

}
