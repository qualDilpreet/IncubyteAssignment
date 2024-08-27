package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage  {

    WebDriver driver ;

    By dropdownButton = By.xpath("(//span[@data-toggle='dropdown' and @class='customer-name'])[1]");
    By signout = By.xpath("(//div[@data-target='dropdown']/ul/li/a)[3]");
  By contactInformationText = By.xpath("//div[contains(@class,'box box-information')]/div/p");

    // Constructor
    public AccountPage (WebDriver driver) {
        this.driver = driver;
    }

    // Method to click the second edit icon
    public HomePage clickOnSignoutButton() {
        driver.findElement(dropdownButton).click();
        driver.findElement(signout).click();
        return new HomePage(driver);
    }

    public String contactInformationGetText(){
      String contactInformation = driver.findElement(contactInformationText).getText();
       return contactInformation;
    }

    public void closeBrowser(){
        driver.quit();
    }
}
