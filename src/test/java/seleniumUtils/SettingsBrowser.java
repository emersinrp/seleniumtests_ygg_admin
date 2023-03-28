package seleniumUtils;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.NewPromotionPage;

import java.util.concurrent.TimeUnit;

public class SettingsBrowser {
    WebDriver driver;
    NewPromotionPage newPromotionPage;

    public SettingsBrowser(WebDriver driver) {
        this.driver = driver;
    }

    public void setupBrowser(String urlPagina){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.get(urlPagina);
    }

    public void closeBrowser(){
        driver.quit();
    }
}
