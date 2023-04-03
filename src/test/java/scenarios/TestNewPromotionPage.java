package scenarios;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    String nomeTipoPromocaoComboFixo = "Teste Combo Fixo " + faker.name().username();
    String nomeTipoPromocaoProgressivo = "Teste Progressivo " + faker.name().username();
    String regiaoDeVendas = "B51007";
    String inicioFaixaUm = "1";
    String fimFaixaUm = "3";
    String inicioFaixaDois = "4";
    String fimFaixaDois = "6";
    String porcentagemDescontoFaixaUm = "5";
    String porcentagemDescontoFaixaDois = "8";
    String tipoLimiteQtd = "Quantidade";
    String limiteMaximo = "1000";
    String limiteMinimo = "1";
    String msgPromocaoSucesso = "//h3[contains(text(),'Promoção salva com sucesso')]";
    String msgPromoInativa = "//tbody/tr[1]/td[4]/div[1]/div[1]/h1[1]";
    String containsTextSelecaoUm = "Seleção 1";
    String containsTextSelecao = "Seleção";
    String containsTextSelecaoDois = "Seleção 2";
    String confirmacaoPromocao = "Deseja realmente salvar a promoção com os dados informados?";
    String promocaoSalvaSucesso = "Promoção salva com sucesso";
    String promocaoInativa = "Inativa";
    @Before
    public void setupBrowser(){
        driver = new ChromeDriver();
        sttgsBrowser = new SettingsBrowser(driver);
        newPromotionPage = new NewPromotionPage(driver);
        asserts = new Asserts(driver);
        sttgsBrowser.setupBrowser(urlMoisesNewPromotion);
    }
    @Test
    public void novaPromocaoDescontoAtivo() {
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
    public void novaPromocaoComboInterativoAtivo(){
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
    @Test
    public void novaPromocaoDescontoProgressivoAtivo(){
        newPromotionPage.preencherNomePromocao(nomeTipoPromocaoProgressivo);
        String promocaoCriadaProgressivo = nomeTipoPromocaoProgressivo;
        newPromotionPage.selecionarTipoPromocao();
        newPromotionPage.selecionarPromocaoTipoProgressivo();
        newPromotionPage.selecionarCanal();
        newPromotionPage.selecionarTipoCanalBees();
        newPromotionPage.selecionarRegiaoVendas(regiaoDeVendas);
        newPromotionPage.selecionarSegmentoMercearia();
        newPromotionPage.selecionarDataInicial();
        newPromotionPage.selecionarDataFinal();
        newPromotionPage.selecionarTooglePromocaoAtiva();
        newPromotionPage.clicarBotaoSeguinte();
        asserts.validateContainsText(containsTextSelecao);
        newPromotionPage.selecionaTipoLimiteSelecaoUm(tipoLimiteQtd);
        newPromotionPage.inserirSkuListaUm();
        newPromotionPage.waitClicarBotaoAdicionarSku();
        newPromotionPage.informaInicioDaFaixa(inicioFaixaUm);
        newPromotionPage.informaFimDaFaixa(fimFaixaUm);
        newPromotionPage.inserirPorcentagemDescontoFaixa(porcentagemDescontoFaixaUm);
        newPromotionPage.waitClicarBotaoAdicionarSkuProgressivo();
        newPromotionPage.informaInicioDaFaixa(inicioFaixaDois);
        newPromotionPage.informaFimDaFaixa(fimFaixaDois);
        newPromotionPage.inserirPorcentagemDescontoFaixa(porcentagemDescontoFaixaDois);
        newPromotionPage.waitClicarBotaoAdicionarSkuProgressivo();
        newPromotionPage.waitClicarBotaoSalvarPromocao();
        asserts.validateContainsText(confirmacaoPromocao);
        newPromotionPage.waitClicarBotaoConfirmaPromocao();
        newPromotionPage.waitMsgPromoSalva();
        asserts.validateEqualsText(promocaoSalvaSucesso, msgPromocaoSucesso);
        newPromotionPage.waitClicaBotaoOk();
        newPromotionPage.waitTelaNovaPromo();
        asserts.validateContainsText(promocaoCriadaProgressivo);
    }
    @Test
    public void novaPromocaoComboFixoAtivo(){
        newPromotionPage.preencherNomePromocao(nomeTipoPromocaoComboFixo);
        String promocaoCriadaComboFixo = nomeTipoPromocaoComboFixo;
        newPromotionPage.selecionarTipoPromocao();
        newPromotionPage.selecionarPromocaoTipoComboFixo();
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
        newPromotionPage.inserirSkuListaDois();
        newPromotionPage.waitClicarBotaoAdicionarSku();
        newPromotionPage.waitClicarBotaoSalvarPromocao();
        asserts.validateContainsText(confirmacaoPromocao);
        newPromotionPage.waitClicarBotaoConfirmaPromocao();
        newPromotionPage.waitMsgPromoSalva();
        asserts.validateEqualsText(promocaoSalvaSucesso, msgPromocaoSucesso);
        newPromotionPage.waitClicaBotaoOk();
        newPromotionPage.waitTelaNovaPromo();
        asserts.validateContainsText(promocaoCriadaComboFixo);
    }
    @Test
    public void novaPromocaoComboInterativoAtivoExclusivo(){
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
        newPromotionPage.selecionarTooglePromocaoExclusiva();
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
    @Test
    public void novaPromocaoComboInterativoAtivoExclusivoSkuObrigatorio(){
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
        newPromotionPage.selecionarTooglePromocaoExclusiva();
        newPromotionPage.clicarBotaoSeguinte();
        asserts.validateContainsText(containsTextSelecaoUm);
        newPromotionPage.selecionaTipoLimiteSelecaoUm(tipoLimiteQtd);
        newPromotionPage.informaLimiteMinimo(limiteMinimo);
        newPromotionPage.informaLimiteMaximo(limiteMaximo);
        newPromotionPage.inserirPorcentagemDescontoSelecaoUm();
        newPromotionPage.inserirSkuListaUm();
        newPromotionPage.waitSelecionarToogleSkuObrigatorio();
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
    @Test
    public void novaPromocaoComboInterativoInativo(){
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
        newPromotionPage.selecionarTooglePromocaoExclusiva();
        newPromotionPage.clicarBotaoSeguinte();
        asserts.validateContainsText(containsTextSelecaoUm);
        newPromotionPage.selecionaTipoLimiteSelecaoUm(tipoLimiteQtd);
        newPromotionPage.informaLimiteMinimo(limiteMinimo);
        newPromotionPage.informaLimiteMaximo(limiteMaximo);
        newPromotionPage.inserirPorcentagemDescontoSelecaoUm();
        newPromotionPage.inserirSkuListaUm();
        newPromotionPage.waitSelecionarToogleSkuObrigatorio();
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
        asserts.validateEqualsText(promocaoInativa, msgPromoInativa);
    }
    @After
    public void closeBrowser() {
        sttgsBrowser.closeBrowser();
    }
}
