package com.academy.techcenture.step_definitions;

import com.academy.techcenture.pages.ContactUsPage;
import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsStepDef {

    private HomePage homepage;
    private LoginPage loginPage;
    private ContactUsPage contactUsPage;

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        homepage = new HomePage();
        homepage.navigateToHomePage();
    }

    @When("user clicks on the sign in link")
    public void user_clicks_on_the_sign_in_link() {
        homepage.clickSingInLink();
    }

    @Then("user should be navigated to Login Page")
    public void user_should_be_navigated_to_login_page() {
        loginPage = new LoginPage();
        loginPage.verifyUserIsOnLoginPage();
    }

    @Then("user logins with {string} and {string}")
    public void user_logins_with_and(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginBtn();
    }

    @Given("user clicks on Contact Us link")
    public void user_clicks_on_contact_us_link() {
        homepage.clickContactUsLink();
    }

    @Then("user should be navigated to Contact Us Page")
    public void user_should_be_navigated_to_contact_us_page() {
        contactUsPage = new ContactUsPage();
        contactUsPage.verifyUserIsOnLoginPage();
    }

    @Then("user selects {string} as a subject heading")
    public void user_selects_as_a_subject_heading(String heading) {
        contactUsPage.selectsHeading(heading);
    }

    @Then("user email {string} should be auto-populated")
    public void user_email_should_be_auto_populated(String email) {
        contactUsPage.verifyEmailAutoPopulated(email);
    }

    @Then("user should pick {string} from the reference dropdown")
    public void user_should_pick_from_the_reference_dropdown(String reference) {
        contactUsPage.verifyOrderReference(reference);

    }

    @Then("user should attach a picture from path {string}")
    public void user_should_attach_a_picture_from_path(String picture) {
        contactUsPage.attachAPicture(picture);
    }

    @Then("user should enter {string} in the message input")
    public void user_should_enter_in_the_message_input(String message) {
        contactUsPage.enterMessageInput(message);
    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {
        contactUsPage.clickSendButton();
    }

    @Then("user should see success message {string}")
    public void user_should_see_success_message(String alert) {
        contactUsPage.verifyAlertMessage(alert);
    }

    @Then("user enters {string} in the email input")
    public void user_enters_in_the_email_input(String email) {
        contactUsPage.enterEmailInput(email);
    }

    @Then("user enters {string} in the reference input")
    public void user_enters_in_the_reference_input(String reference) {
        contactUsPage.enterOrderReferenceInput(reference);
    }

    @Then("user should see un success message {string}")
    public void userShouldSeeUnSuccessMessage(String alert) {
        contactUsPage.verifyUnSuccessAlertMessage(alert);
    }
}
