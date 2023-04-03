package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
public class NewPromotionPage {
    WebDriver driver;
    WebDriverWait wait;
    String NOMEPROMOCAO = "//input[@placeholder='Nome']";
    String SELECIONARPROMOCAO = "//div[@id='__next']//form[1]//div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]";
    String TIPOPROMOCAODESCONTO = "//div[contains(text(),'Desconto')]";
    String TIPOPROMOCAOCOMBO = "//div[contains(text(),'Combo')]";
    String TIPOPROMOCAOPROGRESSIVO = "//div[contains(text(),'Progressivo')]";
    String TIPOPROMOCAOCOMBOFIXO = "//div[contains(text(),'Combo Fixo')]";
    String SELECIONARTIPOCANAL = "//div[@id='__next']/main[1]//form[1]//div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]";
    String TIPOCANALBEES = "//span[contains(text(),'Bees')]";
    String SELECIONAREGIAODEVENDAS = "//input[@id='react-select-id_region-input']";
    String SELECIONASEGMENTO = "//span[contains(text(),'Selecione...')]";
    String SELECIONASEGMENTOMERCQUIT = "//span[contains(text(),'MERCEARIA/QUITANDA')]";
    String DATAINICIAL = "//input[@placeholder='Data Inicial']";
    String DATAFINAL = "//input[@placeholder='Data Final']";
    String TOGGLEPROMOCAOATIVA = "//label[contains(text(),'Promoção Ativa')]";
    String TOGGLEPROMOCAOEXCLUSIVA = "//label[contains(text(),'Promoção Exclusiva')]";
    String TOOGLESKUOBRIGATORIO = "//label[contains(text(),'Sku Obrigatório')]";
    String BOTAOSEGUINTE = "//span[contains(text(),'Seguinte')]";
    String TIPODELIMITESELECAOUM = "//input[@id='react-select-itemsPromotions.0.limit_type-input']";
    String TIPODELIMITESELECAODOIS = "//input[@id='react-select-itemsPromotions.1.limit_type-input']";
    String LIMITEMAXIMO = "//input[@placeholder='Ex. 12 caixas']";
    String LIMITEMINIMO = "//input[@placeholder='Ex. 2 caixas']";
    String INICIODAFAIXA = "//input[@placeholder='Inicio da Faixa']";
    String FIMDAFAIXA = "//input[@placeholder='Fim da Faixa']";
    String PORCENTAGEMDESCONTO = "//input[@placeholder='Ex. 30%']";
    String PORCENTAGEMDESCONTOFAIXAUM = "//input[@placeholder='Desconto aplicado para a faixa']";
    String INSERIRSKULISTAUM = "//input[@id='react-select-3-input']";
    String INSERIRSKULISTADOIS = "//input[@id='react-select-itemsPromotions.1.limit_type-input']";
    String BOTAOADICIONARSKU = "//span[contains(text(),'Adicionar')]";
    String BOTAOADICIONARPROGRESSIVO = "//div[2]//ul[1]//div[3]//div[4]/button[1]";
    String BOTAONOVOITEM = "//button[contains(text(),'Novo Item')]";
    String BOTAOSALVARPROMOCAO = "//span[contains(text(),'Salvar Promoção')]";
    String BOTAOCONFIRMARPROMOCAO = "//div[6]//div[2]//div[1]/button[1]";
    String BOTAOOK= "//button[contains(text(),'OK')]";
    String MSGPROMOSUCESSO = "//h3[contains(text(),'Promoção salva com sucesso')]";
    String CAMPOTELAPROMO ="//th[contains(text(),'Nome')]";

