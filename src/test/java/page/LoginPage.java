package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

   WebDriver driver;
   String LOGINBUTTON = "//a[1]/button[1]/div[1]/span[1]";

   public LoginPage(WebDriver driver) {
       this.driver = driver;
   }

   public void waitLoginButton(){
       boolean btnLoginVisible = false;

       while (!btnLoginVisible) {
           try {
               driver.findElement(By.xpath(LOGINBUTTON)).click();
               btnLoginVisible = true;
           } catch (Exception e) {
               btnLoginVisible = false;
           }
       }
   }
}
