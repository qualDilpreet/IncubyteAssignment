package pages;

import DataFiles.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    WebDriver driver ;

    By dropdownButton = By.xpath("(//span[@data-toggle='dropdown' and @class='customer-name'])[1]");
    By signout = By.xpath("(//div[@data-target='dropdown']/ul/li/a)[3]");
    By contactInformationText = By.xpath("//div[contains(@class,'box box-information')]/div/p");
    By registrationSuccessMessage = By.xpath("//div[@data-ui-id='message-success']/div");
    By welcomeMessage = By.xpath("(//span[contains(text(),'Welcome,')])[1]");

    public AccountPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage clickOnSignoutButton(){
        click(dropdownButton, "DropDown Button");
        click(signout, "Signout Button");
        return new HomePage(driver);
    }

    public String contactInformationGetText(){
        String contactInformation = getText(contactInformationText, "contactInformationText");
       return contactInformation;
    }

    public void closeBrowser(){
        driver.quit();
    }

    public String getConfirmationMessage() {
       return getText(registrationSuccessMessage, "registrationSuccessMessage");
    }

    public String getWelcomeMessage() {
        return getText(welcomeMessage,"Welcome Message");
    }
}
