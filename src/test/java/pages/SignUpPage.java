package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By confirmPassword = By.name("password_confirmation");
    By createAccountButton = By.cssSelector("button[title='Create an Account']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterEmail(String emailAddress) {
        driver.findElement(email).sendKeys(emailAddress);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String confirmPwd) {
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
    }

    public AccountPage clickCreateAccount() {
        driver.findElement(createAccountButton).click();
        return new AccountPage(driver);

    }
}
