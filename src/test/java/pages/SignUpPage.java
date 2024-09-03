package pages;

import DataFiles.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    WebDriver driver;

    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By email = By.id("email_address");
    By password = By.id("password");
    By confirmPassword = By.name("password_confirmation");
    By createAccountButton = By.cssSelector("button[title='Create an Account']");
    By createNewCustomerAccountMsg = By.xpath("//span[text()='Create New Customer Account']");

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterFirstName(String fname) {
        sendKeys(firstName,fname,"firstName");
    }

    public void enterLastName(String lname) {
        sendKeys(lastName,lname,"LastName");
    }

    public void enterEmail(String emailAddress) {
        sendKeys(email,emailAddress,"emailAddress");
    }

    public void enterPassword(String pwd) {
        sendKeys(password,pwd,"password");
    }

    public void enterConfirmPassword(String confirmPwd) {
        sendKeys(confirmPassword,confirmPwd,"confirmPassword");
    }

    public AccountPage register(String firstN, String lastN, String emailID, String pass) {
        sendKeys(firstName,firstN,"firstName");
        sendKeys(lastName,lastN,"LastName");
        sendKeys(email,emailID,"emailID");
        sendKeys(password,pass,"password");
        sendKeys(confirmPassword,pass,"confirmPassword");
        click(createAccountButton,"Create Account Button");
        return new AccountPage(driver);
    }

    public String createNewCustomerAccountMsgGetText(){
      String text = getText(createNewCustomerAccountMsg,"Create New Customer Account Msg");
     return text;
    }

    public AccountPage clickCreateAccount() {
        driver.findElement(createAccountButton).click();
        return new AccountPage(driver);
    }
}
