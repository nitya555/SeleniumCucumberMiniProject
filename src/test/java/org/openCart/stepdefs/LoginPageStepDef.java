package org.openCart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openCart.pages.LoginPage;
import utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class LoginPageStepDef {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() throws IOException {
        driver.get(Utility.url("Login"));
        loginPage = new LoginPage(driver);
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password(){
        loginPage.enterEmail("qatestertest@gmail.com");
        loginPage.enterPassword("Test@123");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password){
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button(){
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully(){
        Assert.assertTrue(loginPage.checkLogoutLink());
    }

    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage){
        // Assert that an error message is displayed on the page matching the expected error message
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed());
    }

    @When("I click on the \"Forgotten Password\" link")
    public void i_click_on_the_forgotten_password_link(){
        loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        Assert.assertTrue(loginPage.getForgotPwdUUrl().contains("account/forgotten"));
    }
}
