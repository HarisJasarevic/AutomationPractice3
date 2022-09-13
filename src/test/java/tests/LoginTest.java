package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Login;

public class LoginTest extends BaseTest {

    Login login;

    @BeforeMethod
    public void localSetup() {
        login = new Login(driver);
    }

    @Test
    public void loginUserTest() {
        login.loginUser("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(login.isUserLoggedIn());
    }




}//end class
