package seleniumUtils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Asserts {

    String TEXTCONTAINS;

    WebDriver driver;

    public Asserts(WebDriver driver) {
        this.driver = driver;
    }
    public void validateContainsText(String TEXTCONTAINS){
        Assert.assertTrue(driver.getPageSource().contains(TEXTCONTAINS));
    }

    public void validateEqualsText(String msgEsperada, String equalsText){
        Assert.assertEquals(msgEsperada, driver.findElement(By.xpath(equalsText)).getText());
    }
}
