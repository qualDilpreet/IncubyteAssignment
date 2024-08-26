package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.UUID;

public class SignUpLoginSteps {

    WebDriver driver;
    HomePage homePage;
    SignUpPage signUpPage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
    }

    @When("I sign up with random details")
    public void i_sign_up_with_random_details() {
        TestData.randomFirstName = "John" + UUID.randomUUID().toString().substring(0, 5);
        TestData.randomLastName = "Doe" + UUID.randomUUID().toString().substring(0, 5);
        TestData.randomEmail = "user" + UUID.randomUUID().toString().substring(0, 5) + "@example.com";
        TestData.randomPassword = "Password" + UUID.randomUUID().toString().substring(0, 3);

        homePage.clickCreateAccount();
        signUpPage.enterFirstName(TestData.randomFirstName);
        signUpPage.enterLastName(TestData.randomLastName);
        signUpPage.enterEmail(TestData.randomEmail);
        signUpPage.enterPassword(TestData.randomPassword);
        signUpPage.enterConfirmPassword(TestData.randomPassword);

        accountPage = signUpPage.clickCreateAccount();
        accountPage.clickOnSignoutButton().clickOnSignInOption();
    }

    @Then("I should be able to login with the same credentials")
    public void i_should_be_able_to_login_with_the_same_credentials() {

        loginPage.enterEmail(TestData.randomEmail);
        loginPage.enterPassword(TestData.randomPassword);
        loginPage.clickSignIn();

        // Additional assertions can be added here to verify successful login
    }


}
