package scenarios;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;
import page.NewPromotionPage;

import java.util.concurrent.TimeUnit;

public class TestNewPromotionPage {
    WebDriver driver;
    Faker faker = new Faker();
    NewPromotionPage newPromotionPage;
    String urlMoisesNewPromotion = "http://localhost:3000/financial/promotions/new";
    String urlMoisesPromotion = "http://localhost:3000/financial/promotions";
    String nomeTipoPromocaoDesconto = "Teste Desconto " + faker.name().username();
    String regiaoDeVendas = "B51007";
    String tipoLimiteQtd = "Quantidade";
    String limiteMaximo = "1000";
    String limiteMinimo = "1";
    String msgPromocaoSucesso = "//h3[contains(text(),'Promoção salva com sucesso')]";
    String containsTextSelecao = "Seleção 1";
    String confirmacaoPromocao = "Deseja realmente salvar a promoção com os dados informados?";
    String promocaoSalvaSucesso = "Promoção salva com sucesso";
    @Before
    public void setupBrowser(){
        driver = new ChromeDriver();
        newPromotionPage = new NewPromotionPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.get(urlMoisesNewPromotion);
        validateContainsText("Nova Promoção");
    }

    @Test
    public void novaPromocaoDescontoAtiva() throws InterruptedException {
        newPromotionPage.preencherNomePromocao(nomeTipoPromocaoDesconto);
        String promocaoCriada = nomeTipoPromocaoDesconto;
        newPromotionPage.selecionarTipoPromocao();
        newPromotionPage.selecionarPromocaoTipoDesconto();
        newPromotionPage.selecionarCanal();
        newPromotionPage.selecionarTipoCanalBees();
        newPromotionPage.selecionarRegiaoVendas(regiaoDeVendas);
        newPromotionPage.selecionarSegmentoMercearia();
        newPromotionPage.selecionarDataInicial();
        newPromotionPage.selecionarDataFinal();
        newPromotionPage.selecionarTooglePromocaoAtiva();
        newPromotionPage.clicarBotaoSeguinte();
        validateContainsText(containsTextSelecao);
        newPromotionPage.selecionaTipoLimite(tipoLimiteQtd);
        newPromotionPage.informaLimiteMaximo(limiteMaximo);
        newPromotionPage.informaLimiteMinimo(limiteMinimo);
        newPromotionPage.inserirPorcentagemDesconto();
        newPromotionPage.inserirSkuLista1();
        newPromotionPage.waitClicarBotaoAdicionarSku();
        newPromotionPage.waitClicarBotaoSalvarPromocao();
        validateContainsText(confirmacaoPromocao);
        Thread.sleep(1500);
        newPromotionPage.waitClicarBotaoConfirmaPromocao();
        Thread.sleep(1500);
        validateEqualsText(promocaoSalvaSucesso, msgPromocaoSucesso);
        newPromotionPage.waitClicaBotaoOk();
        driver.get(urlMoisesPromotion);
        validateContainsText(promocaoCriada);
    }
    @Test
    public void test(){
        newPromotionPage.selecionarRegiaoVendas(regiaoDeVendas);
    }

    public void validateContainsText(String textContains){
        Assert.assertTrue(driver.getPageSource().contains(textContains));
    }

    public void validateEqualsText(String msgEsperada, String equalsText){
        Assert.assertEquals(msgEsperada, driver.findElement(By.xpath(equalsText)).getText());
    }
    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

}
