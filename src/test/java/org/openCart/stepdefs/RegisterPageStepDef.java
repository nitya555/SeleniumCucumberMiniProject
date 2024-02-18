package org.openCart.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openCart.pages.LoginPage;
import org.openCart.pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.Utility;

import java.io.IOException;

public class RegisterPageStepDef {

    private WebDriver driver;
    private RegisterPage registerPage;

    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void teardown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on OpenCart Register page")
    public void i_am_on_openCart_register_page() throws IOException {
        driver.get(Utility.url("Register"));
        registerPage= new RegisterPage(driver);
    }

    @When("I clicked on not to subscribe")
    public void i_clicked_on_not_to_subscribe(){
        registerPage.clickNoSubscribeButton();
    }

    @When("I clicked on Agree and Continue")
    public void i_clicked_on_agree_and_continue(){
        registerPage.clickAgreeCheckBox();
        registerPage.clickContinueButton();
    }

    @Given("new account should be created successfully")
    public void new_account_should_be_created_successfully(){
        registerPage.validateAccountCreation();
    }

    @Then("Warning message should be populated {string}")
    public void warningMessageShouldBePopulated(String warning) {
        registerPage.validateWarning();
    }

    @Given("I have entered {string}, {string}, {string}, {string}, {string} and {string}")
    public void iHaveEnteredAnd(String FirstName, String LastName, String Email, String Telephone, String password, String confirm_password) {
        registerPage.enterFisrtName(FirstName);
        registerPage.enterLastName(LastName);
        registerPage.enterEmail(Email);
        registerPage.enterTelephoneNumber(Telephone);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirm_password);

    }
}
