package DataFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_SECONDS);
    }

    protected void click(By by, WaitFor waitStrategy, String nameOfTheElement) {
        try {
            performExplicitWait(waitStrategy, by).click();
        } catch (TimeoutException e) {
            throw e;
        }
    }

    protected void click(By by, String nameOfTheElement) {
        try {
            performExplicitWait(WaitFor.VISIBILITY, by).click();
        } catch (TimeoutException e) {
            throw e;
        }
    }

    protected void sendKeys(By by, String value, WaitFor waitStrategy, String nameOfTheElement) {
        try {
            performExplicitWait(waitStrategy, by).sendKeys(value);
        } catch (TimeoutException e) {
            throw e;
        }
    }

    protected void sendKeys(By by, String value, String nameOfTheElement) {
        try {
            performExplicitWait(WaitFor.VISIBILITY, by).sendKeys(value);
        } catch (TimeoutException e) {
            throw e;
        }
    }

    protected String getText(By by, String nameOfTheElement) {
        try {
            String text = performExplicitWait(WaitFor.VISIBILITY, by).getText();
            return text;
        } catch (TimeoutException e) {
            return null;
        }
    }

    public  WebElement performExplicitWait(WaitFor waitStrategy, By by) {

        WebElement webelement;
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_SECONDS);

        switch (waitStrategy) {
            case CLICABILITY -> webelement = wait.until(ExpectedConditions.elementToBeClickable(by));
            case VISIBILITY -> webelement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case PRESENCE -> webelement = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            default -> webelement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        return webelement;
    }

}
