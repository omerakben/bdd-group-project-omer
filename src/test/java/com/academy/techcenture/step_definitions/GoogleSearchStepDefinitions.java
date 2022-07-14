package com.academy.techcenture.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.academy.techcenture.utilities.Driver.getDriver;

public class GoogleSearchStepDefinitions {

    @Given("user goes to google search page")
    public void user_goes_to_google_search_page() throws InterruptedException {

        getDriver().get("https://www.google.com");
        String  googleTitle = getDriver().getTitle();
        Assert.assertEquals("Titles don't match", "Google", googleTitle);
        Thread.sleep(3000);

    }

    @When("user enters {string} in the search input box")
    public void user_enters_in_the_search_input_box(String searchKeyword) {
        getDriver().findElement(By.name("q")).sendKeys(searchKeyword);
    }

    @And("user presses enter key")
    public void user_presses_enter_key() {
        getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("user should see results for searched item")
    public void user_should_see_results_for_searched_item() {

        String pageSource = getDriver().getPageSource();
        Assert.assertTrue("page source does not contains the searched keyword", pageSource.toLowerCase().contains("unicorns"));

    }

    @When("clicks on about link on top right")
    public void clicksOnAboutLinkOnTopRight() {
        WebElement aboutLnk = getDriver().findElement(By.xpath("//a[text()='About']"));
        Assert.assertTrue("about link is not displayed", aboutLnk.isDisplayed());
        new Actions(getDriver()).moveToElement(aboutLnk).click().perform();
    }

    @Then("user can see mission statement at the center")
    public void userCanSeeMissionStatementAtTheCenter() {
        WebElement missionStatement = getDriver().findElement(By.xpath("//h1[starts-with(@class,'modules-lib__mission-statement__headline')]"));
        Assert.assertTrue(missionStatement.isDisplayed());
        Assert.assertEquals("Mission statement does not match", missionStatement.getText().trim(), "Our mission is to organize the world’s information and make it universally accessible and useful.");

    }

}
