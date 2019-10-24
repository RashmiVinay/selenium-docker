package com.QualiTest.Newtours.Tests;

import ScriptHelper.BaseTest;
import com.QualiTest.NewTours.Pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlight extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassengers", "expectedPrice"})
    public void setUpParamter(String noOfPassengers, String expectedPrice){
        this.noOfPassengers=noOfPassengers;
        this.expectedPrice=expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("Selenium", "Docker");
        registrationPage.enterUserCredentials("Selenium", "Docker", "Docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightRegistrationPage(){
        FlightRegistrationPage flightRegistrationPage=new FlightRegistrationPage(driver);
        flightRegistrationPage.selectNoOfPassengers(noOfPassengers);
        flightRegistrationPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightRegistrationPage")
    public void findFlightPage(){
        FindFlightPage flightPage=new FindFlightPage(driver);
        flightPage.submitFlightPage();
        flightPage.goToFlightConfirmation();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage=new FlightConfirmationPage(driver);
        String actualPrice=flightConfirmationPage.getPrices();
        Assert.assertEquals(actualPrice, expectedPrice);
    }
}