    public NewPromotionPage(WebDriver driver) {
        this.driver = driver;
    }
    public String[] porcentagensValidasListaUm(){
        String[] PORCENTAGEMVALIDA = new String[4];

        PORCENTAGEMVALIDA[0] = "3";
        PORCENTAGEMVALIDA[1] = "5";
        PORCENTAGEMVALIDA[2] = "7";
        PORCENTAGEMVALIDA[3] = "9";

        return PORCENTAGEMVALIDA;
    }
    public String[] porcentagensValidasListaDois(){
        String[] PORCENTAGEMVALIDA = new String[4];

        PORCENTAGEMVALIDA[0] = "4";
        PORCENTAGEMVALIDA[1] = "6";
        PORCENTAGEMVALIDA[2] = "8";
        PORCENTAGEMVALIDA[3] = "10";

        return PORCENTAGEMVALIDA;
    }
    public String[] skusValidosListaUm(){
        String[] SKUSVALIDOSLISTA1 = new String[5];

        SKUSVALIDOSLISTA1[0] = "000000000000024245";
        SKUSVALIDOSLISTA1[1] = "Mini Salame Italiano Sadia Caixa 6kg";
        SKUSVALIDOSLISTA1[2] = "000000000000031917";
        SKUSVALIDOSLISTA1[3] = "Coxa de Frango Sadia 1kg -Caixa c/12";
        SKUSVALIDOSLISTA1[4] = "000000000000044601";

        return SKUSVALIDOSLISTA1;
    }
    public String[] skusValidosListaDois(){
        String[] SKUSVALIDOSLISTA2 = new String[5];

        SKUSVALIDOSLISTA2[0] = "Chester Desossado Congelado Perdigão Caixa 16kg";
        SKUSVALIDOSLISTA2[1] = "000000000000193596";
        SKUSVALIDOSLISTA2[2] = "Mortadela Sadia de Frango 400g -Caixa c/15";
        SKUSVALIDOSLISTA2[3] = "000000000000239698";
        SKUSVALIDOSLISTA2[4] = "Pizza Lombo com Requeijão e Mussarela Sadia 460g -Caixa c/12";

        return SKUSVALIDOSLISTA2;
    }
    public void preencherNomePromocao(String nomeTipoPromocao) {
        boolean campoNomePromocao = false;

        while (!campoNomePromocao) {
            try {
                driver.findElement(By.xpath(NOMEPROMOCAO)).sendKeys(nomeTipoPromocao);
                campoNomePromocao = true;
            } catch (Exception e) {
                campoNomePromocao = false;
            }
        }
        //driver.findElement(By.xpath(NOMEPROMOCAO)).sendKeys(nomeTipoPromocao);
    }
    public void selecionarTipoPromocao() {
        driver.findElement(By.xpath(SELECIONARPROMOCAO)).click();
    }
    public void selecionarPromocaoTipoDesconto() {
        driver.findElement(By.xpath(TIPOPROMOCAODESCONTO)).click();
    }
    public void selecionarPromocaoTipoCombo() {
        driver.findElement(By.xpath(TIPOPROMOCAOCOMBO)).click();
    }
    public void selecionarPromocaoTipoProgressivo() {
        driver.findElement(By.xpath(TIPOPROMOCAOPROGRESSIVO)).click();
    }
    public void selecionarPromocaoTipoComboFixo() {
        driver.findElement(By.xpath(TIPOPROMOCAOCOMBOFIXO)).click();
    }
    public void selecionarCanal() {
        driver.findElement(By.xpath(SELECIONARTIPOCANAL)).click();
    }
    public void selecionarTipoCanalBees() {
        driver.findElement(By.xpath(TIPOCANALBEES)).click();
        driver.findElement(By.xpath(SELECIONARTIPOCANAL)).click();
    }
    public void selecionarRegiaoVendas(String regiaoVendas){
        driver.findElement(By.xpath(SELECIONAREGIAODEVENDAS)).sendKeys(regiaoVendas, Keys.RETURN);
    }
    public void selecionarSegmentoMercearia(){
        driver.findElement(By.xpath(SELECIONASEGMENTO)).click();
        driver.findElement(By.xpath(SELECIONASEGMENTOMERCQUIT)).click();
    }
    public void selecionarDataInicial(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        driver.findElement(By.xpath(DATAINICIAL)).sendKeys(dtf.format(now));
    }
    public void selecionarDataFinal(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime aft = now.plusDays(2);
        driver.findElement(By.xpath(DATAFINAL)).sendKeys(dtf.format(aft));
    }
    public void selecionarTooglePromocaoAtiva(){
        driver.findElement(By.xpath(TOGGLEPROMOCAOATIVA)).click();
    }
    public void selecionarTooglePromocaoExclusiva(){
        driver.findElement(By.xpath(TOGGLEPROMOCAOEXCLUSIVA)).click();
    }
    public void waitSelecionarToogleSkuObrigatorio(){
        boolean btnToogleSkuObg = false;

        while (!btnToogleSkuObg) {
            try {
                driver.findElement(By.xpath(TOOGLESKUOBRIGATORIO)).click();
                btnToogleSkuObg = true;
            } catch (Exception e) {
                btnToogleSkuObg = false;
            }
        }
    }
    public void clicarBotaoSeguinte(){
        driver.findElement(By.xpath(BOTAOSEGUINTE)).click();
    }
    public void selecionaTipoLimiteSelecaoUm(String tipoLimite){
        driver.findElement(By.xpath(TIPODELIMITESELECAOUM)).sendKeys(tipoLimite, Keys.RETURN);
    }
    public void selecionaTipoLimiteSelecaoDois(String tipoLimite){
        driver.findElement(By.xpath(TIPODELIMITESELECAODOIS)).sendKeys(tipoLimite, Keys.RETURN);
    }
    public void informaLimiteMaximo(String limiteMaximo){
        driver.findElement(By.xpath(LIMITEMAXIMO)).sendKeys(limiteMaximo);
    }
    public void informaLimiteMinimo(String limiteMinimo){
        driver.findElement(By.xpath(LIMITEMINIMO)).sendKeys(limiteMinimo);
    }
    public void informaInicioDaFaixa(String inicioDaFaixa){
        driver.findElement(By.xpath(INICIODAFAIXA)).clear();
        driver.findElement(By.xpath(INICIODAFAIXA)).sendKeys(inicioDaFaixa);
    }
    public void informaFimDaFaixa(String fimDaFaixa){
        driver.findElement(By.xpath(FIMDAFAIXA)).clear();
        driver.findElement(By.xpath(FIMDAFAIXA)).sendKeys(fimDaFaixa);
    }
    public void inserirPorcentagemDescontoSelecaoUm(){
        int valorDesconto = new Random().nextInt(4);
        String porcentagensDesconto = porcentagensValidasListaUm()[valorDesconto];
        driver.findElement(By.xpath(PORCENTAGEMDESCONTO)).sendKeys(porcentagensDesconto);
    }
    public void inserirPorcentagemDescontoFaixa(String porcentagemDescontoFaixaUm){
        driver.findElement(By.xpath(PORCENTAGEMDESCONTOFAIXAUM)).clear();
        driver.findElement(By.xpath(PORCENTAGEMDESCONTOFAIXAUM)).sendKeys(porcentagemDescontoFaixaUm);
    }
    public void inserirPorcentagemDescontoSelecaoDois(){
        int valorDesconto = new Random().nextInt(4);
        String porcentagensDesconto = porcentagensValidasListaDois()[valorDesconto];
        driver.findElement(By.xpath(PORCENTAGEMDESCONTO)).sendKeys(porcentagensDesconto);
    }
    public void inserirSkuListaUm(){
        int skuValido = new Random().nextInt(5);
        String skusValidos = skusValidosListaUm()[skuValido];
        driver.findElement(By.xpath(INSERIRSKULISTAUM)).sendKeys(skusValidos, Keys.RETURN);
    }
    public void inserirSkuListaDois(){
        int skuValido = new Random().nextInt(5);
        String skusValidos = skusValidosListaDois()[skuValido];
        driver.findElement(By.xpath(INSERIRSKULISTADOIS)).sendKeys(skusValidos, Keys.RETURN);
    }
    public void waitClicarBotaoAdicionarSku(){
        boolean btnAdicionarSkuClickable = false;

        while (!btnAdicionarSkuClickable) {
            try {
                driver.findElement(By.xpath(BOTAOADICIONARSKU)).click();
                btnAdicionarSkuClickable = true;
            } catch (Exception e) {
                btnAdicionarSkuClickable = false;
            }
        }
    }
    public void waitClicarBotaoAdicionarSkuProgressivo(){
        boolean btnAdicionarSkuClickable = false;

        while (!btnAdicionarSkuClickable) {
            try {
                driver.findElement(By.xpath(BOTAOADICIONARPROGRESSIVO)).click();
                btnAdicionarSkuClickable = true;
            } catch (Exception e) {
                btnAdicionarSkuClickable = false;
            }
        }
    }
    public void clicarBotaoNovoItem(){
        boolean btnAdicionarNovoItem = false;

        while (!btnAdicionarNovoItem) {
            try {
                driver.findElement(By.xpath(BOTAONOVOITEM)).click();
                btnAdicionarNovoItem = true;
            } catch (Exception e) {
                btnAdicionarNovoItem = false;
            }
        }
    }
    public void waitClicarBotaoSalvarPromocao(){
        boolean btnSalvarClickable = false;

        while (!btnSalvarClickable) {
            try {
                driver.findElement(By.xpath(BOTAOSALVARPROMOCAO)).click();
                btnSalvarClickable = true;
            } catch (Exception e) {
                btnSalvarClickable = false;
            }
        }
    }
    public void waitClicarBotaoConfirmaPromocao(){
        wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BOTAOCONFIRMARPROMOCAO)));
        element.click();
    }
    public void waitMsgPromoSalva(){
        wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MSGPROMOSUCESSO)));
        element.isEnabled();
    }
    public void waitClicaBotaoOk(){
        wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BOTAOOK)));
        element.click();
    }
    public void waitTelaNovaPromo(){
        wait = new WebDriverWait(driver, 20);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CAMPOTELAPROMO)));
        element.isDisplayed();
    }

}
