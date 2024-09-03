package StepDefination;

import DataFiles.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.util.Map;

public class SignUpLoginStepsNew {

    String randomEmail;
    String randomFirstName;
    String randomLastName;
    String randomPassword;

    WebDriver driver  ;

    HomePage homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountPage myaccount;

    public void SignUpLoginStepsNew() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get(Constants.URL);
    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        SignUpLoginStepsNew();

        driver.get(Constants.CREATEACCOUNTURL);

        // Generate random data
        randomEmail = TestDataRandom.getRandomEmail();
        randomFirstName = TestDataRandom.getRandomString(6);
        randomLastName = TestDataRandom.getRandomString(6);
        randomPassword = "Password@123";  // Password can be static or randomized if needed

        signUpPage  = homePage.clickCreateAccount();
    }

    @When("I login with the generated details:")
    public void i_login_with_the_generated_details(DataTable dataTable) {

        String email = randomEmail;
        String password = randomPassword;

        loginPage = homePage.clickOnSignInOption(); // If there is a need to navigate to login
        loginPage.login(email, password);
    }

    @When("I register with the following details:")
    public void i_register_with_the_following_details(Map<String, String> data) {

        myaccount = signUpPage.register(randomFirstName, randomLastName, randomEmail, randomPassword);
    }

    @Then("I should see the confirmation message {string}")
    public void i_should_see_the_confirmation_message(String expectedMessage) {
        String actualMessage = myaccount.getConfirmationMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("I log out")
    public void i_log_out() {
        homePage = myaccount.clickOnSignoutButton();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        SignUpLoginStepsNew();
        driver.get(Constants.URL);
        loginPage = homePage.clickOnSignInOption();
    }

    @When("I login with the following details:")
    public void i_login_with_the_following_details(DataTable dataTable) {

        Map<String, String> data = dataTable.asMap(String.class, String.class);
        String email = data.get("email");
        String password = data.get("password");

        loginPage = homePage.clickOnSignInOption();
        myaccount =loginPage.login(email, password);
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        String actualMessage = myaccount.getWelcomeMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("I should see the login failed message {string}")
    public void i_should_see_the_login_failed_message(String expectedMessage) {
        String actualMessage = loginPage.loginFailedMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
