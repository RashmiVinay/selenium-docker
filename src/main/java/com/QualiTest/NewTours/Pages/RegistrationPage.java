package com.QualiTest.NewTours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(name="email")
    private WebElement userNameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPwdTxt;

    @FindBy(name="register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, 50);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName, String pwd, String confirmPwd){
        this.userNameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(pwd);
        this.confirmPwdTxt.sendKeys(confirmPwd);
    }

    public void submit(){
        this.submitBtn.click();
    }
}
