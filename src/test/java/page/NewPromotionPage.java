package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class NewPromotionPage {

    WebDriver driver;
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
    String BOTAOSEGUINTE = "//button[contains(text(),'Seguinte')]";
    String TIPODELIMITE = "//input[@id='react-select-itemsPromotions.0.limit_type-input']";
    String LIMITEMAXIMO = "//input[@placeholder='Limite Máximo']";
    String LIMITEMINIMO = "//input[@placeholder='Limite Mínimo']";
    String PORCENTAGEMDESCONTO = "//input[@placeholder='Porcentagem de Desconto']";
    String INSERIRSKU = "//input[@id='react-select-skuFreegood-input']";
    String BOTAOADICIONARSKU = "//button[contains(text(),'Adicionar SKU')]";
    String BOTAOSALVARPROMOCAO = "//div[1]/div[2]/form[1]/div[4]//button[1]";
    String BOTAOCONFIRMARPROMOCAO = "//div[5]//div[2]/div[1]/div[1]/button[1]";
    String BOTAOOK= "//button[contains(text(),'OK')]";

    public NewPromotionPage(WebDriver driver) {
        this.driver = driver;
    }
    public String[] porcentagensValidas(){
        String[] PORCENTAGEMVALIDA = new String[4];

        PORCENTAGEMVALIDA[0] = "3";
        PORCENTAGEMVALIDA[1] = "5";
        PORCENTAGEMVALIDA[2] = "7";
        PORCENTAGEMVALIDA[3] = "9";

        return PORCENTAGEMVALIDA;
    }

    public String[] skusValidosListaUm(){
        String[] SKUSVALIDOSLISTA1 = new String[5];

        SKUSVALIDOSLISTA1[0] = "000000000000024245";
        SKUSVALIDOSLISTA1[1] = "000000000000031119";
        SKUSVALIDOSLISTA1[2] = "000000000000031917";
        SKUSVALIDOSLISTA1[3] = "000000000000031941";
        SKUSVALIDOSLISTA1[4] = "000000000000044601";

        return SKUSVALIDOSLISTA1;
    }
    public String[] skusValidosListaDois(){
        String[] SKUSVALIDOSLISTA2 = new String[5];

        SKUSVALIDOSLISTA2[0] = "000000000000104373";
        SKUSVALIDOSLISTA2[1] = "000000000000193596";
        SKUSVALIDOSLISTA2[2] = "000000000000239669";
        SKUSVALIDOSLISTA2[3] = "000000000000239698";
        SKUSVALIDOSLISTA2[4] = "000000000000293873";

        return SKUSVALIDOSLISTA2;
    }

    public void preencherNomePromocao(String nomeTipoPromocao) {
        driver.findElement(By.xpath(NOMEPROMOCAO)).sendKeys(nomeTipoPromocao);
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
    public void clicarBotaoSeguinte(){
        driver.findElement(By.xpath(BOTAOSEGUINTE)).click();
    }
    public void selecionaTipoLimite(String tipoLimite){
        driver.findElement(By.xpath(TIPODELIMITE)).sendKeys(tipoLimite, Keys.RETURN);
    }
    public void informaLimiteMaximo(String limiteMaximo){
        driver.findElement(By.xpath(LIMITEMAXIMO)).sendKeys(limiteMaximo);
    }
    public void informaLimiteMinimo(String limiteMinimo){
        driver.findElement(By.xpath(LIMITEMINIMO)).sendKeys(limiteMinimo);
    }
    public void inserirPorcentagemDesconto(){
        int valorDesconto = new Random().nextInt(4);
        String porcentagensDesconto = porcentagensValidas()[valorDesconto];
        driver.findElement(By.xpath(PORCENTAGEMDESCONTO)).sendKeys(porcentagensDesconto);
    }
    public void inserirSkuLista1(){
        int skuValido = new Random().nextInt(5);
        String skusValidos = skusValidosListaUm()[skuValido];
        driver.findElement(By.xpath(INSERIRSKU)).sendKeys(skusValidos, Keys.RETURN);
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
        boolean btnConfirmaPromocaoClickable = false;

        while (!btnConfirmaPromocaoClickable) {
            try {
                driver.findElement(By.xpath(BOTAOCONFIRMARPROMOCAO)).click();
                btnConfirmaPromocaoClickable = true;
            } catch (Exception e) {
                btnConfirmaPromocaoClickable = false;
            }
        }
    }
    public void waitClicaBotaoOk(){
        boolean btnOkClickable = false;

        while (!btnOkClickable) {
            try {
                driver.findElement(By.xpath(BOTAOOK)).click();
                btnOkClickable = true;
            } catch (Exception e) {
                btnOkClickable = false;
            }
        }
    }



}
