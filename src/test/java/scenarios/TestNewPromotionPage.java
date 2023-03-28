package scenarios;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.NewPromotionPage;
import seleniumUtils.*;

public class TestNewPromotionPage {
    WebDriver driver;
    Faker faker = new Faker();
    SettingsBrowser sttgsBrowser;
    Asserts asserts;
    NewPromotionPage newPromotionPage;
    String urlMoisesNewPromotion = "http://localhost:3000/financial/promotions/new";
    String nomeTipoPromocaoDesconto = "Teste Desconto " + faker.name().username();
    String nomeTipoPromocaoCombo = "Teste Combo " + faker.name().username();
    String regiaoDeVendas = "B51007";
    String tipoLimiteQtd = "Quantidade";
    String limiteMaximo = "1000";
    String limiteMinimo = "1";
    String msgPromocaoSucesso = "//h3[contains(text(),'Promoção salva com sucesso')]";
    String containsTextSelecaoUm = "Seleção 1";
    String containsTextSelecaoDois = "Seleção 2";
    String confirmacaoPromocao = "Deseja realmente salvar a promoção com os dados informados?";
    String promocaoSalvaSucesso = "Promoção salva com sucesso";
    @Before
    public void setupBrowser(){
        driver = new ChromeDriver();
        sttgsBrowser = new SettingsBrowser(driver);
        newPromotionPage = new NewPromotionPage(driver);
        asserts = new Asserts(driver);
        sttgsBrowser.setupBrowser(urlMoisesNewPromotion);
    }
    @Test
    public void novaPromocaoDescontoAtiva() {
        newPromotionPage.preencherNomePromocao(nomeTipoPromocaoDesconto);
        String promocaoCriadaDesconto = nomeTipoPromocaoDesconto;
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
        asserts.validateContainsText(containsTextSelecaoUm);
        newPromotionPage.selecionaTipoLimiteSelecaoUm(tipoLimiteQtd);
        newPromotionPage.informaLimiteMinimo(limiteMinimo);
        newPromotionPage.informaLimiteMaximo(limiteMaximo);
        newPromotionPage.inserirPorcentagemDescontoSelecaoUm();
        newPromotionPage.inserirSkuListaUm();
        newPromotionPage.waitClicarBotaoAdicionarSku();
        newPromotionPage.waitClicarBotaoSalvarPromocao();
        asserts.validateContainsText(confirmacaoPromocao);
        newPromotionPage.waitClicarBotaoConfirmaPromocao();
        newPromotionPage.waitMsgPromoSalva();
        asserts.validateEqualsText(promocaoSalvaSucesso, msgPromocaoSucesso);
        newPromotionPage.waitClicaBotaoOk();
        newPromotionPage.waitTelaNovaPromo();
        asserts.validateContainsText(promocaoCriadaDesconto);
    }
    @Test
    public void novaPromocaoComboInterativoAtiva(){
        newPromotionPage.preencherNomePromocao(nomeTipoPromocaoCombo);
        String promocaoCriadaCombo = nomeTipoPromocaoCombo;
        newPromotionPage.selecionarTipoPromocao();
        newPromotionPage.selecionarPromocaoTipoCombo();
        newPromotionPage.selecionarCanal();
        newPromotionPage.selecionarTipoCanalBees();
        newPromotionPage.selecionarRegiaoVendas(regiaoDeVendas);
        newPromotionPage.selecionarSegmentoMercearia();
        newPromotionPage.selecionarDataInicial();
        newPromotionPage.selecionarDataFinal();
        newPromotionPage.selecionarTooglePromocaoAtiva();
        newPromotionPage.clicarBotaoSeguinte();
        asserts.validateContainsText(containsTextSelecaoUm);
        newPromotionPage.selecionaTipoLimiteSelecaoUm(tipoLimiteQtd);
        newPromotionPage.informaLimiteMinimo(limiteMinimo);
        newPromotionPage.informaLimiteMaximo(limiteMaximo);
        newPromotionPage.inserirPorcentagemDescontoSelecaoUm();
        newPromotionPage.inserirSkuListaUm();
        newPromotionPage.waitClicarBotaoAdicionarSku();
        newPromotionPage.clicarBotaoNovoItem();
        asserts.validateContainsText(containsTextSelecaoDois);
        newPromotionPage.selecionaTipoLimiteSelecaoDois(tipoLimiteQtd);
        newPromotionPage.informaLimiteMinimo(limiteMinimo);
        newPromotionPage.informaLimiteMaximo(limiteMaximo);
        newPromotionPage.inserirPorcentagemDescontoSelecaoDois();
        newPromotionPage.inserirSkuListaDois();
        newPromotionPage.waitClicarBotaoAdicionarSku();
        newPromotionPage.waitClicarBotaoSalvarPromocao();
        asserts.validateContainsText(confirmacaoPromocao);
        newPromotionPage.waitClicarBotaoConfirmaPromocao();
        newPromotionPage.waitMsgPromoSalva();
        asserts.validateEqualsText(promocaoSalvaSucesso, msgPromocaoSucesso);
        newPromotionPage.waitClicaBotaoOk();
        newPromotionPage.waitTelaNovaPromo();
        asserts.validateContainsText(promocaoCriadaCombo);
    }
    @After
    public void closeBrowser() {
        sttgsBrowser.closeBrowser();
    }

}
