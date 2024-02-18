package org.openCart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    
    public RegisterPage(WebDriver driver){ this.driver = driver;}
    
    private By firstname = By.id("input-firstname");
    private By lastname = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By subscribe_no = By.xpath("//input[@name='newsletter' and @value='0']");
    private By agreeCheckBox = By.xpath("//input[@name='agree']");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By warning = By.xpath("//*[text()=' Warning: E-Mail Address is already registered!']");
    private By accountCreated_Message = By.xpath(" //div/h1");
    public void enterFisrtName(String FirstName){
        driver.findElement(firstname).sendKeys(FirstName);
    }

    public void enterLastName(String LastName){
        driver.findElement(lastname).sendKeys(LastName);
    }

    public void enterEmail(String Email){
        driver.findElement(email).sendKeys(Email);
    }

    public void enterTelephoneNumber(String TelephoneNumber){
        driver.findElement(telephone).sendKeys(TelephoneNumber);
    }

    public void enterPassword(String Password){
        driver.findElement(password).sendKeys(Password);
    }

    public void enterConfirmPassword(String ConfirmPassword){
        driver.findElement(confirmPassword).sendKeys(ConfirmPassword);
    }
    
    public void clickNoSubscribeButton(){
        driver.findElement(subscribe_no).click();
    }

    public void clickAgreeCheckBox(){driver.findElement(agreeCheckBox).click();}

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public boolean validateWarning(){
        return driver.findElement(warning).isDisplayed();
    }

    public boolean validateAccountCreation(){
        return driver.findElement(accountCreated_Message).getText().contains("Your Account Has Been Created");
    }
}
