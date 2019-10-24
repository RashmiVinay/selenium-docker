package com.QualiTest.NewTours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Flight')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffBtn;

    public FlightConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, 50);
        PageFactory.initElements(driver,this);
    }

    public String getPrices()
    {
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(this.flightConfirmationHeader.getText());
        System.out.println(this.prices.get(1).getText());
        String prices=this.prices.get(1).getText();
        this.signOffBtn.click();
        return prices;
    }


}
