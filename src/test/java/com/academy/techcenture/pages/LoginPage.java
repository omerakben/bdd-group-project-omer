package com.academy.techcenture.pages;

import com.academy.techcenture.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage extends HomePage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginBtn;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//label[@for='passwd']")
    private WebElement passwdLabel;

    @FindBy(xpath = "//a[contains(@title, 'Recover your forgotten')]")
    private WebElement forgotPswdLink;

    @FindBy(xpath = "//h3[contains(text(),'Already registered?')]")
    private WebElement loginHeaderTxt;

    @FindBy(id = "login_form")
    private WebElement loginForm;


    public void enterUserName(String username) {
        assertTrue("Email label was not displayed", emailLabel.isDisplayed());
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        assertTrue("Forgot passwd is not displayed", forgotPswdLink.isDisplayed());
        assertTrue("Password label was not displayed", passwdLabel.isDisplayed());
        passwdInput.clear();
        passwdInput.sendKeys(password);
    }

    public void clickOnLoginBtn() {
        assertEquals("sign in", loginBtn.getText().toLowerCase().trim());
        assertTrue("Login Btn is not enabled", loginBtn.isEnabled());
        loginBtn.click();
    }

    public void verifyUserIsOnLoginPage() {
        String loginTitle = Driver.getDriver().getTitle();
        assertEquals("Titles are not matching", "Login - My Store", loginTitle);
        assertTrue("Login Header was not displayed", loginHeaderTxt.isDisplayed());
        assertTrue("Login form is not there", loginForm.isDisplayed());
    }

}
