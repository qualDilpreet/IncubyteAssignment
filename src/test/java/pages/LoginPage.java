package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver ;

    By emailAddress = By.id("email");
    By password = By.id("pass");
    By signIn = By.name("send");

    // Constructor
    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    // Method to click the second edit icon
    public void enterEmail(String email) {
        driver.findElement(emailAddress).sendKeys(email);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickSignIn(){
        driver.findElement(signIn).click();
    }
}
