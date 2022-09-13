package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected WebElement getElement(By locator) {      //helper metode koje ćemo smjestiti na jedno mjesto i koje će koristiti sve ostale klase po potrebi
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator)); //500ms - pooling (explicit wait)
        //return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element;
    }

    protected void typeIn(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clickOnElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


}//end class
