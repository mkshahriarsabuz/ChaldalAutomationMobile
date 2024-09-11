package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.DriverSetup.getDriver;


public class BasePage {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    public WebElement getElement(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnAElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public boolean isElementVisible(By locator){
        try {
            return getElement(locator).isDisplayed();
        }
        catch (Exception e){return false;}
    }

}
