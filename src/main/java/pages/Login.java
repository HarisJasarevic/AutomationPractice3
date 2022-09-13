package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage {

    By passwordField = By.name("password");
    By usernameField = By.cssSelector("input[name='username']");
    By loginButton = By.className("radius");
    By expectedLoggedInElement = By.id("flash");

    public Login(WebDriver driver) {
        super(driver);
    }

    public void loginUser(String username, String password) {
        typeIn(usernameField, username);
        typeIn(passwordField, password);
        clickOnElement(loginButton);

    }

    public boolean isUserLoggedIn() {
        String actual[] = getElement(expectedLoggedInElement).getText().split("(?<=!)");
        String actualText = actual[0];
        String actualBacgroundColor = getElement(expectedLoggedInElement).getCssValue("background-color");
        String expectedText = "You logged into a secure area!";
        String expectedColor = "rgba(93, 164, 35, 1)";
        if (expectedText.equals(actualText) && actualBacgroundColor.equals(expectedColor)) {
            return true;
        }
        return false;
    }



}//end class
