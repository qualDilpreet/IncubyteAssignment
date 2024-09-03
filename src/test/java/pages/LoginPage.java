package pages;

import DataFiles.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver ;

    By emailAddress = By.id("email");
    By password = By.id("pass");
    By signIn = By.name("send");

    public LoginPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterEmail(String email) {
        sendKeys(emailAddress, email,"Email Address");
    }

    public void enterPassword(String pass) {
        sendKeys(password, pass,"Password");
    }

    public void clickSignIn(){
        click(signIn, "SignIn Option");
    }

    public AccountPage login(String email, String pass) {
        sendKeys(emailAddress,email, "Email Address");
        sendKeys(password,pass,"Password");
        click(signIn, "SignIn");
       return new AccountPage (driver);
    }

}
