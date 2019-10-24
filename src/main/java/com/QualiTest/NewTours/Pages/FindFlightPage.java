package com.QualiTest.NewTours.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="reserveFlights")
    private WebElement reserveFlightBtn;

    @FindBy(name="buyFlights")
    private WebElement bookFlight;

    public FindFlightPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,50);
        PageFactory.initElements(driver,this);
    }

    public void submitFlightPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(reserveFlightBtn));
        this.reserveFlightBtn.click();
    }

    public void goToFlightConfirmation(){
        this.wait.until(ExpectedConditions.elementToBeClickable(bookFlight));
        this.bookFlight.click();
    }
}
