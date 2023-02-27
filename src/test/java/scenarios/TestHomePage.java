package scenarios;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import page.LoginPage;

import java.util.concurrent.TimeUnit;

public class TestHomePage {

    WebDriver driver;
    HomePage homepage;
    LoginPage loginpage;
    TestLoginPage testloginpage;
    String urlMoisesLocalMenu = "http://localhost:3000/menu";

    @Before
    public void setupBrowser() {
        driver = new ChromeDriver();
        homepage = new HomePage(driver);
        loginpage = new LoginPage(driver);
        testloginpage = new TestLoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.get(urlMoisesLocalMenu);
        testloginpage.validateContainsText("Home");
    }

    @Test
    public void testClickHomeButton() {
        homepage.clickBttnHome();
    }

    @Test
    public void testClickProdutosButton() {
        homepage.clickBttnProdutos();
    }

    @Test
    public void testClickPessoasButton() {
        homepage.clickBttnPessoas();
    }

    @Test
    public void testClickOperacoesButton() {
        homepage.clickBttnOperacoes();
    }

    @Test
    public void testClickFinanceiroButton() {
        homepage.clickBttnFinanceiro();
    }

    @Test
    public void testClickPromocoesButton() {
        homepage.clickBttnFinanceiro();
        homepage.clickBttnPromocoes();
        testloginpage.validateContainsText("+ Nova Promoção");
    }

    @Test
    public void testClickComunicacaoButton() {
        homepage.clickBttnComunicacao();
    }

    @Test
    public void testClickConfiguracoesButton() {
        homepage.clickBttnSair();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}
