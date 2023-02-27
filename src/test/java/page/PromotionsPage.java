package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PromotionsPage {
    WebDriver driver;
    String PESQUISAR = "//input[@placeholder='Pesquisar...']";
    String NOVAPROMOCAO = "//h1[contains(text(),'+ Nova Promoção')]";
    String FILTROS = "//h1[contains(text(),'Filtros')]";
    String DUPLICAR = "//tr[1]/td[5]/div[1]/button[1]/*[1]";
    String EDITAR = "//tr[1]/td[5]/div[1]/a[1]/button[1]/*[1]";
    String EXCLUIR = "//tr[2]/td[5]//button[2]/*[1]";

    public PromotionsPage(WebDriver driver){
        this.driver = driver;
    }
    public void fillBttnPesquisar(String texto){
        driver.findElement(By.xpath(PESQUISAR)).sendKeys(texto);
        driver.findElement(By.xpath(PESQUISAR)).submit();
    }

    public void clickBttnNovaPromocao(){
        driver.findElement(By.xpath(NOVAPROMOCAO)).click();
    }

    public void clickBttnFiltros(){
        driver.findElement(By.xpath(FILTROS)).click();
    }

    public void clickBttnDuplicar() {
        driver.findElement(By.xpath(DUPLICAR)).click();
    }

    public void clickBttnEditar(){
        driver.findElement(By.xpath(EDITAR)).click();
    }

    public void clickBttnExcluir(){
        driver.findElement(By.xpath(EXCLUIR)).click();
    }
}
