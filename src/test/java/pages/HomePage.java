package pages;

import DataFiles.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    WebDriver driver ;

    By createAccountLink = By.xpath("(//a[text()='Create an Account'])[1]");
    By signin = By.xpath("(//ul[@class='header links']/li[2]/a)[1]");

    public HomePage (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public SignUpPage clickCreateAccount() {
        click(createAccountLink, "Create Account Link");
        return new SignUpPage(driver);
    }

    public LoginPage clickOnSignInOption(){
        click(signin, "Sign in Option");
        return new LoginPage(driver);
    }

}