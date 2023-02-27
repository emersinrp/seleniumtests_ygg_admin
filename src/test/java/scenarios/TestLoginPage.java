package scenarios;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestLoginPage {

    WebDriver driver;
    LoginPage loginPage;
    String urlMoisesLocal = "http://localhost:3000/";

    @Before
    public void setupBrowser(){
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.get(urlMoisesLocal);
        validateContainsText("Login Moisés");
    }

    public TestLoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Test
    public void testLoginSuccess(){
        loginPage.waitLoginButton();
        validateContainsText("Financeiro");
    }

    public void validateContainsText(String textContains){
        Assert.assertTrue(driver.getPageSource().contains(textContains));
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
