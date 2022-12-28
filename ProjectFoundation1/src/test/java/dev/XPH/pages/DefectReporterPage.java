package dev.XPH.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectReporterPage {



    public WebDriver driver;

    public DefectReporterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[1]/form/input[1]")
    public WebElement dateInput;

    //*[@id="defectReport"]/textarea[1]
    @FindBy(xpath = "/html/body/div[1]/form/textarea[1]")
    public WebElement descriptionInput;


    @FindBy(xpath = "/html/body/div[1]/form/textarea[2]")
    public WebElement Input3;


    @FindBy(xpath = "/html/body/div[1]/form/input[2]")
    public WebElement severityInput;

    @FindBy(xpath = "/html/body/div[1]/form/input[3]")
    public WebElement priorityInput;


    @FindBy(xpath = "/html/body/div[1]/form/button")
    public WebElement reportButton;


    @FindBy(xpath = "/html/body/div[3]/div/div/h4")
    public WebElement modaldfectId;


    @FindBy(xpath = "/html/body/div[3]/div/div/button")
    public WebElement closeModalButton;

}
