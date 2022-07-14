package com.academy.techcenture.pages;

import com.academy.techcenture.utilities.ConfigReader;
import com.academy.techcenture.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage {


    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='login']")
    protected WebElement signInLink;

    @FindBy(linkText = "Contact us")
    protected WebElement contactUsLink;

    @FindBy(className = "logout")
    protected WebElement signOutLink;
    @FindBy(xpath = "//img[contains(@class,'logo')]")
    private WebElement logo;


    public void navigateToHomePage() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        assertEquals("Titles do not match", "My Store", Driver.getDriver().getTitle());
        assertTrue("Logo is not displayed", logo.isDisplayed());
    }

    public void clickSingInLink() {
        assertTrue("Sign in link was not displayed", signInLink.isEnabled());
        //actions.click(signInLink).perform();
        signInLink.click();
        //wait.until(ExpectedConditions.titleIs("Login - My Store"));
    }

    public void clickContactUsLink() {
        assertTrue("Contact us link is not displayed", contactUsLink.isDisplayed());
        contactUsLink.click();
    }
}
