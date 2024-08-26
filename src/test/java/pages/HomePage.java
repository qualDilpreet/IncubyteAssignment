package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.BrowserDriver;

public class HomePage {

    WebDriver driver ;

    By createAccountLink = By.xpath("(//a[text()='Create an Account'])[1]");
By signin = By.xpath("(//ul[@class='header links']/li[2]/a)[1]");

    public HomePage (WebDriver driver) {
        this.driver = driver;

    }

    // Method to click the second edit icon
    public SignUpPage clickCreateAccount() {
        driver.findElement(createAccountLink).click();
        return new SignUpPage(driver);
    }

    public LoginPage clickOnSignInOption(){
        driver.findElement(signin).click();
        return new LoginPage(driver);
    }

}